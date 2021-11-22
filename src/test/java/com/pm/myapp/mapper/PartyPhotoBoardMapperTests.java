package com.pm.myapp.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.ReplyCriteria;
import com.pm.myapp.domain.board.PartyPhotoDTO;
import com.pm.myapp.domain.board.PartyPhotoReDTO;
import com.pm.myapp.mapper.board.PartyPhotoMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class PartyPhotoBoardMapperTests {

	@Setter(onMethod_= {@Autowired})
	private PartyPhotoMapper mapper;

	@Before
	public void setup() { // TEST OK
		log.debug("setup() invoked.");
		
		assert this.mapper != null;
		log.info("\t + mapper : {}", this.mapper);
		log.info("\t + type : {}", this.mapper.getClass().getName());
	} // setup
	
	
	@Test
	public void testGetList() { // TEST OK
		log.debug("testGetlist() invoked.");
		
		int partyCode = 1;
		Criteria cri = new Criteria();
		cri.setCurrPage(1);
		cri.setAmount(10);
		cri.setPagesPerPage(10);
		String searchWord = "L";
		int option = 1;
		
		
		List<PartyPhotoDTO> list = this.mapper.getList(partyCode, searchWord, option, cri);
		log.info("\t+ list : {}",list);
		int count =this.mapper.getTotalList(partyCode,searchWord, option);
		log.info("\t+ count : {}",count);

	} // testGetList
	
	@Test
	public void testGetDetail() { // TEST OK
		log.debug("testGetDetail() invoked.");
		
		int partyCode = 1;
		int prefer = 1;
		
		PartyPhotoDTO dto = this.mapper.getDetail(partyCode, prefer);
		log.info("\t+ dto : {}",dto);

	} // testGetDetail
	
	@Test
	public void testGetPhoto() { // TEST OK
		log.debug("testGetPhoto() invoked.");
		
		int partyCode = 1;
		int prefer = 1;
		
		List<String> list = this.mapper.getPhoto(partyCode, prefer);
		log.info("\t+ list : {}",list);

	} // testGetPhoto
	
	@Test
	public void testGetReplyList() { // TEST OK
		log.debug("testGetReplyList() invoked.");
		
		int partyCode = 1;
		int prefer = 1;
		ReplyCriteria recri = new ReplyCriteria();
		recri.setReCurrPage(1);
		recri.setReAmount(10);
		recri.setRePagesPerPage(10);
		
		List<PartyPhotoReDTO> list = this.mapper.getReplyList(partyCode, prefer,recri);
		log.info("\t+ list : {}",list);
		int count =this.mapper.getTotalReply(partyCode,prefer);
		log.info("\t+ count : {}",count);

	} // testGetReplyList
	
	@Test
	public void testWritePhotoBoard() { // TEST OK
		log.debug("testWritePhotoBoard() invoked.");
		
		PartyPhotoDTO dto = new PartyPhotoDTO();
		dto.setPartycode(1);
		
		// 파티별 게시판 최대 MaxRefer 찾기
		Integer refer = this.mapper.maxRefer(dto);
		log.info("\t+ refer : {}", refer);
		Integer newRefer = refer + 1;
		dto.setPrefer(newRefer);
		
		dto.setPsubject("제목");
		dto.setPcontent("내용");
		dto.setEmail("test1@test.com");		
		
		int count = this.mapper.writePhotoBoard(dto);
		log.info("\t+ count : {}",count);
		
		Map<String, Object> imageInfo = new HashMap<>();
		imageInfo.put("prefer", 2);
		imageInfo.put("fileLocation", "test");
		imageInfo.put("partyCode", 1);
		
		Integer result = this.mapper.registerImage(imageInfo);
		log.info("\t+ result : {}",result);

	} // testWritePhotoBoard
	
	@Test
	public void testUpdatePhotoBoard() { // TEST OK
		log.debug("testUpdatePhotoBoard() invoked.");
		
		PartyPhotoDTO dto = new PartyPhotoDTO();
		dto.setPartycode(1);
		dto.setPrefer(2);		
		dto.setPsubject("제목_수정");
		dto.setPcontent("내용_수정");

		int count = this.mapper.updatePartyPhoto(dto);
		log.info("\t+ count : {}",count);
		
		String file = "test";
		
		Integer result = this.mapper.deletePhoto(file);
		log.info("\t+ result : {}",result);

	} // testUpdatePhotoBoard
	
	@Test
	public void testDeletePhotoBoard() { // TEST OK
		log.debug("testDeletePhotoBoard() invoked.");
		
		int partyCode = 1;
		int prefer = 2;

		Integer count1 = this.mapper.deletePhotoReply(prefer, partyCode);
		log.info("\t+ count1 : {}",count1);
		
		Integer count2 = this.mapper.deletePhotoBoard(prefer, partyCode);
		log.info("\t+ count2 : {}",count2);

	} // testDeletePhotoBoard
	
	@After
	public void tearDown() {
		log.debug("tearDown() invoked.");
	} // tearDown
	
} // end class






