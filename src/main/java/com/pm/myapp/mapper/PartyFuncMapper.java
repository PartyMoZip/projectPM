package com.pm.myapp.mapper;

import com.pm.myapp.domain.CalendarDTO;
import com.pm.myapp.domain.UserDTO;

import java.util.List;

public interface PartyFuncMapper {

    public abstract List<CalendarDTO> calendarList();

    //풀캘린더 insert
    public abstract int insertCal(CalendarDTO calendarDTO);

    public abstract int deleteCalendar(int id);


} //end interface
