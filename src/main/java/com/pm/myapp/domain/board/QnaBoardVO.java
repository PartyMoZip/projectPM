package com.pm.myapp.domain.board;


import lombok.Value;

import java.util.Date;

@Value
public class QnaBoardVO {

    private Integer qrefer;
    private String qsubject;
    private String qcontent;
    private Date qdate;
    private String nickname;
    private String email;

}
