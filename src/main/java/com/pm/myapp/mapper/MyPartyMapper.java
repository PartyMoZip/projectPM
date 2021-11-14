package com.pm.myapp.mapper;

import org.apache.ibatis.annotations.Param;

import com.pm.myapp.domain.MyPartyVO;
import com.pm.myapp.domain.PartyDTO;

public interface MyPartyMapper {

	public abstract Integer quitParty(String email, Integer partyCode);
	
	public abstract MyPartyVO getList(String email);
	
	public abstract Integer makeParty(PartyDTO dto);
		
} // end interface
