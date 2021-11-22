package com.pm.myapp.mapper;

import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.domain.UserDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserMapper {

    //유저 조회
    public abstract UserDTO selectUser(HashMap<String, String> map);

    //회원가입
    public abstract int insertUser(UserDTO userDto);

    // 메인페이지 파티 목록 조회
    public abstract List<PartyVO> getMyPartyList(String email);

    // 프로필 이미지 수정
    public abstract Integer modifyProfile(Map<String, Object> profile);

    // 회원 탈퇴
    public abstract Integer deleteUser(String email);
} //end class
