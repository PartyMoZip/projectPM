package com.pm.myapp.domain.board;

import lombok.Data;

import java.util.Date;

@Data
public class PartyPhotoDTO {

    private Integer prefer;
    private String nuckname;
    private Date pdate;
    private String pcontent;
    private String ppic1;
    private String ppic2;
    private String ppic3;
    private Integer partycode;

}
