package com.pm.myapp.mapper;

import org.apache.ibatis.annotations.Param;

public interface ReportMapper {

	public abstract Integer checkReportParty(@Param("email") String email, @Param("partyCode") Integer partyCode);
	
	public abstract Integer reportParty(Integer partyCode);
	
} // end interface
