package com.pm.myapp.service.main;

import com.pm.myapp.domain.PartyVO;

import java.util.List;
import java.util.Map;

public interface UserService {

    // 내 파티 목록 조회
    public abstract List<PartyVO> getMyPartyList(String email);

    // 프로필 이미지 수정
    public abstract boolean editProfile(Map<String, Object> profile);

    // 회원 탈퇴
    public abstract boolean withdrawal(String email);
}
