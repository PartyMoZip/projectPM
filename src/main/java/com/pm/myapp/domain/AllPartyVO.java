package com.pm.myapp.domain;

import java.util.Date;

import lombok.Value;


@Value
public class AllPartyVO {

	private Integer rownum;
	private Integer partyCode;
	private String partyName;
	private String partyScore;
	private String partyCapt;
	private Integer partyBanned;
	private Date createDate;
	private Integer partyMember;
	
} // end class
