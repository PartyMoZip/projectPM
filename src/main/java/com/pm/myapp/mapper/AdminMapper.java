package com.pm.myapp.mapper;

import java.util.List;

import com.pm.myapp.domain.BlackMemberVO;
import com.pm.myapp.domain.BlackPartyVO;

public interface AdminMapper {

	public abstract List<BlackMemberVO> getBlackMember();
	
	public abstract List<BlackPartyVO> getBlackParty();
} // end interface
