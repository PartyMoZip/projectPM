package com.pm.myapp.domain.board;

import lombok.Data;

import java.util.Date;

@Data
public class PartyFreeDTO {

    private Integer pfrefer;
    private Date pfdate;
    private String pfcontent;
    private Integer partycode;
    private String pfsubject;
    private String email;
    private Integer readnum;
    
}
