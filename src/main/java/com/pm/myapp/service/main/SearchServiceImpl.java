package com.pm.myapp.service.main;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.domain.SearchWordDTO;
import com.pm.myapp.mapper.SearchMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@AllArgsConstructor

@Service
public class SearchServiceImpl implements SearchService {

    @Setter(onMethod_ = @Autowired)
    private SearchMapper mapper;

    @Override
    public List<PartyVO> getPartyList(Criteria cri) {
        log.debug("getPartyList() invoked.");

        return this.mapper.getPartyList(cri);
    } // getPartyList

    @Override
    public List<PartyVO> getContainsWord(SearchWordDTO searchWord) {
        log.debug("Serivce getContainsWord() invoked.");

        return this.mapper.getContainsWord(searchWord);
    }

    @Override
    public List<PartyVO> getPartyListBySearch(
            Criteria cri,
            SearchWordDTO searchWord
    ) {
        log.debug("getPartyListBySearch() invoked.");

        if (searchWord.getWord() != null
                && (searchWord.getHobby() == null || searchWord.getHobby().equals(""))
                && (searchWord.getLocal() == null || searchWord.getLocal().equals(""))
        ) {
            searchWord.setHobby(searchWord.getWord());
            searchWord.setLocal(searchWord.getWord());
        }


        List<PartyVO> list = this.mapper.getPartyListBySearch(cri, searchWord);

        return list;
    } // getPartyListBySearch

    @Override
    public List<PartyVO> getPartyListBySelected(Criteria cri, SearchWordDTO searchWord) {
        log.debug("getPartyListBySelected() invoked.");

        List<PartyVO> list = this.mapper.getPartyListBySelected(cri, searchWord);

        return list;
    } // getPartyListBySelected

    @Override
    public Integer getTotalCount() {
        log.debug("getTotalCount() invoked.");

        return this.mapper.getTotalCount();
    } // getTotalCount

    @Override
    public Integer getTotalCountBySearch(SearchWordDTO searchWord) {
        log.debug("getTotalCountBySearch() invoked.");

        Integer result = this.mapper.getTotalCountBySearch(searchWord);

        // searchWord 원상복구
        searchWord.setWord(searchWord.getWord().replace("%", ""));
        searchWord.setHobby(null);
        searchWord.setLocal(null);

        return result;
    } // getTotalCountBySearch

    @Override
    public Integer getTotalCountBySelected(SearchWordDTO searchWord) {
        log.debug("getTotalCountBySelected() invoked.");
        log.info("searchWord: {}", searchWord);
        Integer result = this.mapper.getTotalCountBySelected(searchWord);

        log.info("result: {}", result);

        return result;
    } // getTotalCountBySelected
}
