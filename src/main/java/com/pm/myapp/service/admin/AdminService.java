package com.pm.myapp.service.admin;

import java.util.List;

import com.pm.myapp.domain.AllPartyVO;
import com.pm.myapp.domain.BlackMemberVO;
import com.pm.myapp.domain.BlackPartyVO;
import com.pm.myapp.domain.Criteria;

public interface AdminService {

	public abstract List<BlackMemberVO> showBlackMember(Criteria cri);
	
	public abstract Integer getTotalBM();
	
	public abstract List<BlackPartyVO> showBlackParty(Criteria cri, String searchWord);
	
	public abstract Integer getTotalBP(String searchWord);
	
	public abstract List<AllPartyVO> showBreakParty(Criteria cri, String searchWord);
	
	public abstract Integer getTotalBreakParty(String searchWord);
	
	public abstract boolean kickUser(String email);
	
	public abstract boolean breakParty(Integer partyCode);
	
	public abstract List<AllPartyVO> getList(Criteria cri, String searchWord);
	
	public abstract Integer getTotalPL(String searchWord);
	
} //end interface
