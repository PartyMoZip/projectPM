package com.pm.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.MyPartyVO;
import com.pm.myapp.domain.PartyDTO;
import com.pm.myapp.domain.PartyVO;

public interface MyPartyMapper {

	public abstract Integer quitParty(String email, Integer partyCode);
	
	public abstract MyPartyVO getList(String email, @Param("cri") Criteria cri);
	
	public abstract Integer makeParty(PartyDTO dto);
	
	public abstract List<MyPartyVO> getRecParties(Integer[] hobbyCode, @Param("cri") Criteria cri);
	
} // end interface
