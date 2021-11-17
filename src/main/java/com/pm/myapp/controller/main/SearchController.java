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

    // // 검색 페이지(view)
    // @GetMapping("/searchList")
    // public void showPartyList(Criteria cri, String searchWord, Model model) {
    //     log.debug("showPartyList() invoked.");
    //
    //     int totalAmount;
    //
    //     // Criteria 초기화
    //     if (cri.getAmount() == 0 || cri.getPagesPerPage() == 0) {
    //         cri.setAmount(9);
    //         cri.setPagesPerPage(9);
    //     } // if
    //
    //     log.info("검색어 : {}", searchWord);
    //
    //     // url 로 직접 접근했을 때를 대비
    //     if (searchWord != null) {
    //
    //         model.addAttribute("searchWord", searchWord);
    //
    //         SearchWordDTO dto = new SearchWordDTO();
    //
    //         // LIKE 절을 위한 검색어 가공 처리
    //         dto.setWord("%" + searchWord + "%");
    //
    //         List<PartyVO> list = this.service.getPartyListBySearch(cri, dto);
    //         log.info("\t+ list size: {}", list.size());
    //
    //         model.addAttribute("list", list);
    //         totalAmount = this.service.getTotalCountBySearch(dto);
    //     } else {
    //
    //         List<PartyVO> list = this.service.getPartyList(cri);
    //         log.info("\t+ list size: {}", list.size());
    //
    //         model.addAttribute("list", list);
    //         totalAmount = this.service.getTotalCount();
    //     }
    //
    //     PageDTO pageDTO = new PageDTO(cri, totalAmount);
    //
    //     model.addAttribute("pageMaker", pageDTO);
    // } // showPartyList

    // 카테고리 선택
    @GetMapping("/searchList")
    public String selectCategory(Criteria cri, SearchWordDTO searchWordDTO, Model model) {
        log.info("searchList() invoked.");

        // Criteria 초기화
        if (cri.getAmount() == 0 || cri.getPagesPerPage() == 0) {
            cri.setAmount(9);
            cri.setPagesPerPage(9);
        } // if

        List<PartyVO> list;
        int totalAmount;

        log.info("searchWordDTO : {}", searchWordDTO);


        // 검색어만 입력했을 경우
        if ((searchWordDTO.getHobby() == null || searchWordDTO.getHobby().equals(""))
                && (searchWordDTO.getLocal() == null || searchWordDTO.getLocal().equals(""))
        ) {
            list = this.service.getPartyListBySearch(cri, searchWordDTO);
            totalAmount = this.service.getTotalCountBySearch(searchWordDTO);

        } else {

            if (searchWordDTO.getHobby().contains(",")) {

                int idx = searchWordDTO.getHobby().indexOf(",");
                searchWordDTO.setHobby(searchWordDTO.getHobby().substring(idx + 1));
            } // if

            if (searchWordDTO.getLocal().contains(",")) {

                int idx = searchWordDTO.getLocal().indexOf(",");
                searchWordDTO.setLocal(searchWordDTO.getLocal().substring(idx + 1));
            } // if

            log.info("수정된 DTO: {}", searchWordDTO);

            list = this.service.getPartyListBySelected(cri, searchWordDTO);
            totalAmount = this.service.getTotalCountBySelected(searchWordDTO);
        } // if-else

        /*
        // URI 분기
        if (request.getRequestURI().contains("/searchList")) {
            log.debug("searchList() invoked.");
            list = this.service.getPartyListBySearch(cri, searchWordDTO);

            totalAmount = this.service.getTotalCountBySearch(searchWordDTO);

        } else {
            log.debug("selectCategory() invoked.");
            list = this.service.getPartyListBySelected(cri, searchWordDTO);

            totalAmount = this.service.getTotalCountBySelected(searchWordDTO);
        } // if */

        log.info("list : {}", list);
        log.info("totalAmount: {}", totalAmount);

        PageDTO pageDTO = new PageDTO(cri, totalAmount);

        model.addAttribute("searchWord", searchWordDTO.getWord());
        model.addAttribute("hobby", searchWordDTO.getHobby());
        model.addAttribute("local", searchWordDTO.getLocal());
        model.addAttribute("list", list);
        model.addAttribute("pageMaker", pageDTO);

        return "/search/searchList";

    } // selectCategory

    // 카테고리 검색
    @GetMapping("/getCategory")
    public void getCategory() {
        log.debug("getCategory() invoked.");

    } // getCategory

} // end class
