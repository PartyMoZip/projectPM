package com.pm.myapp.mapper;


import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.MyPartyListVO;
import com.pm.myapp.domain.PartyDTO;
import com.pm.myapp.domain.PartyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// 나의 파티 매퍼
public interface MyPartyMapper {

    public abstract Integer quitParty(@Param("email") String email, @Param("partyCode") Integer partyCode);

    public abstract MyPartyListVO getList(@Param("email") String email, @Param("cri") Criteria cri);

    public abstract Integer getTMPL(String email);

    public abstract Integer makeParty(PartyDTO dto);

    public abstract List<MyPartyListVO> getRecParties(Integer[] hobbyCode, @Param("cri") Criteria cri);

    public abstract Integer getTRCP(Integer[] hobbyCode);

} // end interface
