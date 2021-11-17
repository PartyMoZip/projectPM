package com.pm.myapp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyDTO;
import com.pm.myapp.domain.PartyUserVO;
import com.pm.myapp.domain.PartyVO;

public interface PartyMapper {

	public abstract PartyVO getInfo(Integer partyCode);
	
	public abstract Integer makeJoin(String email, Integer partyCode);
	
	public abstract Integer deleteJoin(String email, Integer partyCode);
	
	public abstract Integer modifyLogo(Map<String, Object> imageInfo);
	
	public abstract Integer modifyMainImage(Map<String, Object> imageInfo);
	
	public abstract Integer modifyInfo(PartyDTO dto);
	
	public abstract Integer makeDesPartyReq(Integer partyCode);
	
	public abstract Integer delegatePL(Integer authCode, String email, Integer partyCode);
	
	public abstract Integer upgradeJoin(String email, Integer partyCode);
	
	public abstract List<PartyUserVO> getMember(Integer partyCode, @Param("cri") Criteria cri);
	
	public abstract Integer getPartyMN(Integer partyCode);
	
	
} // end interface
