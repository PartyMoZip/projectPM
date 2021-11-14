package com.pm.myapp.mapper;

import org.apache.ibatis.annotations.Param;

import com.pm.myapp.domain.MyPartyVO;

public interface MyPartyMapper {

	public abstract Integer quitParty(String email, Integer partyCode);
	
	public abstract MyPartyVO getList(String email);
	
	
} // end interface
