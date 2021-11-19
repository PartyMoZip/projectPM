package com.pm.myapp.controller.main;


import com.pm.myapp.service.main.ProfileService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Log4j2
@NoArgsConstructor

@RequestMapping("/users/{id}")
@RestController
public class MyPageRequestController {

    @Setter(onMethod_ = {@Autowired})
    private ProfileService service;

    // 프로필 수정
    @PutMapping("/edit-profile")
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
    @PostMapping("/withdrawal")
    public void withdrawal() {
        log.debug("withdrawal() invoked.");

    } // withdrawal

} // end class
