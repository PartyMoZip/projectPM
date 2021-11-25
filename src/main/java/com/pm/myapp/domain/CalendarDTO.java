package com.pm.myapp.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class CalendarDTO {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private Integer partyCode;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date start;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date end;
    private boolean allDay;

} //end class
