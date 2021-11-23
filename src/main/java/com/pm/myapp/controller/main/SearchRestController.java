package com.pm.myapp.controller.main;


import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.domain.SearchWordDTO;
import com.pm.myapp.service.main.SearchService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@Log4j2
@NoArgsConstructor

@RequestMapping("/search")
@RestController
public class SearchRestController {

    @Setter(onMethod_ = @Autowired)
    private Criteria cri;

    @Setter(onMethod_ = @Autowired)
    private SearchService service;

    // 검색어 자동완성
    @GetMapping("/{word}")
    public Map<String, String> getContainsWord(SearchWordDTO searchWord) {
        log.debug("getContainsWord() invoked.");

        log.info("SearchWord: {}", searchWord.getWord());

        // Criteria 초기화
        cri.setAmount(5);

        List<PartyVO> list = this.service.getContainsWord(cri, searchWord);

        list.forEach(log::info);

        return null;
    } // getContainsWord

} // end class
