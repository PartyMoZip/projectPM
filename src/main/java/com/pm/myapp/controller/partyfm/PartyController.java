package com.pm.myapp.controller.partyfm;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyDTO;
import com.pm.myapp.domain.PartyUserVO;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.service.partyfm.PartyService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@RequestMapping("/party")
@Controller
public class PartyController {
	
	private String basePath;
	
	@Setter(onMethod_= {@Autowired})
	private PartyService service;
	
	// 파티 상세 보기 [작동]
	@GetMapping("/showdetail")
	public void showPartyDetail(Integer partyCode, Model model) {
		log.debug("showPartyDetail({}) invoked.",partyCode);
		PartyVO party = this.service.getParty(partyCode);
		log.info("\t + party : {}", party);
		
		model.addAttribute("__PARTY__",party);
		
	} // showPartyDetail
	
	// 파티 가입 신청 [작동]
	@PostMapping("/do-party-join")
	public String doPartyJoin(String email, Integer partyCode, RedirectAttributes rttrs) {
		log.debug("doPartyJoin({}, {}) invoked.",email,partyCode);
		
		boolean result = this.service.doJoin(email, partyCode);
		log.info("\t + result : {}",result);

		rttrs.addAttribute("partyCode",partyCode);
		
		return "redirect:/party/leaderpage";
		
	} // doPartyJoin
	
	// 파티 가입 취소 [작동]
	@PostMapping("/undo-party-join")
	public String undoPartyJoin(String email, Integer partyCode, RedirectAttributes rttrs) {
		log.debug("undoPartyJoin({}, {}) invoked.",email,partyCode);
		
		boolean result = this.service.undoJoin(email, partyCode);
		log.info("\t + result : {}",result);
		
		rttrs.addAttribute("partyCode",partyCode);
		
		return "redirect:/party/leaderpage";

	} // undoPartyJoin
	
	// 파티 메인 보기 [작동]
	@GetMapping("/showmain")
	public void showPartyMain(Integer partyCode, Model model) {
		log.debug("showPartyMain({}) invoked.",partyCode);
		PartyVO party = this.service.getParty(partyCode);
		log.info("\t + party : {}", party);
		
		model.addAttribute("__PARTY__",party);

	} // showPartyMain
	
	// 파티 관리 페이지 [작동]
	@GetMapping("/leaderpage")
	public void showLeaderPage(Integer partyCode, Model model) {
		log.debug("showLeaderPage({}) invoked.",partyCode);
		PartyVO party = this.service.getParty(partyCode);
		log.info("\t + party : {}", party);
		
		model.addAttribute("__PARTY__",party);
		
	} // showLeaderPage
	
