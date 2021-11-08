package com.pm.myapp.controller.main;

import com.pm.myapp.service.main.SearchService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Log4j2
@NoArgsConstructor

@RequestMapping("/search")
@Controller
public class SearchController {

    @Setter(onMethod_ = {@Autowired})
    private SearchService service;

    // 검색 페이지(view)
    @GetMapping("")
    public void showPartyList() {
        log.debug("showPartyList() invoked.");

    } // showPartyList

    // 카테고리 선택
    @GetMapping("/selectCategory")
    public void selectCategory() {
        log.debug("selectCategory() invoked.");

    } // selectCategory

    // 카테고리 검색
    @GetMapping("/getCategory")
    public void getCategory() {
        log.debug("getCategory() invoked.");

    } // getCategory

} // end class
