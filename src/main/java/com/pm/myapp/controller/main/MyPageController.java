package com.pm.myapp.controller.main;


import com.pm.myapp.controller.join.LoginController;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.domain.UserDTO;
import com.pm.myapp.service.main.UserService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Log4j2
@NoArgsConstructor

@RequestMapping("/my")
@Controller
public class MyPageController {

    @Setter(onMethod_ = {@Autowired})
    private UserService service;

    // 마이페이지 (view)
    @GetMapping("/profile")
    public String showMyPage(HttpServletRequest request, Model model) {
        log.debug("showMyPage() invoked.");

        HttpSession session = request.getSession();
        UserDTO dto = (UserDTO) session.getAttribute(LoginController.authKey);

        List<PartyVO> list = this.service.getMyPartyList(dto.getEmail());
        log.info("list.size() :{}", list.size());


        model.addAttribute("list", list);
        
        return "/mypage";
    } // showMyPage

} // end class
