package com.pm.myapp.service.admin;

import java.util.List;

import com.pm.myapp.domain.BlackMemberVO;
import com.pm.myapp.domain.BlackPartyVO;

public interface AdminService {

	public abstract List<BlackMemberVO> showBlackMember();
	
	public abstract List<BlackPartyVO> showBlackParty();
	
	public abstract boolean kickUser(String email);
	
} //end interface
