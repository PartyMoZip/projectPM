package com.pm.myapp.domain.board;

import lombok.Value;

import java.util.Date;

@Value
public class FreeBoardReplyVO {

    private Integer frerefer;
    private String frecontent;
    private Date fredate;
    private Integer frefer;
    private String email;

}
