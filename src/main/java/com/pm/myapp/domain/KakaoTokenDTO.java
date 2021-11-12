package com.pm.myapp.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KakaoTokenDTO {

    String token_type;
    String access_token;
    Integer expires_in;
    String refresh_token;
    Integer refresh_token_expires_in;
    String scope;

} //end class
