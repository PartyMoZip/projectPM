package com.pm.myapp.mapper;


import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.board.*;
import com.pm.myapp.mapper.board.QnaBoardMapper;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
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
public class QnaMapperTests {

    @Setter(onMethod_=@Autowired)
    private QnaBoardMapper mapper;

    @Before
    public void setup() {
        log.debug("setup() invoked.");

        assert this.mapper != null;
        log.info("\t + mapper : {}", this.mapper);
        log.info("\t + type : {}", this.mapper.getClass().getName());
    } // setup

    @Test
    public void testGetListWithPaging() { // 문의 게시판 목록 - 페이징 처리 - 테스트 완료
        log.debug("testGetListWithPaging() invoked.");
        Criteria cri = new Criteria();
        cri.setAmount(1);
        cri.setAmount(10);

        List<QnaBoardListVO> list = this.mapper.getListWithPaging(cri);
        list.forEach(log::info);

    } // testGetListWithPaging

    @Test
    public void testReadQnaBoard() { // 문의 게시판 상세보기 - 테스트 완료
        log.debug("testReadFreeBoard() invoked.");

        int qrefer = 2;
        QnaBoardVO board = this.mapper.readQnaBoard(qrefer);
        log.info("\t + board : {}", board);
    }

    @Test
    public void testWriteQnaBoard() { // 문의 게시판 등록 - 테스트 완료
        log.debug("testWriteQnaBoard() invoked.");

        QnaBoardDTO dto = new QnaBoardDTO();
        dto.setQsubject("노래방");
        dto.setQcontent("가자가자가자~~~~");
        dto.setEmail("test9@test.com");
        dto.setNickname("노래에미친자");

        int affectedLines = this.mapper.writeQnaBoard(dto);
        log.info("\t + affectedLines : {}", affectedLines);
    } // testWriteQnaBoard

    @Test
    public void testEditQnaBoard() { // 문의 게시판 수정 - 테스트 완료
        log.debug("testEditQnaBoard() invoked.");

        QnaBoardDTO qnaBoard = new QnaBoardDTO();
        qnaBoard.setQrefer(2);
        qnaBoard.setQsubject("플레이리스트 좋네요");
        qnaBoard.setQcontent("이승기 - 삭제");
        qnaBoard.setEmail("test10@test.com");

        int affectedLines = this.mapper.editQnaBoard(qnaBoard);
        log.info("\t + affectedLines : {}", affectedLines);
    }

    @Test
    public void testDeleteQnaBoard() { // 문의 게시판 삭제 - 테스트 완료
        log.debug("testDeleteFreeBoard() invoked.");

        // int frefer = 3;
        int affectedLines=this.mapper.deleteQnaBoard(3);
        log.info("\t + affectedLines : {}", affectedLines);
    }

    @Test
    public void testSearchQnaBoard() { // 문의 게사판 검색 - 테스트 완료
        log.debug("testSearchQnaBoard() invoked.");

        String searchOption= "q.qsubject";
        String keyword="%어%";
        Criteria cri = new Criteria();
        cri.setAmount(10);
        cri.setCurrPage(1);
        cri.setPagesPerPage(10);
        List<QnaBoardSearchVO> list = this.mapper.searchQnaBoard(searchOption, keyword, cri);
        log.info("\t + list : {}", list);
    }

    @Test
    public void testGetTotalCount() { // 문의 게시판 글 개수 - 테스트 완료
       log.debug("testGetTotalCount() invoked.");

        Integer totalCount = this.mapper.getTotalCount();
        log.info("\t + totalCount : {}", totalCount);
    }

    @Test
    public void testGetCommentListPaging() { // 문의 게시판 댓글 목록 - 테스트 완료
        log.debug("testGetComment() invoked.");
        Criteria cri = new Criteria();
        cri.setAmount(1);
        cri.setAmount(10);
        List<QnaBoardReplyVO> list = this.mapper.getCommentListPaging(2, cri);
        list.forEach(log::info);
    }

    @Test
    public void testWriteComment() { // 문의 게시판 댓글 등록 - 테스트 완료
        log.debug("testWriteComment() invoked.");
        QnaBoardReplyDTO dto = new QnaBoardReplyDTO();
        dto.setQrecontent("내일 감쏘간다.");
        dto.setQrefer(4);
        dto.setEmail("test7@test.com");

        int affectedLines = this.mapper.writeComment(dto);
        log.info("\t + affectedLines : {}", affectedLines);
    } // testWriteComment

    @Test
    public void testEditComment() { // 문의 게시판 댓글 수정 - 테스트 완료
       log.debug("testEditComment() invoked.");
        QnaBoardReplyDTO comment = new QnaBoardReplyDTO();
        comment.setQrerefer(11);
        comment.setQrecontent("댓글수정완료 노래방간다.");

        int affectedLines = this.mapper.editComment(comment);
        log.info("\t + affectedLines : {}", affectedLines);
    } // testEditComments

    @Test
    public void testDeleteComment() { // 문의 게시판 댓글 삭제
        log.debug("testDeleteComment() invoked.");

        int affectedLines=this.mapper.deleteComment(13);
        log.info("\t + affectedLines : {}", affectedLines);
    }
}














