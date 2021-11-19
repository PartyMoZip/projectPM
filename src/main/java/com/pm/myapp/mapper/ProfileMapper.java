package com.pm.myapp.mapper;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProfileMapper {

    // 메인페이지 파티 목록 조회
    public abstract List<PartyVO> getMyPartyList(String email);

    // 프로필 이미지 수정
    public abstract Integer modifyProfileImage(Map<String, Object> profile);

    // 회원 탈퇴
    public abstract Integer deleteUser(String email);

} // end interface
