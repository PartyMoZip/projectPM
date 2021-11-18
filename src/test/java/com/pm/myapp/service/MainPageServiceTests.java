package com.pm.myapp.service;


import com.pm.myapp.domain.MyPartyVO;
import com.pm.myapp.service.main.MainPageService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@Log4j2
@NoArgsConstructor

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class MainPageServiceTests {

    @Setter(onMethod_ = {@Autowired})
    private MainPageService service;

    @Before
    public void setup() {
        log.debug("setup() invoked.");

        assert this.service != null;
    } // setup

    @Test
    public void testGetMyPartyList() {
        log.debug("testGetMyPartyList() invoked.");

        String email = "test5@test.com";

        List<MyPartyVO> list = this.service.getMyPartyList(email);
        log.info("list: {}", list);

        assert list != null;

        list.forEach(log::info);
    } // testGetMyPartyList

} // end class
