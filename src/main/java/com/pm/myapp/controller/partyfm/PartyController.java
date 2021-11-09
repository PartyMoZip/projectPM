package com.pm.myapp.controller.partyfm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@Setter(onMethod_= {@Autowired})
	private PartyService service;
	
	// 파티 상세 보기
	@GetMapping("/showPartyDetail")
	public void showPartyDetail(Integer partyCode, Model model) {
		log.debug("showPartyDetail({}) invoked.",partyCode);
		PartyVO party = this.service.getParty(partyCode);
		log.info("\t + party : {}", party);
		
		model.addAttribute("__PARTY__",party);
		
	} // showPartyDetail
	
	// 파티 가입 신청
	@PostMapping("/doPartyJoin")
	public String doPartyJoin(String email, Integer partyCode, RedirectAttributes rttrs) {
		log.debug("doPartyJoin({}, {}) invoked.",email,partyCode);
		
		boolean result = this.service.doJoin(email, partyCode);
		log.info("\t + result : {}",result);

		rttrs.addAttribute("partyCode",partyCode);
		
		return "redirect:/party/showLeaderPage";
		
	} // doPartyJoin
	
	// 파티 가입 취소
	@PostMapping("/undoPartyJoin")
	public String undoPartyJoin(String email, Integer partyCode, RedirectAttributes rttrs) {
		log.debug("undoPartyJoin({}, {}) invoked.",email,partyCode);
		
		boolean result = this.service.undoJoin(email, partyCode);
		log.info("\t + result : {}",result);
		
		rttrs.addAttribute("partyCode",partyCode);
		
		return "redirect:/party/showLeaderPage";

	} // undoPartyJoin
	
	// 파티 메인 보기
	@GetMapping("/showPartyMain")
	public void showPartyMain(Integer partyCode, Model model) {
		log.debug("showPartyMain({}) invoked.",partyCode);
		PartyVO party = this.service.getParty(partyCode);
		log.info("\t + party : {}", party);
		
		model.addAttribute("__PARTY__",party);

	} // showPartyMain
	
	// 파티 관리 페이지
	@GetMapping("/showLeaderPage")
	public void showLeaderPage(Integer partyCode, Model model) {
		log.debug("showLeaderPage({}) invoked.",partyCode);
		PartyVO party = this.service.getParty(partyCode);
		log.info("\t + party : {}", party);
		
		model.addAttribute("__PARTY__",party);
		
	} // showLeaderPage
	
	// 파티 로고 등록/변경
	@PostMapping("/editPartyLogo")
	public String editPartyLogo(String logoPic, Integer partyCode, RedirectAttributes rttrs) {
		log.debug("editPartyLogo({}, {}) invoked.",logoPic, partyCode);
		
		/*
		boolean result = this.service.editLogo(logoPic, partyCode);
		log.info("\t + result : {}",result);
		
		// 나중에 비동기로 실패,확인 메세지 처리 할 예정
		rttrs.addAttribute("result", result);
		*/
		
		return "redirect:/party/showLeaderPage";

	} // editPartyLogo
	
	// 파티 이미지 등록/변경
	@PostMapping("/editPartyImage")
	public void editPartyImage(){
		log.debug("editPartyImage() invoked.");

	} // editPartyImage
	
	// 파티 정보 변경
	@PostMapping("/editParty")
	public String editParty(PartyDTO dto, Integer partyCode, RedirectAttributes rttrs) {
		log.debug("editParty({}, {}) invoked.",dto,partyCode);
		
		PartyVO party = this.service.editInfo(dto, partyCode);
		log.info("\t + party : {}", party);

		rttrs.addAttribute("partyCode",partyCode);
		
		return "redirect:/party/showLeaderPage";
		
	} // editParty
	
	// 파티 해체
	@PostMapping("/doBreakParty")
	public String doBreakParty(Integer partyCode, RedirectAttributes rttrs) {
		log.debug("doBreakParty({}) invoked.",partyCode);
		// 신고수 -1로 만들기
		
		boolean result = this.service.breakParty(partyCode);
		log.info("\t + result : {}",result);
		
		rttrs.addAttribute("partyCode",partyCode);
		
		return "redirect:/party/showLeaderPage";

	} // doBreakParty
	
	// 파티장 권한 위임
	@PostMapping("/editPartyLeader")
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
		
		return "redirect:/party/showPartyMain";
		
	} // editPartyLeader
	
	// 파티 가입 승인
	@PostMapping("/doAcceptJoin")
	public void doAcceptJoin(String email, Integer partyCode) {
		log.debug("doAcceptJoin({}, {}) invoked.",email,partyCode);
		// 권한코드 -1 인지 확인 : 권한코드 1로 변경
		
		boolean result = this.service.acceptJoin(email, partyCode);
		log.info("\t + result : {}",result);

	} // doAcceptJoin
	
	// 파티 가입 거절
	@PostMapping("/doRejectJoin")
	public void doRejectJoin(String email, Integer partyCode) {
		log.debug("doRejectJoin({}, {}) invoked.",email,partyCode);
		// 해당 이메일인지 : 해당 컬럼 삭제
		
		boolean result = this.service.rejectJoin(email, partyCode);
		log.info("\t + result : {}",result);
		
	} // doRejectJoin
	
	// 파티원 목록 조회
	@PostMapping("/showMemberList")
	public void showMemberList(Integer partyCode, Model model) {
		log.debug("showMemberList() invoked.");
		// 해당 파티코드인지, 권한코드 1이상 인지 : 이메일 JOIN 으로 부르기
		
		List<PartyUserVO> user = this.service.showMember(partyCode);
		
		model.addAttribute("__USER__", user);
		
	} // showMemberList
	
	// 파티원 추방
	@PostMapping("/doKickMember")
	public String doKickMember(String email, Integer partyCode, RedirectAttributes rttrs) {
		log.debug("doKickMember() invoked.");
		// 해당 이메일인지 : 해당 컬럼 삭제
		
		boolean result = this.service.kickMember(email, partyCode);
		log.info("\t + result : {}",result);

		rttrs.addAttribute("partyCode", partyCode);
		
		return "redirect:/party/showLeaderPage";

	} // doKickMember
	
} // end class
