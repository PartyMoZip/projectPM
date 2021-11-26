package com.pm.myapp.interceptor;

import com.pm.myapp.controller.join.LoginController;
import com.pm.myapp.domain.PartyMemberCheckVO;
import com.pm.myapp.domain.UserDTO;
import com.pm.myapp.service.join.LoginService;
import com.pm.myapp.service.partyfm.PartyService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
@NoArgsConstructor

@Component
public class PartyInterceptor implements HandlerInterceptor {

    public static final String requestURIKey = "__REQUEST_URI__";
    public static final String queryStringKey = "__QUERYSTRING__";

    @Setter(onMethod_ = {@Autowired})
    private PartyService service;


    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
            throws Exception {
        log.debug("=======================================");
        log.debug("1. PartyInterceptor preHandle({}, {}, {}) invoked.", req, res, handler);
        log.debug("=======================================");

        //--------------------------------//
        // 1. 현재 요청을 보낸 브라우저를 위한 Session Scope에 인증정보가 있는지 확인
        //--------------------------------//
        HttpSession session = req.getSession();
        UserDTO user = (UserDTO) session.getAttribute(LoginController.authKey);
        log.info("\t+ user: {}", user);

        List<PartyMemberCheckVO> partyCodeList = null;
        String email = null;
        int partyCode = Integer.parseInt(req.getParameter("partyCode"));
        log.info("partyCode : {}", partyCode);
        
        
        if(user!=null) {
            email = user.getEmail();
            partyCodeList = this.service.checkPartyMember(email);
        } // if
        
        if (partyCodeList != null) { // 아직 인증되지 않은 상태이다...
	        for(int i = 0 ; i < partyCodeList.size() ; i++) {
	           if(partyCode == partyCodeList.get(i).getPartyCode()) {
	               log.info("partyCodeList.get(i).getPartyCode() : {}", partyCodeList.get(i).getPartyCode());
	        	   log.info("해당 파티 확인");
	               return true;
	           } // if     
	        } // for        
        } // if
        
        res.sendRedirect("/");
        return false;

    } // preHandle


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    } //postHandle
} //end class
