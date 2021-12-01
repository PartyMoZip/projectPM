package com.pm.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pm.myapp.domain.AllPartyVO;
import com.pm.myapp.domain.BlackMemberVO;
import com.pm.myapp.domain.BlackPartyVO;
import com.pm.myapp.domain.Criteria;

public interface AdminMapper {

	public abstract List<BlackMemberVO> getBlackMember(Criteria cri);
	
	public abstract Integer getAllBM();
	
	public abstract List<BlackPartyVO> getBlackParty(@Param("cri")Criteria cri, @Param("searchWord") String searchWord);
	
	public abstract Integer getAllBP(String searchWord);
	
	public abstract List<AllPartyVO> getBreakList(@Param("cri")Criteria cri, @Param("searchWord") String searchWord);
	
	public abstract Integer getTotalBreak(String searchWord);
	
	public abstract Integer deletePartyUser(String email);
	
	public abstract Integer deleteUserInfo(String email);
	
	public abstract Integer cutPartyUser(Integer partyCode);

	public abstract Integer deleteParty(Integer partyCode);
	
	public abstract List<AllPartyVO> getAllList(@Param("cri")Criteria cri, @Param("searchWord") String searchWord);
	
	public abstract Integer getAllPL(String searchWord);
	
} // end interface
