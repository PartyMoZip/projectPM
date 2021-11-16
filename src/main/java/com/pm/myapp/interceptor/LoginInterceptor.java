package com.pm.myapp.interceptor;

import com.pm.myapp.controller.join.LoginController;
import com.pm.myapp.domain.UserDTO;
import com.pm.myapp.service.join.LoginService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
@NoArgsConstructor

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Setter(onMethod_= {@Autowired})
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        log.debug("=======================================");
        log.debug("1. preHandle({}, {}, {}) invoked.", req, res, handler);
        log.debug("=======================================");

        // Session Scope에 바인딩되어있는(않을 수도 있음), 인증정보를 삭제
        HttpSession session=req.getSession();
        session.removeAttribute(LoginController.authKey);

        log.info("\t+ 이전에 바인딩 되어있을 수 있는 인증정보를 삭제");

        // 가로챈 요청을, 이 인터셉터 뒤에, 컨트롤러가 있으면 --> 컨트롤러에게 요청을 넘겨주겠다.
        // 가로챈 요청을, 이 인터셉터 뒤에, 체인이 있으면 -----> 체인에게 요청을 넘겨주겠다.
        return true;
    } //preHandle


    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("=======================================");
        log.debug("2. postHandle({}, {}, {}, {}) invoked.", req, res, handler, modelAndView);
        log.debug("=======================================");

        // UserController 의 handler method에서 수행한 결과인,
        // 로그인 수행 웹브라우저의 인증정보를 Session Scope에 넣어준다!

        // 현재 요청을 보낸, 웹브라우저에 대응되는 세션객체가 없으면, 새로 세션객체를 생성하고
        //                                  있으면, 이미 존재하는 세션객체를 반환
        HttpSession session=req.getSession();

        ModelMap modelMap=modelAndView.getModelMap();
        UserDTO user= (UserDTO) modelMap.get(LoginController.authKey);
        log.info("\t+ user: {}", user);

        if(user != null) {  // 로그인에 성공했다면....
            log.info("로그인 성공");
            //---------------------------------------//
            // 1. Session Scope 인증정보를 올려 놓자!!
            //---------------------------------------//
            session.setAttribute(LoginController.authKey, user);

            //---------------------------------------//
            // 2. 인증을 성공 후에는, 사용자를 original Request URI with Req. parameters 이동
            //---------------------------------------//
            String originRequestURI=
                    (String) session.getAttribute(AuthInterceptor.requestURIKey);

            String originQueryString=
                    (String) session.getAttribute(AuthInterceptor.queryStringKey);

            if(originRequestURI!=null) { // 원래의 요청URI가 있다면...

                String originRequest=originRequestURI;

                if(originQueryString!=null) {  // 전송파라미터도 있다면...
                    originRequest+='?'+originQueryString;
                } else {  // 전송파라미터가 없다면....
                    ;;
                } // if-else

                log.info("\t+ originRequest: {}", originRequest);

                res.sendRedirect(originRequest);
            } else { // 원래의 요청URI가 없다면...
                res.sendRedirect("/"); // 메인화면으로 이동
            } // if-else

        } else {  // 로그인에 실패했다면....

            // 카카오 로그인 페이지로 이동
            res.sendRedirect("/login/loginPage");
        } // if-else
    } //postHandle


    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handler, Exception e) throws Exception {
        log.debug("=======================================");
        log.debug("3. afterCompletion({}, {}, {}, {}) invoked.", req, res, handler, e);
        log.debug("=======================================");
    } //afterCompletion
} //end class
