package com.pm.myapp.domain.board;

import lombok.Data;


@Data
public class HeartDTO {

	private Integer pfrefer; // 파티 자유게시판
	private Integer prefer; // 파티 포토게시판
	private Integer partyCode;
	private String email;
	private Integer hit;
	
} // end class
