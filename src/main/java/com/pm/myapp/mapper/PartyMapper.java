package com.pm.myapp.mapper;

import java.util.List;

import com.pm.myapp.domain.PartyDTO;
import com.pm.myapp.domain.PartyUserVO;
import com.pm.myapp.domain.PartyVO;

public interface PartyMapper {

	public abstract PartyVO getInfo(Integer partyCode);
	
	public abstract Integer makeJoin(String email, Integer partyCode);
	
	public abstract Integer deleteJoin(String email, Integer partyCode);
	
	public abstract Integer modifyLogo(String logoPic, Integer partyCode);
	
	public abstract PartyVO modifyInfo(PartyDTO dto, Integer partyCode);
	
	public abstract Integer makeDesPartyReq(Integer partyCode);
	
	public abstract Integer delegatePL(Integer authCode, String email, Integer partyCode);
	
	public abstract Integer upgradeJoin(String email, Integer partyCode);
	
	public abstract List<PartyUserVO> getMember(Integer partyCode);
	
	
} // end interface
