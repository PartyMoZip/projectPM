package com.pm.myapp.service.admin;

import java.util.List;

import com.pm.myapp.domain.AllPartyVO;
import com.pm.myapp.domain.BlackMemberVO;
import com.pm.myapp.domain.BlackPartyVO;
import com.pm.myapp.domain.Criteria;

public interface AdminService {

	public abstract List<BlackMemberVO> showBlackMember(Criteria cri);
	
	public abstract Integer getTotalBM();
	
	public abstract List<BlackPartyVO> showBlackParty(Criteria cri);
	
	public abstract Integer getTotalBP();
	
	public abstract boolean kickUser(String email);
	
	public abstract boolean breakParty(Integer partyCode);
	
	public abstract List<AllPartyVO> getList(Criteria cri);
	
	public abstract Integer getTotalPL();
	
} //end interface
