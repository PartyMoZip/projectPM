package com.pm.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Profile;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(
        {"profile_needs_agreement","profile_nickname_needs_agreement" , "profile_image_needs_agreement"
                ,"email_needs_agreement" , "is_email_valid" , "is_email_verified" , "has_email", "gender"
        })//필요없는 것들 제외 시키기(안하는 오류남)

//kakaouserdto의 연결되어 있음
public class KakaoAccount {

    private KakaoProfile profile;
    private String email;

} //end class
