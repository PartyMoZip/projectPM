package com.pm.myapp.domain.board;

import lombok.Value;

import java.util.Date;

@Value
public class PartyFreeVO {

    private Integer pfrefer;
    private Date pfdate;
    private String pfcontent;
    private Integer partyCode;
    private String pfsubject;
    private String email;
    private String nickname;
    private Integer readnum;
    private String userpic;

}
