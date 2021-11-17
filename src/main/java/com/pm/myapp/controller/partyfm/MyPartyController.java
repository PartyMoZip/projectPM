package com.pm.myapp.controller.partyfm;

import java.util.List;

import org.apache.catalina.tribes.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.MyPartyListVO;
import com.pm.myapp.domain.PartyDTO;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.service.partyfm.MyPartyService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@RequestMapping("/myparty")
@Controller
public class MyPartyController {
	
	@Setter(onMethod_= {@Autowired})
	private MyPartyService service;
	
	// 파티 탈퇴
	@PostMapping("/doQuitParty")
	public void doQuitParty(String email, Integer partyCode) {
		log.debug("doQuitParty() invoked.");
		
		boolean result = this.service.doQuit(email, partyCode);
		log.info("\t+ result : {}", result);		
		
	} // doQuitParty
	
	// 내 파티목록 조회
	@GetMapping("/getMyPartyList")
	public void getMyPartyList(@ModelAttribute("cri") Criteria cri,String email, Model model) {
		log.debug("getMyPartyList() invoked.");
		
		MyPartyListVO party = this.service.getPartyList(email,cri);
		log.info("\t+ party : {}", party);	
		
	} // getMyPartyList
	
	// 파티 생성 (view)
	@GetMapping("/showCreateParty")
	public void showCreateParty() {
		log.debug("showCreateParty() invoked.");
		
	} // showCreateParty
	
	// 파티 생성
	@PostMapping("/doCreateParty")
	public void doCreateParty(PartyDTO dto) {
		log.debug("doCreateParty() invoked.");
		
		boolean result = this.service.createParty(dto);
		log.info("\t+ result : {}", result);	
		
	} // doCreateParty
	
	// 파티 추천 리스트 조회
	@GetMapping("/getRecommendParty")
	public void getRecommendParty(@ModelAttribute("cri") Criteria cri,Integer[] hobbyCode, Model model) {
		log.debug("getRecommendParty({}, {}) invoked.", cri,Arrays.toString(hobbyCode));
		
		List<MyPartyListVO> list = this.service.getRcParties(hobbyCode,cri);
		model.addAttribute("__LIST__", list);
		
	} // getRecommendParty	
	
} // end class
