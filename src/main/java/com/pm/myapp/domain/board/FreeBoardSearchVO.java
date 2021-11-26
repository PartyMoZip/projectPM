package com.pm.myapp.domain.board;


import lombok.Value;

import java.util.Date;

@Value
public class FreeBoardSearchVO {

    private Integer frefer;
    private String fsubject;
    private String fcontent;
    private Date fdate;
    private String email;
    private String nickname;

    /*public FreeBoardSearchVO(Integer frefer, String fsubject, Date fdate, String email, String nickname) {
        this.frefer = frefer;
        this.fsubject = fsubject;
        this.fdate = fdate;
        this.email = email;
        this.nickname = nickname;
    }*/
}
