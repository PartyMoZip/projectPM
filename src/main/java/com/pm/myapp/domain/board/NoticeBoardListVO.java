package com.pm.myapp.domain.board;

import java.util.Date;

import lombok.Value;


@Value
public class NoticeBoardListVO {

    private Integer nRefer;
    private String nSubject;
    private String nContent;
    private Date nDate;
    private String email;
    private String nickname;
    private Integer readnum;

} // end class
