package com.pm.myapp.controller.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pm.myapp.service.join.LoginService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@RequestMapping("/login")
@Controller
public class LoginController {
	
	@Setter(onMethod_= {@Autowired})
	private LoginService service;
	
	// 로그인 (view)
	@GetMapping("")
	public void showLogin() {
		log.debug("showLogin() invoked.");
	} // showLogin
	
	// 로그인
	@PostMapping("/doLogin")
	public void doLogin() {
		log.debug("doLogin() invoked.");

	} // doLogin
	
	// 로그아웃
	@GetMapping("/doLogout")
	public void doLogout() {
		log.debug("doLogout() invoked.");

	} // doLogout
	
} // end class
