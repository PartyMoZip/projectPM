package com.pm.myapp.service.partyfm;
import com.pm.myapp.domain.CalendarDTO;
import com.pm.myapp.mapper.PartyFuncMapper;
import com.pm.myapp.mapper.PartyMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@Service
public class PartyFuncServiceImpl implements PartyFuncService{

    @Setter(onMethod_= {@Autowired})
    private PartyFuncMapper mapper;

    @Override
    public Integer insertCal(CalendarDTO calendarDto) {
        return mapper.insertCal(calendarDto);
    }

} //end class
