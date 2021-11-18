package com.pm.myapp.mapper;

import com.pm.myapp.domain.MyPartyVO;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Log4j2
@NoArgsConstructor

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MainMapperTests {

    @Setter(onMethod_ = @Autowired)
    private MainMapper mapper;

    @Before
    public void setup() {
        log.debug("setup() invoked.");

        assert this.mapper != null;
        log.info("\t+mapper: {}", this.mapper);
    } // setup

    @Test
    public void testGetMyPartyList() {
        log.debug("testGetMyPartyList() invoked.");

        String email = "test5@test.com";

        List<MyPartyVO> list = this.mapper.getMyPartyList(email);
        list.forEach(log::info);
    } // end testGetMyPartyList

} // end class
