package com.pm.myapp.domain.board;

import lombok.Value;

import java.util.Date;

@Value
public class PartyPhotoReVO {

    private Integer prerefer;
    private String nickname;
    private String precontent;
    private Date predate;
    private Integer prefer;

}
