package com.pm.myapp.domain;

import lombok.Data;

@Data
public class Criteria {

	private Integer currPage = 1;
	private Integer amount = 10;
	private Integer pagesPerPage = 10;
	
} // end class
