package com.pm.myapp.domain.board;


import lombok.Data;

import java.util.Date;

@Data
public class QnaBoardDTO {

    private Integer qrefer;
    private String qsubject;
    private String qcontent;
    private Date qdate;
    private String nickname;
    private String email;

}
