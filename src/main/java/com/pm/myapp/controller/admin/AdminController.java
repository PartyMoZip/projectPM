package com.pm.myapp.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pm.myapp.domain.BlackMemberVO;
import com.pm.myapp.domain.BlackPartyVO;
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

   // 파티관리 페이지 조회회
   @GetMapping("/adminParty")
   public void getAdminParty(){
      log.debug("getAdminParty() invoked.");

   } // adminParty

   // 블랙회원리스트 조회
   @GetMapping("/adminBlackMember")
   public void adminBlackMember() {
      log.debug("adminBlackMember() invoked.");
      // 번호 이메일 닉넴 신고건수 가입일자 
      List<BlackMemberVO> bmlist = this.service.showBlackMember();
      log.info("\t+ bmlist : {}", bmlist);
      
   } // adminBlackMember
   
   // 블랙파티리스트 조회
   @GetMapping("/adminBlackParty")
   public void adminBlackParty() {
      log.debug("adminBlackParty() invoked.");
      // 번호 파티이름 파티장 신고건수 파티 생성일자 
      List<BlackPartyVO> bpList = this.service.showBlackParty();
      log.info("\t+ bpList : {}", bpList);
      
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
   public void doBreakParty() {
      log.debug("doBreakParty() invoked.");
      
   } // doBreakParty
   
   // 파티해체 승인
   @PostMapping("/adminPartyBreak")
   public void adminPartyBreak() {
      log.debug("adminPartyBreak() invoked.");
      
   } // adminPartyBreak
   
   // 파티 전체 리스트 조회
   @GetMapping("/getPartyList")
   public void getPartyList() {
      log.debug("getPartyList() invoked.");
      
      List<> partyList = this.service.getList();
      log.info("\t+ partyList : {}",partyList);
      
   } // getPartyList      

} // end class