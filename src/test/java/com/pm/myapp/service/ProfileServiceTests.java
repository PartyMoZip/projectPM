package com.pm.myapp.service;


import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.service.main.ProfileService;
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
public class ProfileServiceTests {

    @Autowired
    private ProfileService service;

    @Before
    public void setup(){
        log.debug("setup() invoked.");

        assert this.service != null;
        log.info("service: {}", service);
    } // setup

    @Test
    public void testGetMyPartyList(){
        log.debug("testGetMyPartyList() invoked.");

        String email = "test5@test.com";

        List<PartyVO> list = this.service.getMyPartyList(email);

        list.forEach(log::info);
    } // testGetMyPartyList

    @Test
    public void testEditProfileImage(){
        log.debug("testEditProfileImage() invoked.");

        Map<String, Object> profile = new HashMap<>();
        profile.put("email", "test5@test.com");
        profile.put("fileLocation", "서비스 프로필 이미지 수정");

        int result = this.service.editProfileImage(profile);

        log.info("result: {}", result);
    } // testEditProfileImage

    @Test
    public void testWithdrawal(){
        log.debug("testWithdrawal() invoked.");

        String email = "gragas@sultong1.com";

        int result = this.service.withdrawal(email);

        log.info("result: {}", result);
    } // testWithdrawal

} // end class
