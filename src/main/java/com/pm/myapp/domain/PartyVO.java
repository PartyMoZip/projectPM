package com.pm.myapp.domain;

import lombok.Data;

import java.sql.Date;


@Data
public class PartyVO {

    private Integer count;
    private Integer partyCode;
    private String partyName;
    private Integer partyScore;
    private Date createDate;
    private String logoPic;
    private String coverPic;
    private String partyProfile;
    private Integer partyBanned;
    private String localName;
    private String hobbyName;

} // end class
