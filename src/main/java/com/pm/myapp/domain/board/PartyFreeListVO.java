package com.pm.myapp.domain.board;

import lombok.Value;

import java.util.Date;

@Value
public class PartyFreeListVO {

    private Integer pfRefer;
    private Date pfDate;
    private String pfContent;
    private Integer partycode;
    private String pfSubject;
    private String email;
    private Integer readnum;

}
