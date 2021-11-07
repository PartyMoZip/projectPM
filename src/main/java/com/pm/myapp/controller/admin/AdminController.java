package com.pm.myapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pm.myapp.service.admin.AdminService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@RequestMapping("/admin")
@Controller
public class AdminController {
	
	@Setter(onMethod_= {@Autowired})
	private AdminService service;
	
	// 블랙 회원 리스트 조회
	@GetMapping("/getBlackMember")
	public void getBlackMember() {
		log.debug("getBlackMember() invoked.");
		
	} // getBlackMember
	
	// 블랙 파티 리스트 조회
	@GetMapping("/getBlackParty")
	public void getBlackParty() {
		log.debug("getBlackParty() invoked.");
		
	} // getBlackParty
	
	// 회원 추방
	@PostMapping("/doKickUser")
	public void doKickUser() {
		log.debug("doKickUser() invoked.");
		
	} // doKickUser
	
	// 파티 해체
	@PostMapping("/doBreakParty")
	public void doBreakParty() {
		log.debug("doBreakParty() invoked.");
		
	} // doBreakParty
	
	// 파티 해체 승인
	@PostMapping("/acceptPartyBreak")
	public void acceptPartyBreak() {
		log.debug("acceptPartyBreak() invoked.");
		
	} // acceptPartyBreak
	
	// 파티 전체 리스트 조회
	@GetMapping("/getPartyList")
	public void getPartyList() {
		log.debug("getPartyList() invoked.");
		
	} // getPartyList		

} // end class
