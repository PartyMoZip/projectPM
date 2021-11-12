package com.pm.myapp.service.join;
import com.pm.myapp.domain.UserDTO;
import com.pm.myapp.mapper.UserMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;

@Log4j2
@NoArgsConstructor

@Service
public class LoginServiceImpl implements LoginService {

    @Setter(onMethod_= {@Autowired})
    private UserMapper mapper;

    //유저조회
    @Override
    public UserDTO selectUser(HashMap<String, String> map) {

        UserDTO userDto = mapper.selectUser(map);
        return userDto;
    } //end selectUser

    //회원가입
    @Override
    public int insertUser(UserDTO userDto) {
        return  mapper.insertUser(userDto);
    } //end insertUser

} //end class
