package com.pm.myapp.mapper;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyMemberCheckVO;
import com.pm.myapp.domain.PartyUserVO;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.domain.UserDTO;

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

    public abstract List<PartyUserVO> getMember(Integer partyCode, @Param("cri") Criteria cri);

    public abstract Integer getPartyMN(Integer partyCode);
    
    public abstract UserDTO getMakingList(@Param("partyCode") Integer partyCode, @Param("cri") Criteria cri);
    
    public abstract Integer getTotalMakingList(Integer partyCode);

} // end interface
