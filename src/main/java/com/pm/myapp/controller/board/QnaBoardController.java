package com.pm.myapp.controller.board;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PageDTO;
import com.pm.myapp.domain.board.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pm.myapp.service.board.QnaBoardService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Log4j2
@NoArgsConstructor

@RequestMapping("/qnaboard")
@Controller
public class QnaBoardController {
	
	@Setter(onMethod_= {@Autowired})
	private QnaBoardService service;

	// 문의 게시판 목록 - 페이징 처리
	@GetMapping("/getQuestionBoardList")
	public String getQuestionBoardList(
			@ModelAttribute("cri") Criteria cri, Model model) {
		log.debug("getQuestionBoardList({}) invoked.", cri);
		List<QnaBoardListVO> list = this.service.getListPerPage(cri);
		log.info("\t + list size : {}", list.size());
		model.addAttribute("list", list);

		// 페이징 처리
		Integer totalAmount = this.service.getTotal();
		PageDTO pageDTO = new PageDTO(cri, totalAmount);
		model.addAttribute("pageMaker", pageDTO);

		return "/qnaboard/boardList";

	} // getQuestionBoardList

	// 문의 게시판 상세보기
	@GetMapping("/showQnaDetail")
	public void showQnaDetail(@ModelAttribute("cri") Criteria cri, Integer qrefer, Model model) {
		log.debug("showQnaDetail({}, {}) invoked.", cri, qrefer);

		QnaBoardVO boardDetail = this.service.getBoardDetail(qrefer);
		log.info("\t + board : {}", boardDetail);
		List<QnaBoardReplyVO> reply = this.service.getReply(qrefer, cri);
		model.addAttribute("reply", reply);
		model.addAttribute("board", boardDetail);

	} // showQnaDetail

	// 문의 게시판  작성
	@PostMapping("/writeQuestionBoard")
	public String writeQuestionBoard(QnaBoardDTO writeQB, RedirectAttributes rttrs) {
		log.debug("writeQuestionBoard() invoked.", writeQB);
		boolean result = this.service.writeBoard(writeQB);
		rttrs.addAttribute("result", result);

		return "redirect:/Qna/register";

	} // writeQuestionBoard

	// 문의 게시판 수정 view
	@GetMapping("/editQnaBoardView")
	public void editQnaBoardView(@ModelAttribute("cri") Criteria cri, Integer qrefer, Model model) {
		log.debug("editQnaBoardView({}, {}) invoked.", cri, qrefer);

		QnaBoardVO boardDetail = this.service.getBoardDetail(qrefer);
		log.info("\t + boardDetail : {}", boardDetail);

		model.addAttribute("__boardDetail__", boardDetail);

	} // editQnaBoardView

	// 문의 게시판  수정
	@PostMapping("/editQnaBoard")
	public String editQnaBoard(QnaBoardDTO QnaBoard, RedirectAttributes rttrs) {
		log.debug("editQnaBoard({}) invoked.", QnaBoard);
		boolean result = this.service.editBoard(QnaBoard);
		rttrs.addAttribute("resultmod", result);

		return "redirect:/Qna/modify";

	} // editQuestionBoard

	// 문의 게시판  삭제
	@PostMapping("/deleteQnaBoard")
	public String deleteQnaBoard(@RequestParam("qrefer") Integer qrefer, RedirectAttributes rttrs) {
		log.debug("deleteQuestionBoard({}) invoked.", qrefer);
		boolean result = this.service.deleteBoard(qrefer);
		rttrs.addAttribute("resultdel", result);

		return "redirect:/Qna/list";

	} // deleteQuestionBoard

	// 문의 게시판  검색
	@GetMapping("/searchQuestionBoard")
	public void searchQuestionBoard(@ModelAttribute("cri") Criteria cri, String option, String keyword, Model model) {
		log.debug("searchQuestionBoard() invoked.");

		List<QnaBoardSearchVO> searchList = this.service.search(option, keyword, cri);
		model.addAttribute("__list__", searchList);

		// 페이징 처리
		Integer totalAmount = this.service.getTotalSearch(option, keyword);
		PageDTO pageDTO = new PageDTO(cri, totalAmount);
		model.addAttribute("pageMaker", pageDTO);

	} // searchQuestionBoard

	// 문의 게시판  - 댓글 목록
	@GetMapping("/getComment")
	public void getComment(Model model, Integer qrefer, Criteria cri) {
		log.debug("getComment() invoked.");
		List<QnaBoardReplyVO> list = this.service.getReply(qrefer, cri);

		log.info("\t + list size : {}", list.size());
		model.addAttribute("list", list);
		
	} // commentList
	
	// 문의 게시판  - 댓글 작성
	@PostMapping("/writeComment")
	public String writeComment(QnaBoardReplyDTO qnaReply, RedirectAttributes rttrs) {
		log.debug("writeComment({}) invoked.", qnaReply);

		boolean result = this.service.writeReply(qnaReply);
		rttrs.addAttribute("resultWriteComm", result);

		return "redirect:/Qna/showDetail";

	} // writeComment
	
	// 문의 게시판  - 댓글 수정
	@PostMapping("/editComment")
	public String editComment(QnaBoardReplyDTO qnaReply, RedirectAttributes rttrs) {
		log.debug("editComment({}) invoked.", qnaReply);

		boolean result = this.service.editReply(qnaReply);
		rttrs.addAttribute("resultEdit", result);

		return "redirect:/Qna/showDetail";

	} // editComment
	
	// 문의 게시판  - 댓글 삭제
	@PostMapping("/deleteComment")
	public String deleteComment(@RequestParam("qrerefer") Integer qrerefer, RedirectAttributes rttrs) {
		log.debug("deleteComment({}) invoked.", qrerefer);

		boolean result = this.service.deleteReply(qrerefer);
		rttrs.addAttribute("resultDelete",result);

		return "redirect:/Qna/showDetail";

	} // deleteComment
	
} // end class
