package com.pm.myapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pm.myapp.service.admin.ReportService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@RequestMapping("/report")
@Controller
public class ReportController {
	
	@Setter(onMethod_= {@Autowired})
	private ReportService service;

	// 회원 신고
	@PostMapping("/doReportMember")
	public void doReportMember() {
		log.debug("doReportMember() invoked.");
		
	} // doReportMember
	
	// 파티 신고
	@PostMapping("/doReportParty")
	public void doReportParty() {
		log.debug("doReportParty() invoked.");
		
	} // doReportParty
	
} // end class
