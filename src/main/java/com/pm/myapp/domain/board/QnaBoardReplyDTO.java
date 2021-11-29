package com.pm.myapp.domain.board;

import lombok.Data;

import java.util.Date;

@Data
public class QnaBoardReplyDTO {

    private Integer qrerefer;
    private String qrecontent;
    private Date qredate;
    private Integer qrefer;
    private String email;
    private String nickname;

}
