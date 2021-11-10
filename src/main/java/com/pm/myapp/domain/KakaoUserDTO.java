package com.pm.myapp.domain;

import lombok.*;

@Getter
@Setter
@ToString
public class KakaoUserDTO {

    private int id;
    private String connected_at;
    private Properties properties;
    private KakaoAccount kakao_account;

} //end class
