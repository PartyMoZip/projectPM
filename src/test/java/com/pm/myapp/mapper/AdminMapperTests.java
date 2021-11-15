
package com.pm.myapp.mapper;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.pm.myapp.domain.BlackMemberVO;
import com.pm.myapp.domain.BlackPartyVO;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AdminMapperTests {

	@Setter(onMethod_= {@Autowired})
	private AdminMapper mapper;

	@Before
	public void setup() {
		log.debug("setup() invoked.");
		
		assert this.mapper != null;
		log.info("\t + mapper : {}", this.mapper);
		log.info("\t + type : {}", this.mapper.getClass().getName());
	} // setup
	
	
	@Test
	public void testGetBlackMember() { // 통과
		log.debug("testGetBlackMember() invoked.");
		
		List<BlackMemberVO> blackMember = this.mapper.getBlackMember();
		log.info("\t+ blackMember : {}", blackMember);

	} // testGetBlackMember
	
	@Test
	public void testGetBlackParty() { // 통과
		log.debug("testGetBlackParty() invoked.");
		
		List<BlackPartyVO> blackParty = this.mapper.getBlackParty();
		log.info("\t+ blackParty : {}", blackParty);

	} // testGetBlackParty
	
	@After
	public void tearDown() {
		log.debug("tearDown() invoked.");
	} // tearDown
	
} // end class