	// 파티 로고 등록/변경 [작동]
	@PostMapping("/editpl")
	public String editPartyLogo(MultipartFile image, Integer partyCode, RedirectAttributes rttrs) throws IllegalStateException, IOException {
		
		log.debug("editPartyLogo({}, {}) invoked.",image, partyCode);
		
		// 파티별, 날짜별 폴더를 생성 후 그림 파일 업로드
		// 날짜 GET
		Calendar cal = Calendar.getInstance();
		String year = cal.get(cal.YEAR) + "";
		String month = (cal.get(cal.MONTH)+1) + "";
		String date = cal.get(cal.DATE) + "";
		

		basePath = "C:/ProjectPM/ImageUpload/PartyLogo/"; // servlet-context.xml 에 mapping 필수
		String newfolder = partyCode + year + month + date; // 파티코드와 날짜 합쳐서 새로운 폴더 준비
		String newBasePath = basePath + newfolder; // 파일이 저장되는 최종 경로
		log.debug("\t+ newBasePath : {}",newBasePath);
		
		// 최종경로의 폴더 존재 여부를 결정하는 작업
		File folder = new File(newBasePath);
		
		if(!folder.exists()) {
			// 폴더가 없다면 생성하고 진행
			folder.mkdir();
			log.info("폴더 생성 완료! 경로 : {}",newBasePath);
			
		}else {
			// 폴더가 있다면 진행
			log.info("이미 존재하는 경로이므로 이미지 업로드를 진행합니다.");
			
		} // if-else
		
		// 실제 파일 업로드
		// 랜덤값을 더해서 중복되지 않는 파일명을 만들고
		// 그 파일명을 DB 에 저장할 것
		UUID uuid = UUID.randomUUID(); // 랜덤값으로 중복되지않는 파일명을 만들 것 (10의 38승의 확률)
		String originalName = image.getOriginalFilename(); // 파일의 원래 이름
		String newName =  uuid + image.getOriginalFilename(); // 랜덤값 + 파일의 원래이름 으로 새파일 저장
		log.info("\t+ originalName : {}",originalName);
		
		// 위에서 만든 경로와 파일명을 지정해서 전송해줌
		File targetPath = new File(newBasePath + "/" + newName);
		image.transferTo(targetPath);
		// 실제 이미지 업로드 작업 끝
		
		// DB에 이미지 정보 저장하기
		// HashMap을 이용하여 DTO 처럼 사용할 예정
		// Mapper.xml 에 갔을 때 key를 입력하면 value 값이 들어감
		// value의 타입이 object인건 value의 타입이 모두 같은것이 아니기 때문
		Map<String, Object> imageInfo = new HashMap<String, Object>();
		imageInfo.put("oldFilename", originalName); // 기존 파일 이름
		imageInfo.put("newFilename", newName); // 새로운 파일 이름
		imageInfo.put("fileLocation", newfolder + "/" + newName);
		// mvc mapping 을 제외한 주소와 파일 이름
		imageInfo.put("partyCode", partyCode);
		
		boolean result = this.service.editLogo(imageInfo);
		log.info("\t + result : {}",result);
		
		rttrs.addAttribute("partyCode", partyCode);
		
		return "redirect:/party/leaderpage";

	} // editPartyLogo
	
	// 파티 이미지 등록/변경 [작동]
	@PostMapping("/editpi")
	public String editPartyMainImage(MultipartFile image, Integer partyCode, RedirectAttributes rttrs) throws IllegalStateException, IOException{
		log.debug("editPartyImage({}, {}) invoked.",image,partyCode);
		
		// 파티별, 날짜별 폴더를 생성 후 그림 파일 업로드
		// 날짜 GET
		Calendar cal = Calendar.getInstance();
		String year = cal.get(cal.YEAR) + "";
		String month = (cal.get(cal.MONTH)+1) + "";
		String date = cal.get(cal.DATE) + "";
		
		// 파티코드와 날짜 합치기
		basePath = "C:/ProjectPM/ImageUpload/PartyMainImage/";
		String newfolder = partyCode + year + month + date;
		String newBasePath = basePath + newfolder;
		log.debug("\t+ newBasePath : {}",newBasePath);
		
		File folder = new File(newBasePath);
		
		if(!folder.exists()) {
			
			folder.mkdir();
			log.info("폴더 생성 완료! 경로 : {}",newBasePath);
			
		}else {
			
			log.info("이미 존재하는 경로이므로 이미지 업로드를 진행합니다.");
			
		} // if-else
		
		// 실제 파일 업로드
		UUID uuid = UUID.randomUUID(); // 랜덤값으로 이미지의 무결성 형성 (10의 38승의 확률)
		String originalName = image.getOriginalFilename();
		String newName =  uuid + image.getOriginalFilename();
		log.info("\t+ 암호화된 이미지 파일 이름 : {}",newName);
		
		File targetPath = new File(newBasePath + "/" + newName);
		image.transferTo(targetPath);
		
		// DB에 이미지 정보 저장
		Map<String, Object> imageInfo = new HashMap<String, Object>();
		imageInfo.put("oldFilename", originalName);
		imageInfo.put("newFilename", newName);
		imageInfo.put("fileLocation", newfolder + "/" + newName);
		imageInfo.put("partyCode", partyCode);
		
		boolean result = this.service.editPartyMainImage(imageInfo);
		log.info("\t + result : {}",result);
		
		// 나중에 비동기로 실패,확인 메세지 처리 할 예정
		rttrs.addAttribute("partyCode", partyCode);
		
		return "redirect:/party/leaderpage";
		
	} // editPartyImage
	
