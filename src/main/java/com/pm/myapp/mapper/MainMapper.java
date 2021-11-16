package com.pm.myapp.mapper;


import com.pm.myapp.domain.MyPartyVO;

import java.util.List;

// 메인페이지 매퍼
public interface MainMapper {

    // 내 파티 목록 조회
    public abstract List<MyPartyVO> getMyPartyList(String email);

} // end interface
