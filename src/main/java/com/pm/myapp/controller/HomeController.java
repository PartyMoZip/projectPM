package com.pm.myapp.controller;

import com.pm.myapp.controller.join.LoginController;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.domain.UserDTO;
import com.pm.myapp.service.main.MainPageService;
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
    private MainPageService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model, HttpServletRequest req) {
        log.debug("home() invoked.");

        HttpSession session = req.getSession();
        log.info("\t+ session : {}", session);
        if (session.getAttribute(LoginController.authKey) != null) {

            UserDTO dto = (UserDTO) session.getAttribute(LoginController.authKey);

            List<PartyVO> list = this.service.getMyPartyList(dto.getEmail());

            model.addAttribute("list", list);
        } else {
            // List<MyPartyVO>
        }

        return "index";
    }

}
