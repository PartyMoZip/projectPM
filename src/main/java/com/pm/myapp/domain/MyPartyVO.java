package com.pm.myapp.domain;

import lombok.Value;

import java.util.Date;

@Value
public class MyPartyVO {

    private String partyName;
    private Integer partyScore;
    private Date createDate;
    private String logoPic;
    private String coverPic;
    private String partyProfile;
    private String localName;
    private String hobbyName;

} // end class
