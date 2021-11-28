package com.pm.myapp.controller.partyfm;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.pm.myapp.aws.AwsUpload;
import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PageDTO;
import com.pm.myapp.domain.PartyUserVO;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.domain.UserDTO;
import com.pm.myapp.service.partyfm.PartyService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.*;


@Log4j2
@NoArgsConstructor

@RequestMapping("/party")
@Controller
public class PartyController {

    private String basePath;

    @Setter(onMethod_ = {@Autowired})
    private PartyService service;

    @Setter(onMethod_ = {@Autowired})
    private AwsUpload awsUpload;

    // 파티 상세 보기 [작동]
    @GetMapping("/detail")
    @ResponseBody
    public PartyVO showPartyDetail(Integer partyCode) {
        log.debug("showPartyDetail({}) invoked.", partyCode);
        PartyVO party = this.service.getParty(partyCode);
        log.info("\t + party : {}", party);

        return party;
    } // showPartyDetail

    // 파티 가입 신청 [작동]
    @PostMapping("/join")
    @ResponseBody
    public Map<String, Boolean> doPartyJoin(
            @RequestBody String json
    ) {
        log.debug("doPartyJoin() invoked.");

        log.info("json: {}", json);

        JsonElement element = JsonParser.parseString(json);

        String email = element.getAsJsonObject().get("email").getAsString();
        Integer partyCode = element.getAsJsonObject().get("partyCode").getAsInt();

        Boolean result = this.service.doJoin(email, partyCode);
        log.info("\t + result : {}", result);

        Map<String, Boolean> data = new HashMap<>();
        data.put("result", result);

        return data;

    } // doPartyJoin

    // 파티 가입 취소 [작동]
    @PostMapping("/undo-party-join")
    public String undoPartyJoin(String email, Integer partyCode, RedirectAttributes rttrs) {
        log.debug("undoPartyJoin({}, {}) invoked.", email, partyCode);

        boolean result = this.service.undoJoin(email, partyCode);
        log.info("\t + result : {}", result);

        rttrs.addAttribute("partyCode", partyCode);

        return "redirect:/party/leaderpage";

    } // undoPartyJoin

    // 파티 메인 보기 [작동]
    @GetMapping("/showmain")
    public String showPartyMain(Integer partyCode, Model model) {
        log.debug("showPartyMain({}) invoked.", partyCode);
        PartyVO party = this.service.getParty(partyCode);
        log.info("\t + party : {}", party);

        model.addAttribute("__PARTY__", party);

        return "/party/partyMain";

    } // showPartyMain

    // 파티 관리 페이지 [작동]
    @GetMapping("/leaderpage")
    public void showLeaderPage(Integer partyCode, Model model) {
        log.debug("showLeaderPage({}) invoked.", partyCode);
        PartyVO party = this.service.getParty(partyCode);
        log.info("\t + party : {}", party);

        model.addAttribute("__PARTY__", party);

    } // showLeaderPage

    // 파티 로고 등록/변경 [작동]
    @PostMapping("/edit-profile")
    @ResponseBody
    public Map<String, Object> editPartyProfile(
            @RequestParam(value = "partyName", required = false) String partyName,
            @RequestParam(value = "partyCode", required = false) String partyCode,
            @RequestParam(value = "partyProfile", required = false) String partyProfile,
            @RequestParam(value = "fileLocation", required = false) MultipartFile fileLocation
    ) throws IllegalStateException, IOException {

        log.debug("editPartyProfile() invoked.");

        log.info("partyName: {}", partyName);
        log.info("partyCode: {}", partyCode);
        log.info("partyProfile: {}", partyProfile);
        log.info("fileLocation: {}", fileLocation);

        // 파티별, 날짜별 폴더를 생성 후 그림 파일 업로드
        // 날짜 GET
        Calendar cal = Calendar.getInstance();
        String year = cal.get(cal.YEAR) + "";
        String month = (cal.get(cal.MONTH) + 1) + "";
        String date = cal.get(cal.DATE) + "";

        // 파티코드와 날짜 합쳐서 새로운 폴더 준비
        String imagePath = "image/logo/" + partyCode + "/" + year + "/" + month + "/" + date;
        String imageUrl = "";

        // 랜덤값 형성 및 aws에 파일 업로드
        UUID uuid = UUID.randomUUID(); // 랜덤값
        if (fileLocation != null) {
            imageUrl = awsUpload.fileUpload(fileLocation, imagePath, uuid);
        } // if

        // DB에 이미지 정보 저장하기
        // HashMap을 이용하여 DTO 처럼 사용할 예정
        // Mapper.xml 에 갔을 때 key를 입력하면 value 값이 들어감
        // value의 타입이 object인건 value의 타입이 모두 같은것이 아니기 때문
        Map<String, Object> partyInfo = new HashMap<String, Object>();
        partyInfo.put("partyName", partyName);
        partyInfo.put("partyProfile", partyProfile);
        partyInfo.put("fileLocation", imageUrl); // 파일 이름 주소
        partyInfo.put("partyCode", partyCode);

        boolean result = this.service.editInfo(partyInfo);
        log.info("\t + result : {}", result);

        Map<String, Object> data = new HashMap<>();

        data.put("partyName", partyName);
        data.put("partyProfile", partyProfile);
        data.put("fileLocation", fileLocation);

        return data;

    } // editPartyProfile
   
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
		
