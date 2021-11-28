package com.pm.myapp.controller.main;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.domain.SearchWordDTO;
import com.pm.myapp.service.main.SearchService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Log4j2
@NoArgsConstructor

@RequestMapping("/search")
@RestController
public class SearchRestController {

    @Setter(onMethod_ = @Autowired)
    private SearchService service;

    // 검색어 자동완성
    @PostMapping(
            value = "/{word}",
            produces = "application/text; charset=utf8" // 설정하지 않으면 한글이 깨짐
    )
    public String getContainsWord(
            @RequestBody String json
    ) {
        log.debug("getContainsWord() invoked.");
        log.info("json: {}", json);

        // JSON 데이터 변환 Gson
        Gson gson = new Gson();
        SearchWordDTO searchWord = new SearchWordDTO();

        // JSON -> String
        JsonElement element = JsonParser.parseString(json);
        String word = element.getAsJsonObject().get("word").getAsString();

        searchWord.setWord(word);

        List<PartyVO> list = this.service.getContainsWord(searchWord);
        list.forEach(log::info);

        // list -> JSON 변환
        String serializeString = gson.toJson(list);
        log.info("serializeString: {}", serializeString);

        return serializeString;
    } // getContainsWord

} // end class
