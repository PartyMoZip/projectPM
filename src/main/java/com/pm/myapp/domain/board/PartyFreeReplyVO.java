package com.pm.myapp.domain.board;

import lombok.Data;


import java.util.Date;

@Data
public class PartyFreeReplyVO {

    private Integer pfrerefer;
    private String nickname;
    private String pfrecontent;
    private Date pfredate;
    private Integer pfrefer;
    private String email;

}
