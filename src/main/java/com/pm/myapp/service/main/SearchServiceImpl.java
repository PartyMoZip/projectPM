package com.pm.myapp.service.main;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.domain.SearchWordDTO;
import com.pm.myapp.mapper.SearchMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
            Criteria cri,
            SearchWordDTO searchWord
    ) {
        log.debug("getPartyList() invoked.");

        return this.mapper.getPartyListBySearch(cri, searchWord);
    } // getPartyListBySearch

    @Override
    public List<PartyVO> getPartyListBySelected(SearchWordDTO searchWord) {
        return null;
    }

    @Override
    public Integer getTotalCount() {
        log.debug("getTotalCount() invoked.");

        return this.mapper.getTotalCount();
    } // getTotalCount

    @Override
    public Integer getTotalCountBySearch(SearchWordDTO searchWord) {
        log.debug("getTotalCount() invoked.");

        return this.mapper.getTotalCountBySearch(searchWord);
    } // getTotalCountBySearch
}
