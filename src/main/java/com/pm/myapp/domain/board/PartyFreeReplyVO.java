package com.pm.myapp.domain.board;

import lombok.Value;

import java.util.Date;

@Value
public class PartyFreeReplyVO {

    private Integer pfrerefer;
    private String nickname;
    private String pfrecontent;
    private Date pfredate;
    private Integer pfrefer;

}
