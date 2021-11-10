package com.pm.myapp.service.main;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.mapper.SearchMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@AllArgsConstructor

@Service
public class SearchServiceImpl implements SearchService {

    private SearchMapper mapper;

    @Override
    public List<PartyVO> getPartyList(Criteria cri) {
        log.debug("getPartyList() invoked.");

        return this.mapper.getPartyList(cri);
    } // getPartyList

    @Override
    public List<PartyVO> getPartyListBySearch(
            @Param("cri") Criteria cri,
            @Param("searchWord1") String searchWord1,
            @Param("searchWord2") String searchWord2,
            @Param("searchWord3") String searchWord3
    ) {
        log.debug("getPartyList() invoked.");

        return this.mapper.getPartyListBySearch(cri, searchWord1, searchWord2, searchWord3);
    } // getPartyListBySearch

    @Override
    public Integer getTotalCount() {
        log.debug("getTotalCount() invoked.");

        return this.mapper.getTotalCount();
    } // getTotalCount

    @Override
    public Integer getTotalCountBySearch(String searchWord1, String searchWord2, String searchWord3) {
        log.debug("getTotalCount() invoked.");

        return this.mapper.getTotalCountBySearch(searchWord1, searchWord2, searchWord3);
    } // getTotalCountBySearch
}
