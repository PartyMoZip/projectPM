package com.pm.myapp.mapper;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.board.*;
import com.pm.myapp.mapper.board.PartyFreeMapper;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@Log4j2
@NoArgsConstructor

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class PartyFMapperTests {

    @Setter(onMethod_= {@Autowired})
    private PartyFreeMapper mapper;

    @Before
    public void setup() {
        log.debug("setup() invoked.");

        assert this.mapper != null;
        log.info("\t + mapper : {}", this.mapper);
        log.info("\t + type : {}", this.mapper.getClass().getName());
    } // setup

    @Test
    public void testGetListWithPaging() { // 파티 자유 게시판 목록 - 페이징 처리 - 테스트 완료
        log.debug("testGetListWithPaging() invoked.");
        Criteria cri = new Criteria();
        cri.setAmount(1);
        cri.setAmount(10);

        List<PartyFreeListVO> list = this.mapper.getListWithPaging(cri);
        list.forEach(log::info);
    } // testGetListWithPaging

    @Test
    public void testReadPFreeBoard() { // 파티 자유 게시판 상세보기 - 테스트 완료
        log.debug("testReadPFreeBoard() invoked.");

        int pfrefer = 5;
        int partycode = 2;
        PartyFreeVO board = this.mapper.readPFreeBoard(pfrefer, partycode);
        log.info("\t + board : {}", board);
    } //testReadPFreeBoard


    @Test
    public void testWritePFreeBoard() { // 파티 자유 게시판 등록 - 테스트 완료
        log.debug("testWritePFreeBoard() invoked.");

        PartyFreeDTO dto = new PartyFreeDTO();
        dto.setPfsubject("testParty");
        dto.setPfcontent("partyTest");
        dto.setEmail("test2@test.com");
        dto.setPartycode(2);

        int affectedLines = this.mapper.writePFreeBoard(dto);
        log.info("\t + affectedLines : {}", affectedLines);

    } //testWritePFreeBoard


    @Test
    public void testEditPFreeBoard() { // 파티 자유 게시판 수정 - 테스트 완료
        log.debug("testEditPFreeBoard() invoked.");

        PartyFreeDTO board = new PartyFreeDTO();
        board.setPfrefer(2);
        board.setPfcontent("노래좋아요");
        board.setPfsubject("감성터지네요");
        board.setEmail("test8@test.com");
        board.setPartycode(2);
        int affectedLines = this.mapper.editPFreeBoard(board);
        log.info("\t + affectedLines : {}", affectedLines);
    } // testEditPFreeBoard

    @Test
    public void testDeletePFreeBoard() { // 파티 자유 게시판 삭제 - 테스트 완료
        log.debug("testDeletePFreeBoard() invoked.");

        int affectedLines = this.mapper.deletePFreeBoard(4);
        log.info("\t + affectedLines", affectedLines);

    } // testDeletePFreeBoard

    @Test
    public void testSearchPartyFree() { // 파티 자유 게시판 검색 - 테스트 완료
        log.debug("testSearchPartyFree() invoked.");

        String searchOption= "pf.pfsubject";
        String keyword="%t%";
        Criteria cri = new Criteria();
        cri.setAmount(10);
        cri.setCurrPage(1);
        cri.setPagesPerPage(10);
        List<PartyFreeSearchVO> list = this.mapper.searchPartyFree(searchOption, keyword, cri);
        log.info("\t + list : {}", list);
    } // testSearchPartyFree

    @Test
    public void testGetTotalCount() { // 파티 자유 게시판 총 개수 - 테스트 완료
        log.debug("testGetTotalCount() invoked.");

        Integer totalCount = this.mapper.getTotalCount();
        log.info("\t + totalCount : {}", totalCount);
    } // testGetTotalCount


    @Test
    public void testGetCommentListPaging() { // 파티 자유 게시판 댓글 목록 - 테스트 완료
        log.debug("testGetCommentListPaging() invoked.");
        Criteria cri = new Criteria();
        cri.setAmount(1);
        cri.setAmount(10);
        List<PartyFreeReplyVO> list = this.mapper.getCommentListPaging(2,2, cri);
        list.forEach(log::info);
    }

    @Test
    public void testWriteComment() { // 파티 자유 게시판 댓글 등록 - 테스트 완료
        log.debug("testWriteComment() invoked.");
        PartyFreeReplyDTO dto = new PartyFreeReplyDTO();
        dto.setEmail("test2@test.com");
        dto.setPfrecontent("김진건 텐션 미쳤다.");
        dto.setPfrefer(2);
        dto.setPartycode(2);

        int affectedline = this.mapper.writeComment(dto);
        log.info("\t+ affectedline : {}",affectedline);
    }

    @Test
    public void testEditComment() { // 파티 자유 게시판 댓글 수정 -
        log.debug("testEditComment() invoked.");
        PartyFreeReplyDTO reply = new PartyFreeReplyDTO();
        reply.setPfrerefer(2);
        reply.setPfrecontent("진건텐션왜저래");
        reply.setEmail("test4@test.com");
        reply.setPartycode(2);

        int affectedLines = this.mapper.editComment(reply);
        log.info("\t + affectedLines : {}", affectedLines);
    }

    @Test
    public void testDeleteComment() { // 파티 자유 게시판 댓글 삭제 - 테스트 완료
        log.debug("testDeleteComment() invoked.");

        int affectedLines = this.mapper.deleteComment(2);
        log.info("\t + affectedLines : {}", affectedLines);

    }


    @After
    public void tearDown() {
        log.debug("tearDown() invoked.");
    } // tearDown

}
