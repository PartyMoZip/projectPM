package com.pm.myapp.service;


import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.service.main.UserService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@NoArgsConstructor

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class UserServiceTests {

    @Autowired
    private UserService service;

    @Before
    public void setup(){
        log.debug("setup() invoked.");

        assert this.service != null;
        log.info("service: {}", service);
    } // setup

    @Test
    public void testGetMyPartyList(){
        log.debug("testGetMyPartyList() invoked.");

        String email = "chicori3@gmail.com";

        List<PartyVO> list = this.service.getMyPartyList(email);

        list.forEach(log::info);
    } // testGetMyPartyList

    @Test
    public void testEditProfile(){
        log.debug("testEditProfile() invoked.");

        Map<String, Object> profile = new HashMap<>();
        profile.put("email", "test5@test.com");
        profile.put("nickname", "이시안");
        profile.put("fileLocation", "서비스 프로필 이미지 수정");

        boolean result = this.service.editProfile(profile);

        log.info("result: {}", result);
    } // testEditProfile

    @Test
    public void testWithdrawal(){
        log.debug("testWithdrawal() invoked.");

        String email = "gragas@sultong1.com";

        boolean result = this.service.withdrawal(email);

        log.info("result: {}", result);
    } // testWithdrawal

} // end class
