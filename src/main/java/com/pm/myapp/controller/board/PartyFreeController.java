package com.pm.myapp.controller.board;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PageDTO;
import com.pm.myapp.domain.board.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pm.myapp.service.board.PartyFreeService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Log4j2
@NoArgsConstructor

@RequestMapping("/partyfree")
@Controller
public class PartyFreeController {
	
	@Setter(onMethod_= {@Autowired})
	private PartyFreeService service;

	// 파티 자유 게시판 목록 - 페이징 처리
	@GetMapping("/getPFreeBoardList")
	public String getPFreeBoardList(
			@ModelAttribute("cri")Criteria criteria, Model model) {
		log.debug("getPFreeBoardList({}) invoked.", model);
		List<PartyFreeListVO> list = this.service.getListPerPage(criteria);

		log.info("\t + list size : {}", list.size());
		model.addAttribute("list", list);

		// 페이징 처리
		Integer totalAmount = this.service.getTotal();
		PageDTO pageDTO = new PageDTO(criteria, totalAmount);
		model.addAttribute("pageMaker", pageDTO);

		return "/partyFree/boardList";
		
	} // getPFreeBoardList

	// 파티 자유 게시판 상세보기
	@GetMapping("/showPartyFDetail")
	public String showPartyFDetail(@ModelAttribute("cri") Criteria cri, Integer pfrefer, Integer partycode, Model model) {
		log.debug("get({}, {}, {}) invoked.", cri, pfrefer, partycode);
		PartyFreeVO partyFDetail = this.service.getBoardDetail(pfrefer, partycode);
		log.info("\t + partyFree : {}", partyFDetail);
		List<PartyFreeReplyVO> reply = this.service.getReply(pfrefer,partycode, cri);
		model.addAttribute("partyFree", partyFDetail);
		model.addAttribute("reply", reply);

		return "partyFree/boardDetail";
	} // showPartyFDetail

	// 파티 자유 게시판 글쓰기
	@PostMapping("/writePFreeBoard")
	public String writePFreeBoard(PartyFreeDTO partyFB, RedirectAttributes rttrs) {
		log.debug("writePFreeBoard({}) invoked.", partyFB);
		boolean result = this.service.writeFBoard(partyFB);
		rttrs.addAttribute("result", result);

		return "redirect:/partyFree/boardWrite";
	} // writePFreeBoard

	// 파티 자유 게시판 수정 View
	@GetMapping("/editPFBoardView")
	public String editPFBoardView(@ModelAttribute("cri") Criteria cri, Integer pfrefer, Integer partycode, Model model) {
		log.debug("editPFBoardView({}, {})", cri, pfrefer, partycode);

		PartyFreeVO boardDetail = this.service.getBoardDetail(pfrefer, partycode);
		log.info("\t + boardDetail : {}", boardDetail);

		model.addAttribute("__boardDetail__", boardDetail);
		return "/partyFree/boardModify";
	} // editPFBoardView

	// 파티 자유 게시판  수정
	@PostMapping("/editPFreeBoard")
	public String editPFreeBoard(PartyFreeDTO partyFree, RedirectAttributes rttrs) {
		log.debug("editPFreeBoard({}) invoked.", partyFree);
		boolean result = this.service.editBoard(partyFree);
		rttrs.addAttribute("resultmod",result);

		return "redirect:/partyFree/boardDetail";

	} // editPFreeBoard

	// 파티 자유 게시판  삭제
	@PostMapping("/deletePFreeBoard")
	public String deletePFreeBoard(@RequestParam("pfrefer")Integer pfrefer, RedirectAttributes rttrs) {
		log.debug("deletePFreeBoard({}) invoked.", pfrefer);
		boolean result = this.service.deleteBoard(pfrefer);
		rttrs.addAttribute("resultDel", result);

		return "redirect:/partyFree/boardList";
	} // deletePFreeBoard

	// 파티 자유 게시판  검색
	@GetMapping("/searchPFreeBoard")
	public String searchPFreeBoard(@ModelAttribute("cri") Criteria cri, String option, String keyword, Model model) {
		log.debug("searchPFreeBoard() invoked.");

		List<PartyFreeSearchVO> searchList = this.service.search(option, keyword, cri);
		model.addAttribute("__list__", searchList);

		// 페이징 처리
		Integer totalAmount = this.service.getTotalSearch(option, keyword);
		PageDTO pageDTO = new PageDTO(cri, totalAmount);
		model.addAttribute("pageMaker", pageDTO);

		return "/partyFree/searchList";
	} // searchPFreeBoard
	
	// 파티 자유 게시판  - 댓글 목록
	@GetMapping("/getComment")
	public String getComment(Model model, Integer pfrefer, Integer partycode, Criteria cri) {
		log.debug("getComment() invoked.");
		List<PartyFreeReplyVO> list = this.service.getReply(pfrefer, partycode, cri);

		log.info("\t + list size : {}", list.size());
		model.addAttribute("list", list);

		return "redirect:/partyFree/boardDetail";
	} // commentList
	
	// 파티 자유 게시판  - 댓글 작성
	@PostMapping("/writeComment")
	public String writeComment(PartyFreeReplyDTO partyReply, RedirectAttributes rttrs) {
		log.debug("writeComment({}) invoked.", partyReply);

		boolean result = this.service.writeReply(partyReply);
		rttrs.addAttribute("resultWrtieComment", result);

		return "redirect:/partyFree/boardDetail";
	} // writeComment
	
	// 파티 자유 게시판  - 댓글 수정
	@PostMapping("/editComment")
	public String editComment(PartyFreeReplyDTO partyReply, RedirectAttributes rttrs) {
		log.debug("editComment({}) invoked.", partyReply);

		boolean result = this.service.editReply(partyReply);
		rttrs.addAttribute("resultEdit", result);

		return "redirect:/partyFree/boardDetail";
	} // editComment
	
	// 파티 자유 게시판  - 댓글 삭제
	@PostMapping("/deleteComment")
	public String deleteComment(@RequestParam("pfrerefer") Integer pfrerefer, RedirectAttributes rttrs) {
		log.debug("deleteComment({}) invoked.", pfrerefer);

		boolean result = this.service.deleteReply(pfrerefer);
		rttrs.addAttribute("resultDeleteComm", result);

		return "redirect:/partyFree/boardDetail";
	} // deleteComment
	
} // end class
