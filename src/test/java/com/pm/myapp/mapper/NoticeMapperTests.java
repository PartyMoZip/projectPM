package com.pm.myapp.mapper;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.board.NoticeBoardDTO;
import com.pm.myapp.domain.board.NoticeBoardListVO;
import com.pm.myapp.domain.board.NoticeBoardSearchVO;
import com.pm.myapp.domain.board.NoticeBoardVO;
import com.pm.myapp.mapper.board.NoticeBoardMapper;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Log4j2
@NoArgsConstructor

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class NoticeMapperTests {

	@Setter(onMethod_= {@Autowired})
	private NoticeBoardMapper mapper;

	@Before
	public void setup() {
		log.debug("setup() invoked.");
		
		assert this.mapper != null;
		log.info("\t + mapper : {}", this.mapper);
		log.info("\t + type : {}", this.mapper.getClass().getName());
	} // setup

	@Test
	public void testGetListWithPaging() { // 공지 게시판 목록 - 페이징 처리 - 테스트 완료
		log.debug("testGetListWithPaging() invoked.");
		Criteria cri = new Criteria();
		cri.setAmount(1);
		cri.setAmount(10);
//		List<NoticeBoardListVO> list = this.mapper.getListWithPaging(cri);
//		list.forEach(log::info);

	} // testGetListWithPaging


	@Test
	public void testReadNoticeBoard() { // 공지 게시판 상세보기 - 테스트 완료
		log.debug("testReadNoticeBoard() invoked.");

		int nrefer = 3;
		NoticeBoardVO board = this.mapper.readNoticeBoard(nrefer);
		log.info("\t + board : {}", board);

	} // testReadNoticeBoard

	@Test
	public void testWriteNoticeBoard() { // 공지 게시판 등록 - 테스트 완료
		log.debug("testWriteNoticeBoard() invoked.");

		NoticeBoardDTO dto = new NoticeBoardDTO();
		dto.setNSubject("Notice Test");
		dto.setNContent("test!");
		dto.setEmail("test1@test.com");

		int affectedLines = this.mapper.writeNoticeBoard(dto);
		log.info("\t + affectedLindes : {}", affectedLines);

	} // testWriteNoticeBoard

	@Test
	public void testGetTotalCount() { // 공지 게시판 총 게시물 개수 - 테스트 완료
		log.debug("testGetTotalCount() invoked.");

		//Integer totalCount = this.mapper.getTotalCount();
		//log.info("\t + totalCount : {}", totalCount);

	} // testGetTotalCount

	@Test
	public void testDeleteNoticeBoard() { // 공지 게시판 삭제 - 테스트 완료
		log.debug("testDeleteNoticeBoard() invoked.");

		int affectedLines = this.mapper.deleteNoticeBoard(4);
		log.info("\t + affectedLines : {}", affectedLines);

	} // testDeleteNoticeBoard

	@Test
	public void testEditNoticeBoard() { // 자유 게시판 수정 - 테스트 완료
		log.debug("testEditNoticeBoard() invoked.");

		NoticeBoardDTO dto = new NoticeBoardDTO();
		dto.setNRefer(3);
		dto.setNSubject("고쳤다");
		dto.setNContent("ADMIN TEST");
		dto.setEmail("test2@test.com");
		int affectedLines = this.mapper.editNoticeBoard(dto);
		log.info("\t + affectedLines : {}", affectedLines);
	} // testEditNoticeBoard

	@Test
	public void testSearchNoticeBoard() { // 공지 게시판 검색 - 테스트 완료
		log.debug("testSearchNoticeBoard() invoked.");

		String searchOption = "n.nsubject";
		String keyword = "%왜%";
		Criteria cri = new Criteria();
		cri.setAmount(10);
		cri.setCurrPage(1);
		cri.setPagesPerPage(10);
		List<NoticeBoardSearchVO> list = this.mapper.searchNoticeBoard(searchOption, keyword, cri);
		log.info("\t + list : {}", list);

	} // testSearchNoticeBoard

	@After
	public void tearDown() {
		log.debug("tearDown() invoked.");
	} // tearDown
	
} // end class
