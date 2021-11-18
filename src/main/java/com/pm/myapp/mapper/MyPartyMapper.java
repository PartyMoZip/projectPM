package com.pm.myapp.mapper;


import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyVO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

// 나의 파티 매퍼
public interface MyPartyMapper {

    
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.MyPartyListVO;
import com.pm.myapp.domain.PartyDTO;
import com.pm.myapp.domain.PartyVO;

public interface MyPartyMapper {
  
  // 메인페이지 파티 목록 조회
  public abstract List<PartyVO> getMyPartyList(String email);

  // 프로필 파티 목록 조회
  public abstract List<PartyVO> getMyProfilePartyList(@Param("cri") Criteria cri, @Param("email")String email);

	public abstract Integer quitParty(String email, Integer partyCode);
	
	public abstract MyPartyListVO getList(String email, @Param("cri") Criteria cri);
	
	public abstract Integer getTMPL(String email);
	
	public abstract Integer makeParty(PartyDTO dto);
	
	public abstract List<MyPartyListVO> getRecParties(Integer[] hobbyCode, @Param("cri") Criteria cri);
	
	public abstract Integer getTRCP(Integer[] hobbyCode);
	

} // end interface
