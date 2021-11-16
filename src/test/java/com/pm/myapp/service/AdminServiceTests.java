package com.pm.myapp.service;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pm.myapp.service.admin.AdminService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class AdminServiceTests {
	
	@Setter(onMethod_= {@Autowired})
	private AdminService service;

	@Before
	public void setup() {
		log.debug("setup() invoked.");
		
		// DI 검증 수행
		assertNotNull(this.service);
		log.info("\t + service : {}",this.service);		
		
	} // setup
		
	@Test
	public void testKickUser() { // 통과
		log.debug("testKickUser() invoked.");
		String email = "test7@test.com";
		
		boolean result = this.service.kickUser(email);
		log.info("\t+ result : {}", result);
		
	} // testKickUser
	
	@Test
	public void testBreakParty() { // 통과
		log.debug("testBreakParty() invoked.");
		Integer partyCode = 20;
		
		boolean result = this.service.breakParty(partyCode);
		log.info("\t+ result : {}", result);
		
	} // testBreakParty
	
		
	@After
	public void tearDown() {
		log.debug("tearDown() invoked.");
	} // tearDown

	
} // end class
