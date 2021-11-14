package com.pm.myapp.mapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.pm.myapp.domain.MyPartyVO;
import com.pm.myapp.domain.PartyDTO;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MapperTests {

	@Setter(onMethod_= {@Autowired})
	private MyPartyMapper mapper;

	@Before
	public void setup() {
		log.debug("setup() invoked.");
		
		assert this.mapper != null;
		log.info("\t + mapper : {}", this.mapper);
		log.info("\t + type : {}", this.mapper.getClass().getName());
	} // setup
	
	@Test
	public void testQuitParty() { // 통과 완료
		log.debug("testQuitParty() invoked.");
		
		String email = "test4@test.com";
		Integer partyCode = 5;
		
		int affectedLines = this.mapper.quitParty(email, partyCode);
		log.info("\t+ affectedLines : {}",affectedLines);
		
	} // testQuitParty
	
	@Test
	public void testGetList() { // 통과 완료
		log.debug("testGetList() invoked.");
		
		String email = "test4@test.com";
		MyPartyVO party = this.mapper.getList(email);
		log.info("\t+party : {}",party);
		
	} // testGetList
	
	@Test
	public void testMakeParty() { // 통과 완료
		log.debug("testMakeParty() invoked.");
		
		PartyDTO dto = new PartyDTO();
		dto.setPartyName("여행가자");
		dto.setPartyCode(23);
		dto.setPartyProfile("여행갈래?");
		dto.setLocalCode(1);
		dto.setHobbyCode(8);
		
		int affectedLines = this.mapper.makeParty(dto);
		log.info("\t+ affectedLines : {}",affectedLines);

	} // testMakeParty
	
	@Test
	public void testXXX() {
		log.debug("testGetlist() invoked.");

	} // testXXX
	
	@After
	public void tearDown() {
		log.debug("tearDown() invoked.");
	} // tearDown
	
} // end class
