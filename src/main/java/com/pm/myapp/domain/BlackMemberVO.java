package com.pm.myapp.domain;

import java.util.Date;

import lombok.Value;


@Value
public class BlackMemberVO {

	private Integer rownum;
	private String email;
	private String nickname;
	private Integer userBanned;
	private Date joinDate;
	
} // end class
