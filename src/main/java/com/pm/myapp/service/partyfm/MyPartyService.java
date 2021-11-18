package com.pm.myapp.service.partyfm;

import java.util.List;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.MyPartyListVO;
import com.pm.myapp.domain.PartyDTO;
import com.pm.myapp.domain.PartyVO;

public interface MyPartyService {
	
	public abstract boolean doQuit(String email, Integer partyCode);
	
	public abstract MyPartyListVO getPartyList(String email,Criteria cri);
	
	public abstract Integer getTotalMPL(String email);
	
	public abstract boolean createParty(PartyDTO dto);
	
	public abstract List<MyPartyListVO> getRcParties(Integer[] hobbyCode,Criteria cri);
	
	public abstract Integer getTotalRCP(Integer[] hobbyCode);

} //end interface
