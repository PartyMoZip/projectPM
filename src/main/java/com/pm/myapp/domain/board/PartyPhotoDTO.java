package com.pm.myapp.domain.board;

import lombok.Data;

import java.util.Date;

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

} // end class
