package com.pm.myapp.exception;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@Log4j2
@NoArgsConstructor(access = lombok.AccessLevel.PUBLIC)

@ControllerAdvice
public class CommonExceptionHandler {


    // Spring MVC model에서, 수신된 요청을 처리할 컨트롤러의 메소드에 대한
    // 매핑정보가 없는 경우에 발생하는, NoHandlerFoundException 이 발생했을 때만
    // 예외처리하도록 구현.
    //	@ResponseStatus(code=HttpStatus.NOT_FOUND)
    //
    //	@ExceptionHandler(NoHandlerFoundException.class)
    //	public String handleNoHandlerFoundException(Exception e, Model model) {
    //		log.debug("handleNoHandlerFoundException({}, {}) invoked.", e, model);
    //
    //		// 예외처리를 수행...
    //		log.info("1. Exception Type: {}", e.getClass().getName());
    //		log.info("2. Exception Message: {}", e.getMessage());
    //
    //		e.printStackTrace();    // 발생한 예외의 스택트레이스를, 콘솔에 출력
    //
    //		// 모델 상자에 예외객체를 담아서, 뷰로 전달하자!!!
    //		model.addAttribute("exception", e);
    //
    //		return "errorPage";
    //	} // handleNoHandlerFoundException


    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        log.debug("handleException({}, {}) invoked.", e, model);

        // 예외처리를 수행...
        log.info("1. Exception Type: {}", e.getClass().getName());
        log.info("2. Exception Message: {}", e.getMessage());

        //		e.printStackTrace();    // 발생한 예외의 스택트레이스를, 콘솔에 출력

        // 모델 상자에 예외객체를 담아서, 뷰로 전달하자!!!
        model.addAttribute("exception", e);

        return "errorPage";
    } // handleException


} // end class
