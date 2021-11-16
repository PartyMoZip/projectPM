package com.pm.myapp.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pm.myapp.domain.PageDTO;

import com.pm.myapp.domain.AllPartyVO;
import com.pm.myapp.domain.BlackMemberVO;
import com.pm.myapp.domain.BlackPartyVO;
import com.pm.myapp.domain.Criteria;
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

   // 파티관리 페이지 조회
   @GetMapping("/adminParty")
   public void getAdminParty(){
      log.debug("getAdminParty() invoked.");

   } // adminParty

   // 블랙회원리스트 조회
   @GetMapping("/adminBlackMember")
   public void adminBlackMember(@ModelAttribute("cri") Criteria cri, Model model) {
      log.debug("adminBlackMember() invoked.");
      // 번호 이메일 닉넴 신고건수 가입일자 
      List<BlackMemberVO> bmlist = this.service.showBlackMember(cri);
      log.info("\t+ bmlist : {}", bmlist);
      
      model.addAttribute("__BMList__", bmlist);
      
      Integer totalAmount = this.service.getTotalBM();
      PageDTO pageDTO = new PageDTO(cri, totalAmount);
		
      model.addAttribute("pageMaker", pageDTO);
      
   } // adminBlackMember
   
   // 블랙파티리스트 조회
   @GetMapping("/adminBlackParty")
   public void adminBlackParty(@ModelAttribute("cri") Criteria cri, Model model) {
      log.debug("adminBlackParty() invoked.");
      // 번호 파티이름 파티장 신고건수 파티 생성일자 
      List<BlackPartyVO> bpList = this.service.showBlackParty(cri);
      log.info("\t+ bpList : {}", bpList);
      
      model.addAttribute("__BPList__", bpList);
      
      Integer totalAmount = this.service.getTotalBP();
      PageDTO pageDTO = new PageDTO(cri, totalAmount);
		
      model.addAttribute("pageMaker", pageDTO);
      
   } // adminBlackParty
   
   // 회원 추방
   @PostMapping("/doKickUser")
   public void doKickUser(String email) {
      log.debug("doKickUser({}) invoked.",email);
      
      boolean result = this.service.kickUser(email);
      log.info("\t+ result : {}",result);
      
   } // doKickUser
   
   // 파티 해체
   @PostMapping("/doBreakParty")
   public void doBreakParty(Integer partyCode) {
      log.debug("doBreakParty({}) invoked.",partyCode);
      
      boolean result = this.service.breakParty(partyCode);
      log.info("\t+ result : {}",result);
      
   } // doBreakParty
   
   // 파티해체 승인
   @PostMapping("/adminPartyBreak")
   public void adminPartyBreak(Integer partyCode) {
      log.debug("adminPartyBreak({}) invoked.",partyCode);
      
      boolean result = this.service.breakParty(partyCode);
      log.info("\t+ result : {}",result);
      
   } // adminPartyBreak
   
   // 파티 전체 리스트 조회
   @GetMapping("/getPartyList")
   public void getPartyList(@ModelAttribute("cri") Criteria cri, Model model) {
      log.debug("getPartyList() invoked.");
      
      List<AllPartyVO> partyList = this.service.getList(cri);
      log.info("\t+ partyList : {}",partyList);
      
      model.addAttribute("__PartyList__", partyList);
      
      Integer totalAmount = this.service.getTotalPL();
      PageDTO pageDTO = new PageDTO(cri, totalAmount);
		
      model.addAttribute("pageMaker", pageDTO);
      
   } // getPartyList      

} // end class