package com.pm.myapp.domain.board;


import lombok.Data;

import java.util.Date;

@Data
public class QnaBoardVO {

    private Integer qrefer;
    private String qsubject;
    private String qcontent;
    private Date qdate;
    private String nickname;
    private String email;
    private Integer readnum;
    private String userpic;

}
