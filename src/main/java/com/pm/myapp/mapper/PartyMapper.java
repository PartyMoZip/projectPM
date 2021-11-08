package com.pm.myapp.mapper;

import com.pm.myapp.domain.PartyVO;

public interface PartyMapper {

	public abstract PartyVO getInfo(String ptname);
	
	public abstract Integer modifyLogo(String Logo);
	
} // end interface
