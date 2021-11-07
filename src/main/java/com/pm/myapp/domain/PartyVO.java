package com.pm.myapp.domain;

import java.util.Date;
import lombok.Value;


@Value
public class PartyVO {
	
	private Integer ptcode;
	private String ptname;
	private Integer pscore;
	private Date cdate;
	private String logo;
	private String cover;
	private String pprof;
	private Integer pbpoint;
	private Integer lcode;

} // end class
