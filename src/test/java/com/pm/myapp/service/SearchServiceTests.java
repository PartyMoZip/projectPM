package com.pm.myapp.service;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.domain.SearchWordDTO;
import com.pm.myapp.service.main.SearchService;
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
@ContextConfiguration(
        locations = {
                "file:src/main/webapp/WEB-INF/spring/root-context.xml",
                "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
        })
public class SearchServiceTests {

    @Setter(onMethod_ = {@Autowired})
    private SearchService service;

    @Before
    public void setup() {
        log.info("setup() invoked.");

        assert this.service != null;
        log.info("\t+ service: {}", this.service);
    } // setup

    // 페이징 파티 목록 조회
    @Test
    public void testGetPartyList() {
        log.info("testGetPartyList() invoked.");

        Criteria cri = new Criteria();
        cri.setCurrPage(1);
        cri.setAmount(9);

        List<PartyVO> list = this.service.getPartyList(cri);
        log.info("list: {}", list);

        assert list != null;

        list.forEach(log::info);
    } // testGetPartyList

    // 페이징 검색어 포함된 파티 목록 조회
    @Test
    public void testGetPartyListBySearch() {
        log.info("testGetPartyListBySearch() invoked.");

        Criteria cri = new Criteria();
        cri.setCurrPage(3);
        cri.setAmount(2);

        SearchWordDTO searchWord = new SearchWordDTO();
        // searchWord.setWord("축구");
        searchWord.setHobby("축구");
        // searchWord.setLocal("강동");

        List<PartyVO> list = this.service.getPartyListBySearch(cri, searchWord);
        log.info("list: {}", list);

        assert list != null;

        list.forEach(log::info);
    } // testGetPartyListBySearch

    // 카테고리 조건의 파티 목록 조회
    @Test
    public void testGetPartyListBySelected() {
        log.info("testGetPartyListBySelected() invoked.");

        Criteria cri = new Criteria();
        cri.setCurrPage(1);
        cri.setAmount(2);

        SearchWordDTO searchWord = new SearchWordDTO();

        searchWord.setWord("축구");
        searchWord.setHobby(null);
        searchWord.setLocal("강남");

        List<PartyVO> list = this.service.getPartyListBySelected(cri, searchWord);
        log.info("list: {}", list);

        assert list != null;

        list.forEach(log::info);

    } // testGetPartyListBySelected

    // 총 파티 목록 개수
    @Test
    public void testGetTotalCount() {
        log.info("testGetTotalCount() invoked.");

        Integer totalCount = this.service.getTotalCount();
        log.info("\t+ totalCount: {}", totalCount);

    } // testGetTotalCount

    // 검색어 포함된 총 파티 목록 개수
    @Test
    public void testGetTotalCountBySearch() {
        log.info("testGetTotalCountBySearch() invoked.");

        SearchWordDTO searchWord = new SearchWordDTO();
        searchWord.setWord("%축구%");

        Integer totalCount = this.service.getTotalCountBySearch(searchWord);
        log.info("\t+ totalCount: {}", totalCount);

    } // testGetTotalCountBySearch


    // 카테고리 조건의 총 파티 목록 개수
    @Test
    public void testGetTotalCountBySelected() {
        log.info("testGetTotalCountBySelected() invoked.");


        SearchWordDTO searchWord = new SearchWordDTO();

        searchWord.setWord("축구");
        searchWord.setHobby("");
        searchWord.setLocal("");

        Integer totalCount = this.service.getTotalCountBySelected(searchWord);
        log.info("\t+ totalCount: {}", totalCount);

    } // testGetTotalCountBySelected

    @After
    public void tearDown() {
        log.info("tearDown() invoked.");
    } // tearDown

} // end class
