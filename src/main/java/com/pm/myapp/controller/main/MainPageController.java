package com.pm.myapp.controller.main;

import com.pm.myapp.service.main.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@RequestMapping("/MainPage")
@Controller
public class MainPageController {
	
	@Setter(onMethod_= {@Autowired})
	private UserService service;
	
	// 메인페이지
	@GetMapping("/h")
	public void home() {
		log.debug("home() invoked.");

	} // home
	
	// 카테고리별 활동포인트 TOP10 조회
	@GetMapping("/s")
	public void showHotParty() {
		log.debug("showHotParty() invoked.");

	} // showHotParty

} // end class
