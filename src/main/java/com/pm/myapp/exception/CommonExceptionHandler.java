package com.pm.myapp.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;


@Log4j2
@Getter(lombok.AccessLevel.PRIVATE)
@Setter
@NoArgsConstructor(access = lombok.AccessLevel.PUBLIC)
//@AllArgsConstructor
//@RequiredArgsConstructor
@ControllerAdvice // 컨트롤러에서 발생하는 예외를 처리하는 클래스
public class CommonExceptionHandler {

    // @NonNull private String name; //@RequiredArgsConstructor일때 필수 초기화 대상이 됨
    // private int age;

    // Spring MVC model에서, 수신된 요청을 처리할 컨트롤러의 메소드에 대한
    // 매핑 정보가 없는 경우에 발생하는, NoHandlerFoundException 이 발생할 때만
    // 예외처리하도록 구현
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNoHandlerFoundException(Exception e, Model model) {

        // Object > Exception > RuntimeException

        // 자바언어의 예외의 종류는 크게 두가지
        // (1) Runtime Exception 실행예외 - 컴파일 할 때 체크 불가능
        /* String name = "A";
         * name = null;
         * log.info(name.length); >> NullPointerException
         */
        // (2) Checked Exception 컴파일 할 때 체크 수행
        /* 가. 위로 던질것인가?
         * 나. try-catch 직접 예외처리 할것인가?
         */

        log.debug("handleNoHandlerFoundException({}, {}) invoked.", e, model);

        // 예외처리를 수행
        log.info("1. Exception Type : {}", e.getClass().getName());
        log.info("2. Exception Message : {}", e.getMessage());


        e.printStackTrace(); // 발생한 예외의 스택트레이스를 콘솔에 출력

        model.addAttribute("exception", e);

        return "errorPage";
    } // handleNoHandlerFoundException


    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public String handleNumberFormatException(Exception e, Model model) {

        log.debug("handleNumberFormatException({}, {}) invoked.", e, model);

        // 예외처리를 수행
        log.info("1. Exception Type : {}", e.getClass().getName());
        log.info("2. Exception Message : {}", e.getMessage());


        // e.printStackTrace(); // 발생한 예외의 스택트레이스를 콘솔에 출력

        model.addAttribute("exception", e);


        return "errorPage";
    } // handleNumberFormatException


    // @ExceptionHandler(NullPointerException.class)
    // public String handleNullPointerException() {
    //     log.debug("handleNullPointerException() invoked.");
    //
    //     return null;
    // } // handleNullPointerException

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        log.debug("handleException() invoked.");

        // 예외처리를 수행
        log.info("1. Exception Type : {}", e.getClass().getName());
        log.info("2. Exception Message : {}", e.getMessage());

        e.printStackTrace();

        model.addAttribute("exception", e);

        return "errorPage";
    } // handleException

} // end class
