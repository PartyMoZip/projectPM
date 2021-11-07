package com.pm.myapp.controller.partyfm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public void doQuitParty() {
		log.debug("doQuitParty() invoked.");
		
	} // doQuitParty
	
	// 내 파티목록 조회
	@GetMapping("/getMyPartyList")
	public void getMyPartyList() {
		log.debug("getMyPartyList() invoked.");
		
	} // getMyPartyList
	
	// 파티 생성 (view)
	@GetMapping("/showCreateParty")
	public void showCreateParty() {
		log.debug("showCreateParty() invoked.");
		
	} // showCreateParty
	
	// 파티 생성
	@PostMapping("/doCreateParty")
	public void doCreateParty() {
		log.debug("doCreateParty() invoked.");
		
	} // doCreateParty
	
	// 파티 추천 리스트 조회
	@GetMapping("/getRecommendParty")
	public void getRecommendParty() {
		log.debug("getRecommendParty() invoked.");
		
	} // getRecommendParty	
	
} // end class
