package com.pm.myapp.interceptor;

import com.pm.myapp.controller.join.LoginController;
import com.pm.myapp.domain.UserDTO;
import com.pm.myapp.service.join.LoginService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
@NoArgsConstructor

@Component
public class AuthInterceptor implements HandlerInterceptor {

    public static final String requestURIKey = "__REQUEST_URI__";
    public static final String queryStringKey = "__QUERYSTRING__";

    @Setter(onMethod_ = {@Autowired})
    private LoginService loginService;


    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
            throws Exception {
        log.debug("=======================================");
        log.debug("1. AuthInterceptor preHandle({}, {}, {}) invoked.", req, res, handler);
        log.debug("=======================================");

        //--------------------------------//
        // 1. 현재 요청을 보낸 브라우저를 위한 Session Scope에 인증정보가 있는지 확인
        //--------------------------------//
        HttpSession session = req.getSession();
        UserDTO user = (UserDTO) session.getAttribute(LoginController.authKey);
        log.info("\t+ user: {}", user);

        if (user == null) { // 아직 인증되지 않은 상태이다...

            // 1. 원래의 Original Request URI + 모든 전송파라미터까지를 Session Scope 에 저장.
            String originReqURI = req.getRequestURI();
            String originQueryString = req.getQueryString();

            session.setAttribute(AuthInterceptor.requestURIKey, originReqURI);
            session.setAttribute(AuthInterceptor.queryStringKey, originQueryString);

            // 2. 현재의 요청이 회원만이 보낼 수 있는 요청이라면(로그인 된 이후 사용할수 있는 메뉴라면) --> 로그인 창으로 이동
            res.sendRedirect("/login");
            return false;
        } // if

        // 가로챈 요청을, 이 인터셉터 뒤에, 컨트롤러가 있으면 --> 컨트롤러에게 요청을 넘겨주겠다.
        // 가로챈 요청을, 이 인터셉터 뒤에, 체인이 있으면 -----> 체인에게 요청을 넘겨주겠다.
        return true;
    } // preHandle


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    } //postHandle
} //end class
