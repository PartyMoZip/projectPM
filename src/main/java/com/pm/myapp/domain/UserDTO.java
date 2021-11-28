package com.pm.myapp.domain;

import lombok.*;

@Data
public class UserDTO {
	
	private Integer rownum;
    private String nickname;
    private String email;
    private String userPic;
    private Integer userBanned;

} //end class
