package com.pm.myapp.service.main;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.domain.SearchWordDTO;
import com.pm.myapp.mapper.SearchMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        log.debug("getPartyListBySearch() invoked.");

        String word = "%" + searchWord.getWord() + "%";

        searchWord.setHobby(word);
        searchWord.setLocal(word);
        searchWord.setWord(word);

        List<PartyVO> list = this.mapper.getPartyListBySearch(cri, searchWord);

        return list;
    } // getPartyListBySearch

    @Override
    public List<PartyVO> getPartyListBySelected(Criteria cri, SearchWordDTO searchWord) {
        log.debug("getPartyListBySelected() invoked.");

        if (searchWord.getWord().equals("all") || Objects.equals(searchWord.getWord(), " ")) {
            searchWord.setWord(null);
        }

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

        Integer result = this.mapper.getTotalCountBySelected(searchWord);

        log.info("result: {}", result);
        // if (searchWord.getWord().equals("")) {
        //     searchWord.setWord("전체");
        // }
        // else {
        //     searchWord.setWord(searchWord.getWord().replace("%", ""));
        // }

        if (searchWord.getHobby() != null) {
            searchWord.setWord(searchWord.getHobby());
        }

        return result;
    } // getTotalCountBySelected
}
