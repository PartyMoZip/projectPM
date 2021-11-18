package com.pm.myapp.mapper;


import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// 나의 파티 매퍼
public interface MyPartyMapper {

    // 메인페이지 파티 목록 조회
    public abstract List<PartyVO> getMyPartyList(String email);

    // 프로필 파티 목록 조회
    public abstract List<PartyVO> getMyProfilePartyList(@Param("cri") Criteria cri, @Param("email")String email);

} // end interface
