package com.pm.myapp.mapper;

import java.util.List;

import com.pm.myapp.domain.board.*;
import com.pm.myapp.mapper.board.FreeBoardMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.pm.myapp.domain.Criteria;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RunWith(SpringRunner.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class FreeMapperTests {

    @Setter(onMethod_= {@Autowired})
    private FreeBoardMapper mapper;

    @Before
    public void setup() {
        log.debug("setup() invoked.");

        assert this.mapper != null;
        log.info("\t + mapper : {}", this.mapper);
        log.info("\t + type : {}", this.mapper.getClass().getName());
    } // setup

    @Test
    public void testGetlistWithPaging() { // 자유 게시판 목록 - 페이징 처리 - 테스트완료
        log.debug("testGetlistWithPaging() invoked.");
        Criteria cri = new Criteria();
        cri.setAmount(1);
        cri.setAmount(10);

       // List<FreeBoardListVO> list = this.mapper.getListWithPaging(searchWord, option, cri);
        //list.forEach(log::info); // 람다식과

    } // testGetlistWithPaging

    @Test
    public void testReadFreeBoard() { // 자유 게시판 상세보기 - 테스트 완료
        log.debug("testReadFreeBoard() invoked.");

        int frefer = 1;
        FreeBoardVO board = this.mapper.readFreeBoard(frefer);
        log.info("\t + board : {}", board);

    } // testRead

   /* @Test
    public void testRegisterFreeBoard() { // 자유 게시판 등록 - 테스트 완료
        log.debug("testRegisterFreeBoard() invoked.");

        FreeBoardDTO dto = new FreeBoardDTO();
        dto.setFSubject("TEST1");
        dto.setFContent("TEST1");
        dto.setEmail("test11@test.com");
        dto.setFreePhoto("");

        int affectedLines = this.mapper.registerFreeBoard(dto);
        log.info("\t + affectedLines : {}", affectedLines);

    } // testRegisterFreeBoard*/

    @Test
    public void testGetTotalCount() { // 자유 게시판 총 게시물 개수 - 테스트완료
        log.debug("testGetTotalCount() invoked.");

       // Integer totalCount = this.mapper.getTotalCount();
        //log.info("\t + totalCount : {}", totalCount);

    } // testGetTotalCount

    @Test
    public void testDeleteFreeBoard() { // 자유 게시판 삭제 - 테스트 완료
        log.debug("testDeleteFreeBoard() invoked.");

       // int frefer = 3;
        int affectedLines=this.mapper.deleteFreeBoard(2);
        log.info("\t + affectedLines : {}", affectedLines);

    } // testDelete


    @Test
    public void testUpdateFreeBoard() { // 자유 게시판 수정 - 테스트 완료
        log.debug("testUpdate() invoked.");

        FreeBoardDTO newBoard = new FreeBoardDTO();
        newBoard.setFRefer(5);
        newBoard.setFSubject("TEST_TEST");
        newBoard.setFContent("TEST_TEST");
        newBoard.setFreePhoto("");
        int affectedLines = this.mapper.updateFreeBoard(newBoard);
        log.info("\t + affectedLines : {}", affectedLines);

    } // testUpdate


    @Test
    public void testSearchFreeBoard() { //자유 게시판 검색 - 테스트 완료
        log.debug("testSearchFreeBoard() invoked.");

        String searchOption= "f.fsubject";
        String keyword="%T%";
        Criteria cri = new Criteria();
        cri.setAmount(10);
        cri.setCurrPage(1);
        cri.setPagesPerPage(10);
        List<FreeBoardSearchVO> list = this.mapper.searchFreeBoard(searchOption, keyword, cri);
        log.info("\t + list : {}", list);

    } // testSearchFreeBoard

    @Test
    public void testGetCommentListPaging() { // 자유 게시판 댓글 목록 - 테스트 완료
        log.debug("testGetComment() invoked.");
        Criteria cri = new Criteria();
        cri.setAmount(1);
        cri.setAmount(10);
        List<FreeBoardReplyVO> list = this.mapper.getCommentListPaging(1, cri);
        list.forEach(log::info);
    }

    @Test
    public void testWriteComment() { // 자유 게시판 댓글 등록 - 테스트 완료
        log.debug("testWriteComment() invoked.");
        FreeBoardReplyDTO dto = new FreeBoardReplyDTO();
        dto.setFrecontent("댓글아 써져라");
        dto.setFredate(null);
        dto.setFrefer(1);
        dto.setEmail("test11@test.com");

        int affectedLines = this.mapper.writeComment(dto);
        log.info("\t + affectedLines : {}", affectedLines);
    }

    @Test
    public void testEditComment() { // 자유 게시판 댓글 수정 - 테스트 완료
        log.debug("testEditComment() invoked.");
        FreeBoardReplyDTO reply = new FreeBoardReplyDTO();
        reply.setFrerefer(9);
        reply.setFrecontent("내일 노래방 가는건가요");

        int affectedLines = this.mapper.editComment(reply);
        log.info("\t + affectedLines : {}", affectedLines);

    }

    @Test
    public void testDeleteComment() { // 자유 게시판 댓글 삭제 - 테스트 완료
        log.debug("testDeleteComment() invoked.");

        int affectedLines=this.mapper.deleteComment(6);
        log.info("\t + affectedLines : {}", affectedLines);
    }

    @After
    public void tearDown() {
        log.debug("tearDown() invoked.");
    } // tearDown
}

