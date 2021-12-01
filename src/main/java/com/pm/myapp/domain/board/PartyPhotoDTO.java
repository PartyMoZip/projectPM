package com.pm.myapp.domain.board;

import java.sql.Date;

import lombok.Data;

@Data
public class PartyPhotoDTO {

	private Integer prefer;
	private Date pdate;
	private String pcontent;
	private Integer partycode;
	private String psubject;
	private String email;
	private String nickname;
	private Integer readnum;
	private String userpic;

} // end class
