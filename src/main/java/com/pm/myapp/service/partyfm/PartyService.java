package com.pm.myapp.service.partyfm;

import com.pm.myapp.domain.PartyVO;

public interface PartyService {

	public abstract PartyVO getParty(String ptname);
	
	public abstract boolean editLogo(String Logo); 
	
} //end interface
