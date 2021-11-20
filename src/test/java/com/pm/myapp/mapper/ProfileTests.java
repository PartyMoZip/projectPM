package com.pm.myapp.mapper;


import com.pm.myapp.domain.PartyVO;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ProfileTests {

    @Setter(onMethod_ = @Autowired)
    private ProfileMapper mapper;

    @Before
    public void setup() {
        log.debug("setup() invoked.");

        assert this.mapper != null;
        log.info("\t + mapper : {}", this.mapper);
        log.info("\t + type : {}", this.mapper.getClass().getName());
    } // setup

    @Test
    public void testGetMyPartyList() {
        log.debug("testGetMyPartyList() invoked.");

        String email = "";
        String email2 = "test5@test.com";

        List<PartyVO> list = this.mapper.getMyPartyList(email);

        log.info("\t+ list : {}", list);

    } // testGetMyPartyList

    @Test
    public void testModifyProfileImage() {
        log.debug("testModifyProfileImage() invoked.");

        Map<String, Object> profile = new HashMap<>();
        profile.put("email", "test5@test.com");
        profile.put("nickname", "테스트");
        profile.put("fileLocation", "");

        int result = this.mapper.modifyProfile(profile);

        log.info("result: {}", result);

    } // testModifyProfileImage

    @Test
    public void testDeleteUser() {
        log.debug("testDeleteUser() invoked.");

        String email = "gragas@sultong.com";

        int result = this.mapper.deleteUser(email);

        log.info("result: {}", result);
    } // testDeleteUser

} // end class
