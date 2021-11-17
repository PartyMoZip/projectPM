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
import com.pm.myapp.domain.PartyDTO;
import com.pm.myapp.domain.PartyUserVO;
import com.pm.myapp.domain.PartyVO;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

/*
	PartyMapper 테스트 모두 통과
	2021.11.10
	김진건
*/


@Log4j2
@NoArgsConstructor

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class PartyMapperTests {

	@Setter(onMethod_= {@Autowired})
	private PartyMapper mapper;

	@Before
	public void setup() {
		log.debug("setup() invoked.");
		
		assert this.mapper != null;
		log.info("\t + mapper : {}", this.mapper);
		log.info("\t + type : {}", this.mapper.getClass().getName());
	} // setup
	
	
	@Test
	public void testGetInfo() { // 성공
		log.debug("testGetInfo() invoked.");
		
		int partycode = 1;
		PartyVO result = this.mapper.getInfo(partycode);
		log.info("\t+ result : {}",result);

	} // testGetInfo
	
	@Test
	public void testMakeJoin() { // 성공
		log.debug("testMakeJoin() invoked.");
		
		String email = "test1@test.com";
		int partyCode = 1;
		int result = this.mapper.makeJoin(email,partyCode);
		log.info("\t+ result : {}",result);

	} // testMakeJoin
	
	@Test
	public void testDeleteJoin() { // 성공
		log.debug("testDeleteJoin() invoked.");
		
		String email = "test1@test.com";
		int partyCode = 1;
		int result = this.mapper.deleteJoin(email,partyCode);
		log.info("\t+ result : {}",result);

	} // testDeleteJoin
	
	@Test
	public void testModifyInfo() { // 성공
		log.debug("testModifyInfo() invoked.");
		
		PartyDTO dto = new PartyDTO();
		dto.setPartyName("행복하다 행복풀");
		dto.setPartyProfile("제라드 형님.. 하늘에서 지켜봐주세요..");
		dto.setLocalCode(1);
		dto.setHobbyCode(1);
		dto.setPartyCode(10);
		
		int result = this.mapper.modifyInfo(dto);
		log.info("\t+ result : {}",result);

	} // testModifyInfo
	
	@Test
	public void testMakeDesPartyReq() { // 성공
		log.debug("testMakeDesPartyReq() invoked.");
		
		int partyCode = 10;
		int result = this.mapper.makeDesPartyReq(partyCode);
		log.info("\t+ result : {}",result);

	} // testModifyInfo
	
	@Test
	public void testDelegatePL() { // 성공
		log.debug("testDelegatePL() invoked.");
		
		int authCode = 2;
		String email = "test1@test.com";
		int partyCode = 10;
		int result = this.mapper.delegatePL(authCode,email,partyCode);
		log.info("\t+ result : {}",result);

	} // testDelegatePL
	
	@Test
	public void testUpgradeJoin() { // 성공
		log.debug("testUpgradeJoin() invoked.");
		
		String email = "test1@test.com";
		int partyCode = 10;
		int result = this.mapper.upgradeJoin(email,partyCode);
		log.info("\t+ result : {}",result);

	} // testUpgradeJoin
	
	@Test
	public void testGetMember() { // 성공
		log.debug("testGetMember() invoked.");
		
		Criteria cri = new Criteria();
		
		int partyCode = 14;
		List<PartyUserVO> list = this.mapper.getMember(partyCode, cri);
		log.info("\t+ list : {}",list);

	} // testGetMember
	
	@After
	public void tearDown() {
		log.debug("tearDown() invoked.");
	} // tearDown
	
} // end class
