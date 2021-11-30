package com.pm.myapp.domain;

import java.sql.Date;

import lombok.Value;

@Value
public class PartyUserVO {

	private String nickname;
	private String userpic;
	private String email;
	private Date joindate;
	
} // end class
