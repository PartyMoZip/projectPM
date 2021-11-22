package com.pm.myapp.domain.naver;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NaverTokenDTO {

    String access_token;
    String refresh_token;
    String token_type;
    Integer expires_in;
    String error;
    String error_description;

} //end class
