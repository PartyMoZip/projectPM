package com.pm.myapp.service;


import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.service.main.MainPageService;
import com.pm.myapp.service.partyfm.MyPartyService;
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
import java.util.Objects;

@Log4j2
@NoArgsConstructor

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class MyPartyServiceTests {

    @Setter(onMethod_ = {@Autowired})
    private MainPageService service;

    @Setter(onMethod_ = @Autowired)
    private MyPartyService myPartyService;

    @Before
    public void setup() {
        log.debug("setup() invoked.");

        assert this.service != null;
    } // setup

    @Test
    public void testGetMyPartyList(){
        log.debug("test() invoked.");

        Criteria cri = new Criteria();
        cri.setCurrPage(1);
        cri.setAmount(3);

        // String email = "test5@test.com";
        String email = "";

        List<PartyVO> list = this.myPartyService.getMyPartyList(email);

        Objects.requireNonNull(list);
        list.forEach(log::info);
    }

} // end class
