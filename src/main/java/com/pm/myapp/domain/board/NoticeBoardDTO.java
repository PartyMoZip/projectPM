package com.pm.myapp.domain.board;

import lombok.Data;

import java.util.Date;

@Data
public class NoticeBoardDTO {

    private Integer nRefer;
    private String nSubject;
    private String nContent;
    private String email;

}
