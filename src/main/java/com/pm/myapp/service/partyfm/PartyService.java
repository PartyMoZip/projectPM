package com.pm.myapp.service.partyfm;

import com.pm.myapp.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PartyService {

    public abstract List<PartyMemberCheckVO> checkPartyMember(String email);

    public abstract PartyVO getParty(Integer partyCode);

    public abstract List<UserDTO> getJoinMakingList(Integer partyCode, Criteria cri);

    public abstract Integer getTotalJoinMakeMember(Integer partyCode);

    public abstract boolean doJoin(String email, Integer partyCode);

    public abstract boolean undoJoin(String email, Integer partyCode);

    public abstract boolean editInfo(Map<String, Object> partyInfo);

    public abstract boolean breakParty(Integer partyCode);

    public abstract boolean editPL(Integer authCode, String Email, Integer partyCode);

    public abstract boolean acceptJoin(String email, Integer partyCode);

    public abstract boolean rejectJoin(String email, Integer partyCode);

    public abstract List<PartyUserVO> showMember(@Param("partyCode") Integer partyCode, Criteria cri);

    public abstract Integer getTotalMember(Integer partyCode);

    public abstract boolean kickMember(String email, Integer partyCode);

    public abstract boolean createNewParty(PartyDTO pdto, String email);

    public abstract boolean checkPartyname(String partyName);

    public abstract Integer getMaxPartyCode();

} //end interface
