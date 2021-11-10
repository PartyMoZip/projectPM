package com.pm.myapp.domain;

import lombok.*;

@Getter
@Setter
@ToString
public class UserDTO {

    private String email;
    private String nickname;
    private String userPic;
    private Integer userBanned;

} //end class
