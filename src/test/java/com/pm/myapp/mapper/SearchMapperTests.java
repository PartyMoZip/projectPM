package com.pm.myapp.mapper;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyVO;
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
public class SearchMapperTests {

    @Setter(onMethod_ = {@Autowired})
    private SearchMapper mapper;

    @Before
    public void setup() {
        log.info("setup() invoked.");

        assert this.mapper != null;
        log.info("\t+ mapper: {}", this.mapper);
        log.info("\t+ type: {}", this.mapper.getClass().getName());
    } // setup

    // 페이징 파티 목록 조회
    @Test
    public void testGetPartyList() {
        log.info("testGetPartyList() invoked.");

        Criteria cri = new Criteria();
        cri.setCurrPage(1);
        cri.setAmount(5);

        List<PartyVO> list = this.mapper.getPartyList(cri);
        list.forEach(log::info);
    } // testGetPartyList

    // 페이징 검색어 포함된 파티 목록 조회
    @Test
    public void testGetPartyListBySearch() {
        log.info("testGetPartyListBySearch() invoked.");

        Criteria cri = new Criteria();
        cri.setCurrPage(1);
        cri.setAmount(5);

        String searchWord = "%축구%";

        List<PartyVO> list = this.mapper.getPartyListBySearch(cri, searchWord, searchWord, searchWord);
        list.forEach(log::info);
    } // testGetPartyListBySearch

    // 총 파티 목록 개수
    @Test
    public void testGetTotalCount() {
        log.info("testGetTotalCount() invoked.");

        Integer totalCount = this.mapper.getTotalCount();
        log.info("\t+ totalCount: {}", totalCount);
    } // testGetTotalCount

    // 검색어 포함된 총 파티 목록 개수
    @Test
    public void testGetTotalCountBySearch() {
        log.info("testGetTotalCountBySearch() invoked.");

        String searchWord = "%축구%";

        Integer totalCount = this.mapper.getTotalCountBySearch(searchWord, searchWord, searchWord);
        log.info("\t+ totalCount: {}", totalCount);
    } // testGetTotalCountBySearch

    @After
    public void tearDown() {
        log.info("tearDown() invoked.");

    } // tearDown

} // end class
