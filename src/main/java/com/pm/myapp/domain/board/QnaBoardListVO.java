package com.pm.myapp.domain.board;

import lombok.Value;

import java.util.Date;

@Value
public class QnaBoardListVO {

    private Integer qRefer;
    private String qSubject;
    private Date qDate;
    private String nickname;
    private Integer readnum;

}
