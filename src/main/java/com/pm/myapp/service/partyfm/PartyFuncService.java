package com.pm.myapp.service.partyfm;

import com.pm.myapp.domain.CalendarDTO;

import java.util.List;

public interface PartyFuncService {

    public abstract List<CalendarDTO> calendarList(Integer partyCode);

    public abstract Integer insertCal(CalendarDTO calendarDto);

    public abstract Integer deleteCalendar(int id);


} //end interface
