package com.pm.myapp.mapper;


import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.MyPartyListVO;
import com.pm.myapp.domain.PartyDTO;
import com.pm.myapp.domain.PartyVO;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyPartyMapperTests {

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
		
		Criteria cri = new Criteria();
		
		String email = "test1@test.com";
		MyPartyListVO party = this.mapper.getList(email,cri);
		log.info("\t+party : {}",party);
		
	} // testGetList
	
	@Test
	public void testGetTMPL() { // 통과완료
		log.debug("testGetTMPL() invoked.");
		
		String email = "test1@test.com";
		int totalNum = this.mapper.getTMPL(email);
		log.info("\t+ totalNum : {}",totalNum);

	} // testGetTMPL
	
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
	public void testGetRecParties() { // 통과완료
		log.debug("testGetRecParties() invoked.");
		
		Criteria cri = new Criteria();
		cri.setCurrPage(1);
		cri.setAmount(10);
		cri.setPagesPerPage(10);
		
		Integer[] hobbyCode = {1,2,3};
		List<MyPartyListVO> list = this.mapper.getRecParties(hobbyCode,cri);
		log.info("\t+ list : {}",list);

	} // testGetRecParties
	
	@Test
	public void testGetTRCP() { // 통과완료
		log.debug("testGetTRCP() invoked.");
		
		Integer[] hobbyCode = {1,2,3};
		int totalNum = this.mapper.getTRCP(hobbyCode);
		log.info("\t+ totalNum : {}",totalNum);

	} // testGetTRCP
	
	@After
	public void tearDown() {
		log.debug("tearDown() invoked.");
	} // tearDown
	
} // end class
