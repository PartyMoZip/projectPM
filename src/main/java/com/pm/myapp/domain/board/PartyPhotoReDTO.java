package com.pm.myapp.domain.board;

import lombok.Data;

import java.util.Date;

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
