package com.pm.myapp.domain.board;


import lombok.Value;
import java.util.Date;

@Value
public class FreeBoardListVO {

    private Integer fRefer;
    private String fSubject;
    private Date fDate;
    private String nickname;
    private Integer readnum;

} // end class
