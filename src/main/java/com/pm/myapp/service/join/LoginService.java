package com.pm.myapp.service.join;

import com.pm.myapp.domain.UserDTO;

import java.util.HashMap;

public interface LoginService {
    //유저 조회
    public abstract UserDTO selectUser(HashMap<String, String> map) throws Exception;

    //회원가입
    public abstract int insertUser(UserDTO userDTO) throws Exception;

} //end interface