	// 파티장 권한 위임 [작동]
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
		
	} // editPartyLeaderu    
	
	// 파티 가입 승인 [작동]
	@PostMapping("/do-accept-join")
	public String doAcceptJoin(String[] email, Integer partyCode, RedirectAttributes rttrs, Criteria cri) {
		log.debug("doAcceptJoin({}, {}) invoked.",email.toString(),partyCode);
		// 권한코드 -1 인지 확인 : 권한코드 1로 변경
					
		for(String emaillist : email) {
			boolean result = this.service.acceptJoin(emaillist, partyCode);
			log.info("\t + result : {}",result);
		} // advanced-for

		rttrs.addAttribute("partyCode",partyCode);
		rttrs.addAttribute("currPage",cri.getCurrPage());
		
		return "redirect:/party/leaderpage";
		
	} // doAcceptJoin
	
	// 파티 가입 거절 [작동]
	@PostMapping("/do-reject-join")
	public String doRejectJoin(String[] email, Integer partyCode, RedirectAttributes rttrs, Criteria cri) {
		log.debug("doRejectJoin({}, {}) invoked.",email.toString(),partyCode);
		// 해당 이메일인지 : 해당 컬럼 삭제
		
		for(String emaillist : email) {
			boolean result = this.service.rejectJoin(emaillist, partyCode);
			log.info("\t + result : {}",result);
		} // advanced-for
		
		rttrs.addAttribute("partyCode",partyCode);
		rttrs.addAttribute("currPage",cri.getCurrPage());
		
		return "redirect:/party/leaderpage";
		
	} // doRejectJoin
	
	// 파티원 목록 조회 [작동] -- 스위치 스크롤
	@GetMapping("/memberlist")
	public void showMemberList(@ModelAttribute("cri") Criteria cri,Integer partyCode, Model model) {
		log.debug("showMemberList() invoked.");
		// 해당 파티코드인지, 권한코드 1이상 인지 : 이메일 JOIN 으로 부르기
		
		List<PartyUserVO> user = this.service.showMember(partyCode, cri);
		
		model.addAttribute("__USER__", user);
		
	    Integer totalAmount = this.service.getTotalMember(partyCode);
	    PageDTO pageDTO = new PageDTO(cri, totalAmount);
			
	    model.addAttribute("pageMaker", pageDTO);
		
	} // showMemberList
	
	// 파티원 추방 [작동]
	@PostMapping("/dokick")
	public String doKickMember(String email[], Integer partyCode, RedirectAttributes rttrs) {
		log.debug("doKickMember() invoked.");
		// 해당 이메일인지 : 해당 컬럼 삭제
		
		for(String emaillist : email) {
			boolean result = this.service.kickMember(emaillist, partyCode);
			log.info("\t + result : {}",result);
		} // advanced-for
		rttrs.addAttribute("partyCode", partyCode);
		
		return "redirect:/party/leaderpage";

	} // doKickMember
	
} // end class
