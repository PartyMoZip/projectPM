package com.pm.myapp.controller.main;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PageDTO;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.domain.SearchWordDTO;
import com.pm.myapp.service.main.SearchService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Log4j2
@NoArgsConstructor

@RequestMapping("/search")
@Controller
public class SearchController {

    @Setter(onMethod_ = {@Autowired})
    private SearchService service;

    // 검색 페이지(view)
    @GetMapping("/searchList")
    public void showPartyList(Criteria cri, String searchWord, Model model) {
        log.debug("showPartyList() invoked.");

        int totalAmount;

        // Criteria 초기화
        if (cri.getAmount() == 0 || cri.getPagesPerPage() == 0) {
            cri.setAmount(9);
            cri.setPagesPerPage(9);
        } // if

        log.info("검색어 : {}", searchWord);

        // url 로 직접 접근했을 때를 대비
        if (searchWord != null) {

            model.addAttribute("searchWord", searchWord);

            SearchWordDTO dto = new SearchWordDTO();

            // LIKE 절을 위한 검색어 가공 처리
            dto.setWord("%" + searchWord + "%");

            List<PartyVO> list = this.service.getPartyListBySearch(cri, dto);
            log.info("\t+ list size: {}", list.size());

            model.addAttribute("list", list);
            totalAmount = this.service.getTotalCountBySearch(dto);
        } else {

            List<PartyVO> list = this.service.getPartyList(cri);
            log.info("\t+ list size: {}", list.size());

            model.addAttribute("list", list);
            totalAmount = this.service.getTotalCount();
        }

        PageDTO pageDTO = new PageDTO(cri, totalAmount);

        model.addAttribute("pageMaker", pageDTO);
    } // showPartyList

    // 카테고리 선택
    @GetMapping("/select")
    public void selectCategory(Criteria cri, String title, String hobby, String local, Model model) {
        log.debug("selectCategory() invoked.");

        // Criteria 초기화
        if (cri.getAmount() == 0 || cri.getPagesPerPage() == 0) {
            cri.setAmount(9);
            cri.setPagesPerPage(9);
        } // if

        SearchWordDTO searchWordDTO = new SearchWordDTO();
        searchWordDTO.setWord(title);
        searchWordDTO.setHobby(hobby);
        searchWordDTO.setLocal(local);

        List<PartyVO> list = this.service.getPartyListBySelected(cri, searchWordDTO);
        log.info("searchWordDTO: {}, {}, {}", searchWordDTO.getWord(), searchWordDTO.getHobby(), searchWordDTO.getHobby());

        int totalAmount = this.service.getTotalCountBySearch(searchWordDTO);

        PageDTO pageDTO = new PageDTO(cri, totalAmount);

        model.addAttribute("pageMaker", pageDTO);

    } // selectCategory

    // 카테고리 검색
    @GetMapping("/getCategory")
    public void getCategory() {
        log.debug("getCategory() invoked.");

    } // getCategory

} // end class
