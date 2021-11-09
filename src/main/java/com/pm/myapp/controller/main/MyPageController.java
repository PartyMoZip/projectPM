package com.pm.myapp.controller.main;

import com.pm.myapp.service.main.MyPageService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Log4j2
@NoArgsConstructor

@RequestMapping("/mypage")
@Controller
public class MyPageController {

    @Setter(onMethod_ = {@Autowired})
    private MyPageService service;

    // 마이페이지 (view)
    @GetMapping("")
    public String showMyPage() {
        log.debug("showMyPage() invoked.");

        return "/mypage";
    } // showMyPage

    // 프로필 수정
    @PostMapping("/editProfile")
    public void editProfile() {
        log.debug("editProfile() invoked.");

    } // editProfile

    // 이메일 수정
    @PostMapping("/editEmail")
    public void editEmail() {
        log.debug("editEmail() invoked.");

    } // editEmail

    // 비밀번호 수정
    @PostMapping("/editPassword")
    public void editPassword() {
        log.debug("editPassword() invoked.");

    } // editPassword

    // 회원 탈퇴
    @PostMapping("/deleteAccount")
    public void deleteAccount() {
        log.debug("deleteAccount() invoked.");

    } // deleteAccount

} // end class
