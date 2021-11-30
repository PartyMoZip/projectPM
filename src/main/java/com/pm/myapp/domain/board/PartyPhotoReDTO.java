package com.pm.myapp.domain.board;

import java.sql.Date;

import lombok.Data;


@Data
public class PartyPhotoReDTO {

    private Integer prerefer;
    private String precontent;
    private Date predate;
    private Integer prefer;
    private Integer partyCode;
    private String nickname;
    private String email;

} // end class
