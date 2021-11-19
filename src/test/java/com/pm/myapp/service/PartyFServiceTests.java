package com.pm.myapp.service;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.domain.board.*;
import com.pm.myapp.service.board.PartyFreeService;
import com.pm.myapp.service.partyfm.MyPartyService;
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
public class PartyFServiceTests {

    @Setter(onMethod_= @Autowired)
    private PartyFreeService service;

    @Before
    public void setup() {
        log.debug("setup() invoked.");

        assertNotNull(this.service);
        log.info("\t + service : {}", this.service);
    } // setup

    @Test
    public void testRegister() {
        log.debug("testRegister() invoked.");

        PartyFreeDTO dto = new PartyFreeDTO();
        dto.setPfrefer(null);
        dto.setPfsubject("TEST");
        dto.setPfcontent("TEST");
        dto.setPfdate(null);
        dto.setPartycode(null);


        boolean affectedLine = this.service.writeFBoard(dto);

        log.info("\t + affectedLine : {}", affectedLine);
    } // testRegister

    @Test
    public void testModify() {
        log.debug("test() invoked.");

        PartyFreeDTO partyFree = new PartyFreeDTO();
        Objects.requireNonNull(partyFree);
        log.info("\t + partyFree : {}", partyFree);
    } // testModify

    @Test
    public void testRemove() {
        log.debug("test() invoked.");

        int pfrefer = 1;
        boolean isSuccess = this.service.deleteBoard(pfrefer);
        log.info("\t + isSuccess : {}", isSuccess);
    } //testRemove

    @Test
    public void testGetBoardDetail() {
        log.debug("test() invoked.");

        int pfrefer = 1;
        int partycode =2;
        PartyFreeVO partyFree = this.service.getBoardDetail(pfrefer, partycode);

        Objects.requireNonNull(partyFree);
        log.info("\t + partyFree : {}", partyFree);
    }

    @Test
    public void testSearch() {
        log.debug("test() invoked.");

        String searchOption= "pf.pfsubject";
        String keyword="%T%";
        Criteria cri = new Criteria();
        List<PartyFreeSearchVO> list = this.service.search(searchOption, keyword, cri);
        list.forEach(log::info);
    }

    @Test
    public void testGetTotal() {
        log.debug("test() invoked.");
        int totalCount = this.service.getTotal();
        log.info("\t + totalCount : {}", totalCount);
    }

    // 댓글 목록
    @Test
    public void testGetReplyListPaging() {
        log.debug("testGetReply() invoked.");
        Criteria cri = new Criteria();
        cri.setCurrPage(1);
        cri.setAmount(10);
        List<PartyFreeReplyVO> partyReplyList = this.service.getReply(1,2,cri);
        Objects.requireNonNull(partyReplyList);
        partyReplyList.forEach(log::info);
    }

    @Test
    public void testWriteReply() {
        log.debug("testWriteReply() invoked.");
        PartyFreeReplyVO partyReply = new PartyFreeReplyVO(1, "yeoni", "TEST", null, 1);
        log.info("\t + pfcontent : {}", partyReply.getPfrerefer());
    }

    @Test
    public void testDeleteReply() {
        log.debug("test() invoked.");

        int pfrerefer = 1;
        boolean isSuccess = this.service.deleteReply(pfrerefer);
        log.info("\t + isSuccess : {}", isSuccess);
    }

    @Test
    public void testEditReply() {
        log.debug("test() invoked.");

        PartyFreeReplyVO partyReply = new PartyFreeReplyVO(1, "예워니", "TEST", null, 1);
        Objects.requireNonNull(partyReply);
        log.info("\t + partyReply : {}", partyReply);
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


}


