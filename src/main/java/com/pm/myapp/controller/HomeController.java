package com.pm.myapp.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

@Log4j2
@NoArgsConstructor
@Controller
public class HomeController {

    @Setter(onMethod_ = {@Autowired})
    private UserService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model, HttpServletRequest req) {
        log.debug("home() invoked.");

        HttpSession session = req.getSession();
        log.info("\t+ session : {}", session.getAttribute(LoginController.authKey));

        List<PartyVO> list;
        boolean result = false;

        // 로그인 했을 경우
        if (session.getAttribute(LoginController.authKey) != null && session != null) {

            UserDTO dto = (UserDTO) session.getAttribute(LoginController.authKey);

            list = this.service.getMyPartyList(dto.getEmail());
            result = true;

            // 가입한 파티가 없을 경우
            if (list.size() == 0) {
                list = this.service.getMyPartyList("");
                result = false;
            } // if

        } else {
            // 로그인 하지 않았을 경우
            list = this.service.getMyPartyList("");
        } // if-else

        model.addAttribute("result", result);
        model.addAttribute("list", list);

        return "index";
    }

}
