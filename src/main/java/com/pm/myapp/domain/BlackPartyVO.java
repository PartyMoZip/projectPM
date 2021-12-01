package com.pm.myapp.domain;

import java.sql.Date;

import lombok.Data;


@Data
public class BlackPartyVO {

	private Integer rownum;
	private String partyName;
	private String nickname;
	private Integer partyBanned;
	private Date createDate;
	private Integer partyCode;
	
	
} // end class
