package com.pm.myapp.service;


import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.board.*;
import com.pm.myapp.service.board.QnaBoardService;
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
public class QnaServiceTests {

    @Setter(onMethod_= {@Autowired})
    private QnaBoardService service;

    @Before
    public void setup() {
        log.debug("setup() invoked.");

        assertNotNull(this.service);
        log.info("\t + service : {}",this.service);
    } // setup

    @Test
    public void testRegister() {
        log.debug("testRegister() invoked.");

        QnaBoardDTO dto = new QnaBoardDTO();
        dto.setQsubject("민예원");
        dto.setQcontent("테스트");
        dto.setNickname("yewoni");
        dto.setEmail("test2@test.com");

        boolean affectedLine = this.service.writeBoard(dto);
        log.info("\t + affectedLine : {}", affectedLine);
    }

    @Test
    public void testModify() {
        log.debug("testModify() invoked.");

     /*   QnaBoardVO board = new QnaBoardVO(1, "TEST", "TESTQna", null, "yewoni", "test1@test.com",0);
        Objects.requireNonNull(board);
        log.info("\t + board : {}", board);*/
    }

    @Test
    public void testRemove() {
        log.debug("testRemove() invoked.");

        int qrefer = 1;
        boolean isSuccess = this.service.deleteBoard(qrefer);
        log.info("\t + isSuccess : {}", isSuccess);
    }

    @Test
    public void testGetBoardDetail() {
        log.debug("testGet() invoked.");

        int qrefer = 1;
        QnaBoardVO board = this.service.getBoardDetail(qrefer);

        Objects.requireNonNull(board);
        log.info("\t + board : {}", board);
    }

    @Test
    public void testGetListPerPage() {
        log.debug("testGetListPerPage() invoked.");

        Criteria cri = new Criteria();
        cri.setCurrPage(1);
        cri.setAmount(10);

        List<QnaBoardListVO> boardList = this.service.getListPerPage(cri);

        Objects.requireNonNull(boardList);
        boardList.forEach(log::info);
    }

    @Test
    public void testSearch() {
        log.debug("testSearch() invoked.");

        String searchOption = "q.qsubject";
        String keyword = "%T%";
        Criteria cri = new Criteria();
        List<QnaBoardSearchVO> list = this.service.search(searchOption, keyword, cri);
        list.forEach(log::info);
    }

    @Test
    public void testGetTotal() {
        log.debug("testGetTotal() invoked.");
        int totalCount = this.service.getTotal();
        log.info("\t + totalCount : {}", totalCount);
    }

    @Test
    public void testWriteReply() {
        log.debug("testWriteReply() invoked.");

        QnaBoardReplyVO boardReply = new QnaBoardReplyVO(null, "yewoni", null, null, "test4@test.com");
        log.info("\t + new Comment : {}", boardReply.getQrerefer());
    }

    @Test
    public void testEditReply() {
        log.debug("testEditReply() invoked.");

        QnaBoardReplyVO boardReply = new QnaBoardReplyVO(null, "ming", null, null, "test2@test.com");
    }

    @Test
    public void testGetReplyListPaging() {
        log.debug("testGetReplyListPaging() invoked.");
        Criteria cri = new Criteria();
        cri.setCurrPage(1);
        cri.setAmount(10);
        List<QnaBoardReplyVO> replyList = this.service.getReply(1, cri);
        Objects.requireNonNull(replyList);
        replyList.forEach(log::info);
    }

    @Test
    public void testDeleteReply() {
        log.debug("testDeleteReply() invoked.");
        int qrerefer = 1;
        boolean isSuccess = this.service.deleteReply(qrerefer);
        log.info("\t + isSuccess : {}", isSuccess);
    }

    @Test
    public void testGetTotalReply() {
        log.debug("testGetTotalReply() invoked.");

        int totalCount = this.service.getTotalReply();
        log.info("\t + totalCount : {}", totalCount);
    }

    @After
    public void tearDown() {
        log.debug("tearDown() invoked.");
    } // tearDown

} // end class
