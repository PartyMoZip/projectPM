package com.pm.myapp.controller.board;


import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.board.NoticeBoardDTO;
import com.pm.myapp.domain.board.NoticeBoardListVO;
import com.pm.myapp.domain.board.NoticeBoardSearchVO;
import com.pm.myapp.domain.board.NoticeBoardVO;
import com.pm.myapp.domain.PageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pm.myapp.service.board.NoticeBoardService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Log4j2
@NoArgsConstructor

@RequestMapping("/noticeboard")
@Controller
public class NoticeBoardController {

    @Setter(onMethod_ = { @Autowired })
    private NoticeBoardService service;

    // 공지 게시판 목록 - 페이징 처리
    @GetMapping("/getNoticeBoardList")
    public String getNoticeBoardList(
            @ModelAttribute("searchWord") String searchWord,
            @ModelAttribute("option") Integer option,
            @ModelAttribute("cri") Criteria cri, Model model) {
        log.debug("getNoticeBoardList({}) invoked.", cri);
        List<NoticeBoardListVO> list = this.service.getListPerPage(searchWord, option, cri);

        log.info("\t + list size : {}", list.size());
        model.addAttribute("list", list);

        // 페이징 처리
        Integer totalAmount = this.service.getTotal(searchWord, option);
        PageDTO pageDTO = new PageDTO(cri, totalAmount);
        model.addAttribute("pageMaker", pageDTO);

        return "/noticeboard/boardList";

    } // getNoticeBoardList

    // 게시판 상세보기
    @GetMapping("/showNoticeDetail")
    public void showNoticeDetail(@ModelAttribute("cri")Criteria cri, Integer nrefer, Model model) {
        log.debug("get({}, {}) invoked.", cri, nrefer);

        NoticeBoardVO board = this.service.getBoardDetail(nrefer);
        log.info("\t + board : {}", board);

        model.addAttribute("board", board);

    }

    // 공지 게시판 글쓰기 완료
    @PostMapping("/writeNoticeBoardOk")
    public String writeNoticeBoard(NoticeBoardDTO noticeBoard, RedirectAttributes rttrs) {
        log.debug("writeNoticeBoard({}) invoked.", noticeBoard);
        boolean result = this.service.writeBoard(noticeBoard);
        rttrs.addAttribute("resultRegister", result);

        return "redirect:/noticeboard/getNoticeBoardList";

    } // writeNoticeBoard

    // 공지 게시판 글 쓰기 화면
    @GetMapping("/writeNoticeBoardView")
    public String writeNoticeBoardView(@ModelAttribute("cri") Criteria cri) {
        log.debug("writeNoticeBoardView() invoked.");

        return "/noticeboard/boardWrite";
    } // writeNoticeBoardView


    // 공지 게시판 수정 view
    @GetMapping("/editNoticeBoardView")
    public String editNoticeBoardView(@ModelAttribute("cri") Criteria cri, Integer nrefer, Model model) {
        log.debug("editNoticeBoardView({}, {}) invoked.", cri, nrefer);

        NoticeBoardVO boardDetail = this.service.getBoardDetail(nrefer);
        log.info("\t + boardDetail : {}", boardDetail);
        model.addAttribute("__boardDetail__", boardDetail);

        return "/noticeboard/boardModify";
    } // editNoticeBoardView

    // 공지 게시판 수정
    @PostMapping("/editNoticeBoard")
    public String editNoticeBoard(NoticeBoardDTO noticeBoard/*, RedirectAttributes rttrs*/) {
        log.debug("editNoticeBoard({}) invoked.", noticeBoard);

        /*boolean result =*/
                service.editBoard(noticeBoard);
       /* rttrs.addAttribute("result", result);*/

        return "redirect:/noticeboard/getNoticeBoardList";

    } // editNoticeBoard

    // 공지 게시판 삭제
    @PostMapping("/deleteNoticeBoard")
    public String deleteNoticeBoard(@RequestParam("nrefer") Integer nrefer, RedirectAttributes rttrs) {
        log.debug("deleteNoticeBoard({}) invoked.", nrefer);
        boolean result = this.service.deleteBoard(nrefer);
        rttrs.addAttribute("resultDelete", result);


        return "redirect:/noticeboard/getNoticeBoardList";

    } // deleteNoticeBoard

    // 공지 게시판 검색 결과 화면
    @GetMapping("/searchNoticeBoard")
    public String searchNoticeBoard(@ModelAttribute("cri") Criteria cri, String option, String keyword, Model model) {
        log.debug("searchNoticeBoard() invoked.");

        List<NoticeBoardSearchVO> searchList = this.service.search(option, keyword, cri);
        model.addAttribute("__list__", searchList);

        // 페이징 처리
        Integer totalAmount = this.service.getTotalSearch(option, keyword);
        PageDTO pageDTO = new PageDTO(cri, totalAmount);
        model.addAttribute("pageMaker", pageDTO);

        return "/noticeboard/searchList";
    } // searchNoticeBoard


} // end class
