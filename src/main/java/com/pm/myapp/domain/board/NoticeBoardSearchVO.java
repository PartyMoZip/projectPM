package com.pm.myapp.domain.board;

import lombok.Value;

import java.util.Date;

@Value
public class NoticeBoardSearchVO {

    private Integer nrefer;
    private String nsubject;
    private String ncontent;
    private Date ndate;
    private String email;
    private String nickname;


 /*   public NoticeBoardSearchVO(Integer nrefer, String nsubject, Date ndate, String email, String nickname) {
        this.nrefer = nrefer;
        this.nsubject = nsubject;
        this.ndate = ndate;
        this.email = email;
        this.nickname = nickname;
    }*/

}
