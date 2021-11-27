package com.pm.myapp.service;


import com.pm.myapp.domain.Criteria;

import com.pm.myapp.domain.board.NoticeBoardDTO;
import com.pm.myapp.domain.board.NoticeBoardListVO;
import com.pm.myapp.domain.board.NoticeBoardSearchVO;
import com.pm.myapp.domain.board.NoticeBoardVO;
import com.pm.myapp.service.board.NoticeBoardService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
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
public class NoticeServiceTests {

    @Setter(onMethod_= {@Autowired})
    private NoticeBoardService service;

    @Before
    public void setup() {
        log.debug("setup() invoked.");

        assertNotNull(this.service);
        log.info("\t + service : {}", this.service);

    } // setup


    @Test
    public void testRegister() {
        log.debug("testRegister() invoked.");
        NoticeBoardDTO dto = new NoticeBoardDTO();
        dto.setNRefer(1);
        dto.setNSubject("김진건멍충이");
        dto.setNContent("진건아....힘내....");
        dto.setEmail("test1@test.com");

        boolean affectedLine = this.service.writeBoard(dto);

        log.info("\t + affectedLine : {}", affectedLine);
    }

    @Test
    public void testModify() {
        log.debug("testModify() invoked.");

        NoticeBoardVO board = new NoticeBoardVO(1, "Test", "Test", null, "yewoni", "yewoni@test.com", null);
        Objects.requireNonNull(board);
        log.info("\t + board : {}", board);
    } // testModify

    @Test
    public void testRemove() {
        log.debug("testRemove() invoked.");

        int nrefer = 1;
        boolean isSuccess = this.service.deleteBoard(nrefer);
        log.info("\t + isSuccess : {}", isSuccess);

    } // testRemove

    @Test
    public void testGet() {
        log.debug("testGet() invoked.");

        int nrefer = 3;
        NoticeBoardVO board = this.service.getBoardDetail(nrefer);

        Objects.requireNonNull(board);
        log.info("\t + board : {}", board);
    }
/*
    @Test
    public void testGetList() {
        log.debug("testGetList() invoked.");

        List<NoticeBoardVO> boardList = this.service.getListPerPage(cri);

        Objects.requireNonNull(boardList);
        boardList.forEach(log::info);

    }*/

    @Test
    public void testGetListPerPage() {
        log.debug("testGetListPerPage() invoked.");

        Criteria cri = new Criteria();
        cri.setCurrPage(1);
        cri.setAmount(10);

//        List<NoticeBoardListVO> boardList = this.service.getListPerPage(cri);
//
//        Objects.requireNonNull(boardList);
//        boardList.forEach(log::info);

    } // testGetListPerPage

    @Test
    public void testSearch() {
        log.debug("testSearch() invoked.");

        String searchOption= "f.fsubject";
        String keyword="%T%";
        Criteria cri = new Criteria();
       // List<NoticeBoardSearchVO> list = this.service.search(searchOption, keyword, cri);
        //list.forEach(log::info);

    }

    @Test
    public void testGetTotal() {
        log.debug("testGetTotal() invoked.");

//        int totalCount = this.service.getTotal();
//
//        log.info("\t + totalCount : {}", totalCount);
    }

}
