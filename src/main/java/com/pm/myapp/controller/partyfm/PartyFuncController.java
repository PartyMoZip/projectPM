package com.pm.myapp.controller.partyfm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pm.myapp.service.partyfm.PartyFuncService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@RequestMapping("/partyfunc")
@Controller
public class PartyFuncController {
	
	@Setter(onMethod_= {@Autowired})
	private PartyFuncService service;
}
