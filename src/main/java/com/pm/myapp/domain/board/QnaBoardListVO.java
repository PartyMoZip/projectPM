package com.pm.myapp.domain.board;

import lombok.Value;

import java.util.Date;

@Value
public class QnaBoardListVO {

    private Integer qRefer;
    private String qSubject;
    private String qContent;
    private Date qDate;
    private String nickname;
    private String email;
    private Integer readnum;

}
