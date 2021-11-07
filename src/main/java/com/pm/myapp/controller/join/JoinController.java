package com.pm.myapp.controller.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pm.myapp.service.join.JoinService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@RequestMapping("/join")
@Controller
public class JoinController {
	
	@Setter(onMethod_= {@Autowired})
	private JoinService service;
	
	// 회원가입 (view)
	@GetMapping("")
	public void showSign() {
		log.debug("showSign() invoked.");
		
	} // showSign
	
	// 회원가입
	@PostMapping("/doSign")
	public void doSign() {
		log.debug("doSign() invoked.");

	} // doSign
	
} // end class
