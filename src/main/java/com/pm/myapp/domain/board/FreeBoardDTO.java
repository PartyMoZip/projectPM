package com.pm.myapp.domain.board;

import lombok.Data;

import java.util.Date;

@Data
public class FreeBoardDTO {

    private Integer fRefer;
    private String fSubject;
    private String fContent;
    private String email;
    private String freePhoto;

} // end class
