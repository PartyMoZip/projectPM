package com.pm.myapp.service;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.board.*;
import com.pm.myapp.service.board.FreeBoardService;
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
public class FreeServiceTests {
	
	@Setter(onMethod_= {@Autowired})
	private FreeBoardService service;

	@Before
	public void setup() {
		log.debug("setup() invoked.");
		
		// DI 검증 수행
		assertNotNull(this.service);
		log.info("\t + service : {}",this.service);		
		
	} // setup
		
	@Test
	public void testRegister() {
		log.debug("testRegister() invoked.");

		FreeBoardDTO dto = new FreeBoardDTO();
		dto.setFSubject("TEST1");
		dto.setFContent("TEST1");
		dto.setEmail("test11@test.com");

		boolean affectedLine = this.service.writeBoard(dto);

		log.info("\t + affectedLine : {}" ,affectedLine);

	} // testRegister

	@Test
	public void testModify() {
		log.debug("testModify() invoked.");

		//FreeBoardListVO board = new FreeBoardListVO(1, "Test", null, "test", null);
		//Objects.requireNonNull(board);
	//	log.info("\t + board : {}", board);
	} // testModify

	@Test
	public void testRemove() {
		log.debug("testRemove() invoked.");

		int frefer = 2;
		boolean isSuccess = this.service.deleteBoard(frefer);
		log.info("\t + isSuccess : {}", isSuccess);

	} // testRemove

	@Test
	public void testGetBoardDetail() {
		log.debug("testGet() invoked.");

		int frefer = 4;
		FreeBoardVO board = this.service.getBoardDetail(frefer);

		Objects.requireNonNull(board);
		log.info("\t + board : {}", board);
	}

	@Test
	public void testGetListPerPage() {
		log.debug("testGetListPerPage() invoked.");

		Criteria cri = new Criteria();
		cri.setCurrPage(1);
		cri.setAmount(10);

		//List<FreeBoardListVO> boardList = this.service.getListPerPage(cri);

	//	Objects.requireNonNull(boardList);
	//	boardList.forEach(log::info);

	} // testGetListPerPage

	@Test
	public void testSearch() {
		log.debug("testSearch() invoked.");

		String searchOption= "f.fsubject";
		String keyword="%1%";
		Criteria cri = new Criteria();
	//	List<FreeBoardSearchVO> list = this.service.search(searchOption, keyword, cri);
	//	list.forEach(log::info);

	}

	@Test
	public void testGetTotal() {
		log.debug("testGetTotal() invoked.");
	//	int totalCount = this.service.getTotal();
	//	log.info("\t + totalCount : {}", totalCount);
	}

	@Test
	public void testWriteComment() {
		log.debug("testRegister() invoked.");

	//	FreeBoardReplyVO boardReply = new FreeBoardReplyVO(7,"TestTitle",null,1, "test2@test.com");
	//	log.info("\t + new Comment : {}", boardReply.getFrerefer());
	}

	@Test
	public void testEditComment() {
		log.debug("testEditComment() invoked.");

	//	FreeBoardReplyVO boardReply = new FreeBoardReplyVO(1, "TEST",  null, 1, "test2@test.com");
	//	Objects.requireNonNull(boardReply);
//		log.info("\t + boardReply : {}", boardReply);
	}

	@Test
	public void testGetCommentListPaging() {
		log.debug("testGetListReply() invoked.");
		Criteria cri = new Criteria();
		cri.setCurrPage(1);
		cri.setAmount(10);
	//	List<FreeBoardReplyVO> replyList = this.service.getReply(1, cri);
	//	Objects.requireNonNull(replyList);
	//	replyList.forEach(log::info);
	}

	@Test
	public void testDeleteReply() {
		log.debug("testDeleteReply() invoked.");

		int frerefer = 2;
//		boolean isSuccess = this.service.deleteReply(frerefer);
//		log.info("\t + isSuccess : {}", isSuccess);
	}

	@Test
	public void testGetTotalReply() {
		log.debug("testTotalReply");

//		int totalCount = this.service.getTotalReply();
//		log.info("\t + totalCount : {}", totalCount);
	}
		
	@After
	public void tearDown() {
		log.debug("tearDown() invoked.");
	} // tearDown

	
} // end class
