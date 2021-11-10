package com.pm.myapp.service.partyfm;

import java.util.List;

import com.pm.myapp.domain.PartyDTO;
import com.pm.myapp.domain.PartyUserVO;
import com.pm.myapp.domain.PartyVO;

public interface PartyService {

	public abstract PartyVO getParty(Integer partyCode);
	
	public abstract boolean doJoin(String email, Integer partyCode);
	
	public abstract boolean undoJoin(String email, Integer partyCode);
	
	public abstract boolean editLogo(String logoPic, Integer partyCode);
	
	public abstract boolean editInfo(PartyDTO dto);
	
	public abstract boolean breakParty(Integer partyCode);
	
	public abstract boolean editPL(Integer authCode, String Email, Integer partyCode);
	
	public abstract boolean acceptJoin(String email, Integer partyCode);
	
	public abstract boolean rejectJoin(String email, Integer partyCode);
	
	public abstract List<PartyUserVO> showMember(Integer partyCode);
	
	public abstract boolean kickMember(String email, Integer partyCode);
	
} //end interface
