package com.pm.myapp.domain.board;

import lombok.Data;

import java.util.Date;

@Data
public class PartyFreeReplyDTO {

    private Integer pfrerefer;
    private String pfrecontent;
    private Date pfredate;
    private Integer pfrefer;
    private Integer partyCode;
    private String email;

} // end class
