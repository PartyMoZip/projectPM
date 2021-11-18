package com.pm.myapp.domain;

import java.util.Date;

import lombok.Value;


@Value
public class BlackPartyVO {

	private Integer rownum;
	private String partyName;
	private String partyCapt;
	private Integer partyBanned;
	private Date createDate;
	
	
} // end class
