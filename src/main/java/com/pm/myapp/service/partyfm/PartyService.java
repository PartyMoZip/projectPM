package com.pm.myapp.service.partyfm;

import java.util.List;
import java.util.Map;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyDTO;
import com.pm.myapp.domain.PartyMemberCheckVO;
import com.pm.myapp.domain.PartyUserVO;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.domain.UserDTO;

public interface PartyService {
	
	public abstract List<PartyMemberCheckVO> checkPartyMember(String email);

	public abstract PartyVO getParty(Integer partyCode);
	
	public abstract UserDTO getJoinMakingList(Integer partyCode, Criteria cri);
	
	public abstract Integer getTotalJoinMakeMember(Integer partyCode);
	
	public abstract boolean doJoin(String email, Integer partyCode);
	
	public abstract boolean undoJoin(String email, Integer partyCode);
	
	public abstract boolean editInfo(Map<String, Object> partyInfo);
	
	public abstract boolean breakParty(Integer partyCode);
	
	public abstract boolean editPL(Integer authCode, String Email, Integer partyCode);
	
	public abstract boolean acceptJoin(String email, Integer partyCode);
	
	public abstract boolean rejectJoin(String email, Integer partyCode);
	
	public abstract List<PartyUserVO> showMember(Integer partyCode, Criteria cri);
	
	public abstract Integer getTotalMember(Integer partyCode);
	
	public abstract boolean kickMember(String email, Integer partyCode);
	
} //end interface
