package com.pm.myapp.mapper;

import com.pm.myapp.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PartyMapper {

    public abstract List<PartyMemberCheckVO> checkIt(String email);

    public abstract PartyVO getInfo(Integer partyCode);

    public abstract Integer makeJoin(@Param("email") String email, @Param("partyCode") Integer partyCode);

    public abstract Integer deleteJoin(String email, Integer partyCode);

    public abstract Integer modifyInfo(Map<String, Object> partyInfo);

    public abstract Integer makeDesPartyReq(Integer partyCode);

    public abstract Integer delegatePL(Integer authCode, String email, Integer partyCode);

    public abstract Integer upgradeJoin(String email, Integer partyCode);

    public abstract List<PartyUserVO> getMember(@Param("partyCode") Integer partyCode, @Param("cri") Criteria cri, @Param("searchWord") String searchWord);

    public abstract Integer getPartyMN(@Param("partyCode") Integer partyCode, @Param("searchWord") String searchWord);

    public abstract List<UserDTO> getMakingList(@Param("partyCode") Integer partyCode, @Param("cri") Criteria cri);

    public abstract Integer getTotalMakingList(Integer partyCode);

    public abstract Integer makeNewParty(@Param("pdto") PartyDTO pdto);

    public abstract Integer makeLeader(@Param("partyCode") Integer partyCode, @Param("email") String email);

    public abstract Integer maxPartyCode();

    public abstract Integer checkName(String partyName);
    
    public abstract Integer checkAuthCode(@Param("email") String email, @Param("partyCode") Integer partyCode);

} // end interface
