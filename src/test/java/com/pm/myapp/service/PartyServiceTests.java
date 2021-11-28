package com.pm.myapp.service;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.domain.board.PartyFreeDTO;
import com.pm.myapp.domain.board.PartyFreeReplyVO;
import com.pm.myapp.domain.board.PartyFreeVO;
import com.pm.myapp.service.board.PartyFreeService;
import com.pm.myapp.service.partyfm.PartyService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertNotNull;

@Log4j2
@NoArgsConstructor
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "file:src/main/webapp/WEB-INF/spring/root-context.xml",
    "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class PartyServiceTests {

    @Setter(onMethod_= @Autowired)
    private PartyService service;

    @Before
    public void setup() {
        log.debug("setup() invoked.");

        assertNotNull(this.service);
        log.info("\t + service : {}", this.service);
    } // setup

    @Test
    public void testGetParty() {
        log.debug("testGetParty() invoked.");

        PartyVO party = this.service.getParty(9);

        log.info("\t + party : {}", party);
    } // testGetParty


    @After
    public void tearDown() {
        log.debug("tearDown() invoked.");
    } // tearDown


}


