package com.pm.myapp.domain;

import lombok.Value;

@Value
public class UserVO {

    private String email;
    private String nickname;
    private String userPic;
    private Integer userBanned;

}//UserVO