	// 파티 정보 변경 [작동]
	@PostMapping("/editparty")
	public String editParty(PartyDTO dto, RedirectAttributes rttrs) {
		log.debug("editParty({}, {}) invoked.",dto);
		
		boolean result = this.service.editInfo(dto);
		log.info("\t + result : {}", result);
		
		int partyCode = dto.getPartyCode();

		rttrs.addAttribute("partyCode",partyCode);
		
		return "redirect:/party/leaderpage";
		
	} // editParty
	
	// 파티 해체 [작동]
	@PostMapping("/dobreak")
	public String doBreakParty(Integer partyCode, RedirectAttributes rttrs) {
		log.debug("doBreakParty({}) invoked.",partyCode);
		// 신고수 -1로 만들기
		
		boolean result = this.service.breakParty(partyCode);
		log.info("\t + result : {}",result);
		
		rttrs.addAttribute("partyCode",partyCode);
		
		return "redirect:/party/leaderpage";

	} // doBreakParty
		
	// 파티장 권한 위임 [작동] - 트랜잭션 작동안함
	@PostMapping("/editleader")
	@Transactional
	public String editPartyLeader(
			String leaderEmail, String memberEmail,
			Integer partyCode, RedirectAttributes rttrs) {
		log.debug("editPartyLeader({}, {}, {}) invoked.",leaderEmail,memberEmail,partyCode);
		// 대상 인물 : 권한코드 2 ( 파티장 )
		// 기존 파티장 : 권한코드 1 ( 파티원 )
		boolean result1 = this.service.editPL(1, leaderEmail, partyCode);
		boolean result2 = this.service.editPL(2, memberEmail, partyCode);
		log.info("\t + result1 & result2 : {} & {}",result1, result2);

		rttrs.addAttribute("partyCode",partyCode);
		
		return "redirect:/party/showmain";
		
	} // editPartyLeader
	
	// 파티 가입 승인 [작동]
	@PostMapping("/do-accept-join")
	public void doAcceptJoin(String email, Integer partyCode) {
		log.debug("doAcceptJoin({}, {}) invoked.",email,partyCode);
		// 권한코드 -1 인지 확인 : 권한코드 1로 변경
		
		boolean result = this.service.acceptJoin(email, partyCode);
		log.info("\t + result : {}",result);

	} // doAcceptJoin
	
	// 파티 가입 거절 [작동]
	@PostMapping("/do-reject-join")
	public void doRejectJoin(String email, Integer partyCode) {
		log.debug("doRejectJoin({}, {}) invoked.",email,partyCode);
		// 해당 이메일인지 : 해당 컬럼 삭제
		
		boolean result = this.service.rejectJoin(email, partyCode);
		log.info("\t + result : {}",result);
		
	} // doRejectJoin
	
	// 파티원 목록 조회 [작동] -- 스위치 스크롤
	@PostMapping("/memberlist")
	public void showMemberList(Integer partyCode, Model model) {
		log.debug("showMemberList() invoked.");
		// 해당 파티코드인지, 권한코드 1이상 인지 : 이메일 JOIN 으로 부르기
		
		List<PartyUserVO> user = this.service.showMember(partyCode);
		
		model.addAttribute("__USER__", user);
		
	} // showMemberList
	
	// 파티원 추방 [작동]
	@PostMapping("/dokick")
	public String doKickMember(String email, Integer partyCode, RedirectAttributes rttrs) {
		log.debug("doKickMember() invoked.");
		// 해당 이메일인지 : 해당 컬럼 삭제
		
		boolean result = this.service.kickMember(email, partyCode);
		log.info("\t + result : {}",result);

		rttrs.addAttribute("partyCode", partyCode);
		
		return "redirect:/party/leaderpage";

	} // doKickMember
	
} // end class
