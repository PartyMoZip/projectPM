package com.pm.myapp.controller.main;


import com.pm.myapp.service.main.UserService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Log4j2
@NoArgsConstructor

@RequestMapping("/users")
@Controller
public class MyPageController {

    @Setter(onMethod_ = {@Autowired})
    private UserService service;

    // 마이페이지 (view)
    @GetMapping("/{id}")
    public String showMyPage() {
        log.debug("showMyPage() invoked.");

        return "/mypage";
    } // showMyPage

} // end class
