package com.pm.myapp.domain.naver;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties({"birthyear", "id"})
public class Response {

    String name;
    String email;
    String profile_image;

} //end class
