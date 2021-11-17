package com.pm.myapp.service.main;

import com.pm.myapp.domain.PartyVO;

import java.util.List;

public interface MainPageService {

    // 내 파티 목록 조회
    public abstract List<PartyVO> getMyPartyList(String email);

} //end interface
