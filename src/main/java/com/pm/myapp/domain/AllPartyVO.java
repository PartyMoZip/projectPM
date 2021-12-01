package com.pm.myapp.domain;


import java.sql.Date;

import lombok.Data;


@Data
public class AllPartyVO {

	private Integer rownum;
	private Integer partyCode;
	private String partyName;
	private String partyScore;
	private String nickname;
	private Integer partyBanned;
	private Date createDate;
	private Integer partyMember;
	
} // end class
