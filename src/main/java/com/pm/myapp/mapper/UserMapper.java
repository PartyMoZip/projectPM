package com.pm.myapp.mapper;

import com.pm.myapp.domain.UserDTO;

import java.util.HashMap;

public interface UserMapper {

    //유저 조회
    public abstract UserDTO selectUser(HashMap<String, String> map);

    //회원가입
    public abstract int insertUser(UserDTO userDto);
} //end class
