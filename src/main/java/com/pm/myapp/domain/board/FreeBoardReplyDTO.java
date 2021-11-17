package com.pm.myapp.domain.board;

import lombok.Data;

import java.util.Date;

@Data
public class FreeBoardReplyDTO {

    private Integer frerefer;
    private String frecontent;
    private Date fredate;
    private Integer frefer;
    private String email;

}
