package com.pm.myapp.domain.board;

import lombok.Data;

import java.util.Date;

@Data
public class PartyFreeListVO {

    private Integer pfRefer;
    private Date pfDate;
    private String pfContent;
    private Integer partyCode;
    private String pfSubject;
    private String email;
    private Integer readnum;
    private String nickname;

} // end class
