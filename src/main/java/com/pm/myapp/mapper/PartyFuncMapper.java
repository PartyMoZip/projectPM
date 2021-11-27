package com.pm.myapp.mapper;

import com.pm.myapp.domain.CalendarDTO;
import com.pm.myapp.domain.UserDTO;

public interface PartyFuncMapper {

    //풀캘린더 insert
    public abstract int insertCal(CalendarDTO calendarDTO);


} //end interface
