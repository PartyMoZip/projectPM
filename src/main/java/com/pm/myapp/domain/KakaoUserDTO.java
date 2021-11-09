package com.pm.myapp.domain;

import lombok.Value;

@Value
public class KakaoUserDTO {

    private int id;
    private String connected_at;
    private KakaoProperties properties;
    private KakaoAccount kakao_account;

} //end class
