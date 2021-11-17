package com.pm.myapp.domain.board;

import lombok.Value;

import java.util.Date;

@Value
public class PartyPhotoVO {

    private Integer prefer;
    private String nuckname;
    private Date pdate;
    private String pcontent;
    private String ppic1;
    private String ppic2;
    private String ppic3;
    private Integer partycode;

}
