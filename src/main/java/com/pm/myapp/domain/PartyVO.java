package com.pm.myapp.domain;

import java.sql.Date;
import lombok.Value;


@Value
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
