package com.pm.myapp.domain.board;

import lombok.Data;

import java.util.Date;

@Data
public class PartyFreeReplyDTO {

    private Integer pfrerefer;
    private String email;
    private String pfrecontent;
    private Integer pfrefer;
    private Integer partycode;

} // end class
