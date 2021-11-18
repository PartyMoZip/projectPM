package com.pm.myapp.domain.board;


import lombok.Value;

import java.util.Date;

@Value
public class FreeBoardVO {

    private Integer fRefer;
    private String fSubject;
    private String fContent;
    private Date fDate;
    private String nickname;
    private String freePhoto;
    private Integer readnum;

} // end class
