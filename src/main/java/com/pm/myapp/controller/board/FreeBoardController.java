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
			@ModelAttribute("cri") Criteria cri, Model model) {
		log.debug("getFreeBoardList({}) invoked.", cri);
		List<FreeBoardListVO> list = this.service.getListPerPage(cri);

		log.info("\t + list size : {}", list.size());
		model.addAttribute("list", list);

		// 페이징 처리
		Integer totalAmount = this.service.getTotal();
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

	// 자유 게시판 글쓰기
	@PostMapping("/writeFreeBoard")
	public String writeFreeBoard(FreeBoardDTO writeFB, RedirectAttributes rttrs) {
		log.debug("writeFreeBoard({}) invoked.", writeFB);

		boolean result = this.service.writeBoard(writeFB);
		rttrs.addAttribute("result", result);

		return "redirect:/freeboard/boardWrite";
	} // writeFreeBoard

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
		rttrs.addAttribute("resultmod", result);

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
	public String searchFreeBoard(@ModelAttribute("cri") Criteria cri, String option, String keyword, Model model) {
		log.debug("searchFreeBoard() invoked.");

		List<FreeBoardSearchVO> searchList = this.service.search(option, keyword, cri);
		model.addAttribute("__list__", searchList);

		// 페이징 처리
		Integer totalAmount = this.service.getTotalSearch(option, keyword);
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

		return "getFreeList";
	} // commentList
	
	// 자유 게시판  - 댓글 작성
	@PostMapping("/writeComment")
	public String writeComment(FreeBoardReplyDTO freeReply, RedirectAttributes rttrs) {
		log.debug("writeComment({}) invoked.", freeReply);

		boolean result = this.service.writeReply(freeReply);
		rttrs.addAttribute("resultWriteComment", result);

		return "getFreeList";

	} // writeComment
	
	// 자유 게시판  - 댓글 수정
	@PostMapping("/editComment")
	public String editComment(FreeBoardReplyDTO freeReply, RedirectAttributes rttrs) {
		log.debug("editComment({}) invoked.", freeReply);

		boolean result = this.service.editReply(freeReply);
		rttrs.addAttribute("resultEditComment", result);

		//게시글 상세페이지로 돌아가야되는데 이름 뭔데
		return "getFreeList";

	} // editComment
	
	// 자유 게시판  - 댓글 삭제
	@PostMapping("/deleteComment")
	public String deleteComment(@RequestParam("frerefer") Integer frerefer, RedirectAttributes rttrs) {
		log.debug("deleteComment({}) invoked.", frerefer);

		boolean result = this.service.deleteReply(frerefer);
		rttrs.addAttribute("resultDeleteComment", result);

		return "getFreeList";

	} // deleteComment


	
} // end class
