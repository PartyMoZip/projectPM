package com.pm.myapp.domain.board;

import lombok.Value;

import java.util.Date;

@Value
public class QnaBoardReplyVO {

    private Integer qrerefer;
    private String qrecontent;
    private Date qredate;
    private Integer qrefer;
    private String email;
    private String nickname;

}
