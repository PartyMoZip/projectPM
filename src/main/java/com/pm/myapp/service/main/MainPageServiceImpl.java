package com.pm.myapp.service.main;

import com.pm.myapp.domain.MyPartyVO;
import com.pm.myapp.mapper.MainMapper;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@NoArgsConstructor

@Service
public class MainPageServiceImpl implements MainPageService {

    @Setter(onMethod_ = @Autowired)
    private MainMapper mapper;

    @Override
    public List<MyPartyVO> getMyPartyList(String email) {
        log.debug("Service getMyPartyList() invoked.");

        return this.mapper.getMyPartyList(email);
    } // end getMyPartyList

} // end class
