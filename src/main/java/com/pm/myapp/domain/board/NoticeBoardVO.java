package com.pm.myapp.domain.board;


import lombok.Value;

import java.util.Date;

@Value
public class NoticeBoardVO {

    private Integer nRefer;
    private String nSubject;
    private String nContent;
    private Date nDate;
    private String nickname;
    private String email;
    private Integer readnum;
    private String userpic;




} // end class
