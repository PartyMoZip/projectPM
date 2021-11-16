package com.pm.myapp.mapper;

import java.util.List;

import com.pm.myapp.domain.AllPartyVO;
import com.pm.myapp.domain.BlackMemberVO;
import com.pm.myapp.domain.BlackPartyVO;
import com.pm.myapp.domain.Criteria;

public interface AdminMapper {

	public abstract List<BlackMemberVO> getBlackMember(Criteria cri);
	
	public abstract Integer getAllBM();
	
	public abstract List<BlackPartyVO> getBlackParty(Criteria cri);
	
	public abstract Integer getAllBP();
	
	public abstract Integer deletePartyUser(String email);
	
	public abstract Integer deleteUserInfo(String email);
	
	public abstract Integer cutPartyUser(Integer partyCode);

	public abstract Integer deleteParty(Integer partyCode);
	
	public abstract List<AllPartyVO> getAllList(Criteria cri);
	
	public abstract Integer getAllPL();
	
} // end interface
