package com.pm.myapp.domain.board;

import lombok.Value;

import java.util.Date;

@Value
public class QnaBoardSearchVO {

    private Integer qrefer;
    private String qsubject;
    private String qcontent;
    private Date qdate;
    private String email;
    private String nickname;

}
