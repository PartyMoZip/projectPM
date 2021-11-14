package com.pm.myapp.domain;

import java.util.Date;

import lombok.Data;


@Data
public class MyPartyVO {

	private Integer partyCode;
	private String partyName;
	private String partyScore;
	private Date createDate;
	private String logoPic;
	
} // end class
