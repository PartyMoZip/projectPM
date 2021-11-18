package com.pm.myapp.service.main;

import com.pm.myapp.domain.MyPartyVO;

import java.util.List;

public interface MainPageService {

    // 내 파티 목록 조회
    public abstract List<MyPartyVO> getMyPartyList(String email);

} //end interface
