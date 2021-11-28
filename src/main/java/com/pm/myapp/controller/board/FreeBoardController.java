package com.pm.myapp.controller.board;

import com.pm.myapp.domain.*;
import com.pm.myapp.domain.board.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pm.myapp.service.board.FreeBoardService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Log4j2
@NoArgsConstructor

@RequestMapping("/freeboard")
@Controller
public class FreeBoardController {
	
	@Setter(onMethod_= {@Autowired})
	private FreeBoardService service;

	// 자유 게시판 목록 - 페이징 처리
	@GetMapping("/getFreeBoardList")
	public String getFreeBoardList(
            @ModelAttribute("sdto") BoardSearchListDTO sdto,
			@ModelAttribute("cri") Criteria cri, Model model) {
        String searchWord = sdto.getSearchWord();
        Integer option = sdto.getOption();

        // 처음으로 조회할 시에는 option 값이 함께 들어올 수 없음. 따라서 기본으로 1로 들어가는 것이 필요
        if(option == null || option == 0) {
            option = 1;
        } // if
		log.debug("getFreeBoardList({}) invoked.", cri);
		List<FreeBoardListVO> list = this.service.getListPerPage(searchWord, option, cri);

		log.info("\t + list size : {}", list.size());
		model.addAttribute("list", list);

		// 페이징 처리
		Integer totalAmount = this.service.getTotal(searchWord, option);
		PageDTO pageDTO = new PageDTO(cri, totalAmount);
		model.addAttribute("pageMaker", pageDTO);

		return "/freeboard/boardList";
		
	} // getFreeBoardList

	// 자유 게시판 상세보기
	@GetMapping("/showFreeDetail")
	public void showFreeDetail(@ModelAttribute("cri") Criteria cri, Integer frefer, Model model) {
		log.debug("showFreeDetail({}, {}) invoked.", cri, frefer);

		FreeBoardVO boardDetail = this.service.getBoardDetail(frefer);
		log.info("\t + board : {}", boardDetail);
		List<FreeBoardReplyVO> reply = this.service.getReply(frefer, cri);
        model.addAttribute("boardDetail", boardDetail);
        model.addAttribute("reply", reply);

	} // showFreeDetail

	// 자유 게시판 글쓰기 완료
	@PostMapping("/writeFreeBoardOk")
	public String writeFreeBoard(FreeBoardDTO writeFB, RedirectAttributes rttrs) {
		log.debug("writeFreeBoard({}) invoked.", writeFB);
		boolean result = this.service.writeBoard(writeFB);
		rttrs.addAttribute("result", result);

		return "redirect:/freeboard/boardList";
	} // writeFreeBoard

    // 자유 게시판 글 쓰기 화면
    @GetMapping("/writeFreeBoardView")
    public String writeFreeBoardView(@ModelAttribute("cri") Criteria cri) {
        log.debug("writeFreeBoardView() invoked.");

        return "/freeboard/boardWrite";
    }

	// 자유 게시판 수정 view
	@GetMapping("/editFreeBoardView")
	public String editFreeBoardView(@ModelAttribute("cri") Criteria cri, Integer frefer, Model model){
		log.debug("editFreeBoardView({}, {}) invoked",cri,frefer);

		FreeBoardVO boardDetail = this.service.getBoardDetail(frefer);
		log.info("\t + board : {}", boardDetail);
		model.addAttribute("__boardDetail__",boardDetail);

		return "/freeboard/boardModify";
	} // editFreeBoardView

	// 자유 게시판 수정
	@PostMapping("/editFreeBoard")
	public String editFreeBoard(FreeBoardDTO freeBoard, RedirectAttributes rttrs) {
		log.debug("editFreeBoard({}) invoked.", freeBoard);

		boolean result = this.service.editBoard(freeBoard);
		rttrs.addAttribute("result", result);

		return "redirect:/freeboard/showFreeDetail";

	} // editFreeBoard

	// 자유 게시판 삭제
	@PostMapping("/deleteFreeBoard")
	public String deleteFreeBoard(@RequestParam("frefer") Integer frefer, RedirectAttributes rttrs) {
		log.debug("deleteFreeBoard({}) invoked.", frefer);
		boolean result = this.service.deleteBoard(frefer);
		rttrs.addAttribute("result", result);

		return "redirect:/freeboard/boardList";

	} // deleteFreeBoard

	// 자유 게시판 검색
	@GetMapping("/searchFreeBoard")
	public String searchFreeBoard(@ModelAttribute("cri") Criteria cri, String searchWord, Integer option, Model model) {
		log.debug("searchFreeBoard() invoked.");

		List<FreeBoardSearchVO> searchList = this.service.search(searchWord,option, cri);
		model.addAttribute("__list__", searchList);

		// 페이징 처리
		Integer totalAmount = this.service.getTotalSearch(searchWord, option);
		PageDTO pageDTO = new PageDTO(cri, totalAmount);
		model.addAttribute("pageMaker", pageDTO);

		return "/freeboard/searchList";
	} // searchFreeBoard
	
	// 자유 게시판  - 댓글 목록
	@GetMapping("/getComment")
	public String getComment(Model model, Integer frefer, Criteria cri) {
		log.debug("getComment() invoked.");
		List<FreeBoardReplyVO> list = this.service.getReply(frefer, cri);

		log.info("\t + list size : {}", list.size());
		model.addAttribute("list", list);

        return "redirect:/freeboard/showFreeDetail";
	} // commentList
	
	// 자유 게시판  - 댓글 작성
	@PostMapping("/writeComment")
	public String writeComment(FreeBoardReplyDTO freeReply, RedirectAttributes rttrs) {
		log.debug("writeComment({}) invoked.", freeReply);

		boolean result = this.service.writeReply(freeReply);
		rttrs.addAttribute("resultWriteComment", result);

        return "redirect:/freeboard/showFreeDetail";
	} // writeComment
	
	// 자유 게시판  - 댓글 수정
	@PostMapping("/editComment")
	public String editComment(FreeBoardReplyDTO freeReply, RedirectAttributes rttrs) {
		log.debug("editComment({}) invoked.", freeReply);

		boolean result = this.service.editReply(freeReply);
		rttrs.addAttribute("resultEditComment", result);


        return "redirect:/freeboard/showFreeDetail";
	} // editComment
	
	// 자유 게시판  - 댓글 삭제
	@PostMapping("/deleteComment")
	public String deleteComment(@RequestParam("frerefer") Integer frerefer, RedirectAttributes rttrs) {
		log.debug("deleteComment({}) invoked.", frerefer);

		boolean result = this.service.deleteReply(frerefer);
		rttrs.addAttribute("resultDeleteComment", result);

        return "redirect:/freeboard/showFreeDetail";
	} // deleteComment


	
} // end class
