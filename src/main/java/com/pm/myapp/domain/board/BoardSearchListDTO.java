package com.pm.myapp.domain.board;

import lombok.Data;


@Data
public class BoardSearchListDTO {
	
	private Integer partyCode;
    private String searchWord;
	private Integer option = 1;
	
} // end class
