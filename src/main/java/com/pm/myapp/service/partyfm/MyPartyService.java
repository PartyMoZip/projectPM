package com.pm.myapp.service.partyfm;

import com.pm.myapp.domain.MyPartyVO;

public interface MyPartyService {
	
	public abstract boolean doQuit(String email, Integer partyCode);
	
	public abstract MyPartyVO getPartyList(String email);

} //end interface
