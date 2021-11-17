package com.pm.myapp.domain.board;

import lombok.Data;

import java.util.Date;

@Data
public class PartyPhotoReDTO {

    private Integer prerefer;
    private String nickname;
    private String precontent;
    private Date predate;
    private Integer prefer;

}
