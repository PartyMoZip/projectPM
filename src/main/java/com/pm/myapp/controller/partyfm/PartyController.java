package com.pm.myapp.controller.partyfm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pm.myapp.domain.Criteria;
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
	public void showPartyDetail(@ModelAttribute("cri") Criteria cri, String ptname, Model model) {
		log.debug("showPartyDetail() invoked.");
		PartyVO party = this.service.getParty(ptname);
		log.info("\t + party : {}", party);
		
		model.addAttribute("party",party);
		
	} // showPartyDetail
	
	// 파티 메인 보기
	@PostMapping("/showPartyMain")
	public void showPartyMain(String ptname, Model model) {
		log.debug("showPartyMain() invoked.");
		PartyVO party = this.service.getParty(ptname);
		log.info("\t + party : {}", party);
		
		model.addAttribute("party",party);

	} // showPartyMain
	
	// 파티 로고 등록/변경
	@PostMapping("/editPartyLogo")
	public String editPartyLogo(String Logo, RedirectAttributes rttrs) {
		log.debug("editPartyLogo() invoked.");
		
		boolean result = this.service.editLogo(Logo);
		log.info("\t + result : {}",result);
		
		// 나중에 비동기로 실패,확인 메세지 처리 할 예정
		rttrs.addAttribute("result", result);
		
		return "redirect:/party/showLeaderPage";

	} // editPartyLogo
	
	// 파티 가입 신청
	@PostMapping("/doPartyJoin")
	public void doPartyJoin() {
		log.debug("doPartyJoin() invoked.");

	} // doPartyJoin
	
	// 파티 가입 취소
	@PostMapping("/undoPartyJoin")
	public void undoPartyJoin() {
		log.debug("undoPartyJoin() invoked.");

	} // undoPartyJoin
	
	// 파티 관리 페이지 (view)
	@PostMapping("/showLeaderPage")
	public void showLeaderPage() {
		log.debug("showLeaderPage() invoked.");

	} // showLeaderPage
	
	// 파티 이미지 등록/변경
	@PostMapping("/editPartyImage")
	public void editPartyImage(){
		log.debug("editPartyImage() invoked.");

	} // editPartyImage
	
	// 파티 정보 변경
	@PostMapping("/editParty")
	public void editParty() {
		log.debug("editParty() invoked.");

	} // editParty
	
	// 파티 해체
	@PostMapping("/doBreakParty")
	public void doBreakParty() {
		log.debug("doBreakParty() invoked.");

	} // doBreakParty
	
	// 파티장 권한 위임
	@PostMapping("/editPartyLeader")
	public void editPartyLeader() {
		log.debug("editPartyLeader() invoked.");

	} // editPartyLeader
	
	// 파티 가입 승인
	@PostMapping("/doAcceptJoin")
	public void doAcceptJoin() {
		log.debug("doAcceptJoin() invoked.");

	} // doAcceptJoin
	
	// 파티 가입 거절
	@PostMapping("/doRejectJoin")
	public void doRejectJoin() {
		log.debug("doRejectJoin() invoked.");

	} // doRejectJoin
	
	// 파티원 목록 조회
	@PostMapping("/showMemberList")
	public void showMemberList() {
		log.debug("showMemberList() invoked.");

	} // showMemberList
	
	// 파티원 추방
	@PostMapping("/doKickMember")
	public void doKickMember() {
		log.debug("doKickMember() invoked.");

	} // doKickMember
	
} // end class
