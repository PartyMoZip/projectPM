package com.pm.myapp.service.partyfm;

import java.util.List;

import com.pm.myapp.domain.MyPartyVO;
import com.pm.myapp.domain.PartyDTO;
import com.pm.myapp.domain.PartyVO;

public interface MyPartyService {
	
	public abstract boolean doQuit(String email, Integer partyCode);
	
	public abstract MyPartyVO getPartyList(String email);
	
	public abstract boolean createParty(PartyDTO dto);
	
	public abstract List<MyPartyVO> getRcParties(Integer[] hobbyCode);

} //end interface
