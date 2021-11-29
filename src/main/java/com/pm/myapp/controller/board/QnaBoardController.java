package com.pm.myapp.controller.board;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PageDTO;
import com.pm.myapp.domain.ReplyCriteria;
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
	@GetMapping("/getQnaBoardList")
	public String getQuestionBoardList(
            @ModelAttribute("sdto") BoardSearchListDTO sdto,
			@ModelAttribute("cri") Criteria cri, Model model) {
        String searchWord = sdto.getSearchWord();
        Integer option = sdto.getOption();

        // 처음으로 조회할 시에는 option 값이 함께 들어올 수 없음. 따라서 기본으로 1로 들어가는 것이 필요
        if(option == null || option == 0) {
            option = 1;
        } // if
		log.debug("getQuestionBoardList({}) invoked.", cri);

        // 목록 불러오기
		List<QnaBoardListVO> list = this.service.getListPerPage(searchWord, option, cri);

		log.info("\t + list size : {}", list.size());
		model.addAttribute("list", list);

		// 페이징 처리
		Integer totalAmount = this.service.getTotal(searchWord, option);
		PageDTO pageDTO = new PageDTO(cri, totalAmount);
		model.addAttribute("pageMaker", pageDTO);

		return "/qnaboard/boardList";

	} // getQuestionBoardList

	// 문의 게시판 상세보기
	@GetMapping("/showQnaDetail")
	public void showQnaDetail(
            @ModelAttribute("sdto") BoardSearchListDTO sdto,
            @ModelAttribute("cri") Criteria cri,
            @ModelAttribute("recri") ReplyCriteria recri,
            Integer qrefer, Model model) {
		log.debug("showQnaDetail({}, {}) invoked.", cri, qrefer);

        // 게시판 조회수 증가
        boolean readOk = this.service.readQnaBoard(qrefer);
        if(readOk) {
            log.info("문의 게시판 {}번 글 읽기 성공", qrefer);
        }

        // 문의 게시판 글 상세보기
		QnaBoardVO boardDetail = this.service.getBoardDetail(qrefer);
		log.info("\t + boardDetail : {}", boardDetail);
        model.addAttribute("boardDetail", boardDetail);

        // 댓글 목록 불러오기
        List<QnaBoardReplyDTO> reply = this.service.getReply(qrefer, recri);
        model.addAttribute("reply", reply);

        // 댓글 총 개수 구하기
        Integer totalAmount = this.service.getTotalQnaReplyList(qrefer);

        // 댓글 페이지네이션
        PageDTO pageDTO = new PageDTO(recri, totalAmount);
        model.addAttribute("replyPageMaker", pageDTO);

	} // showQnaDetail

	// 문의 게시판  글쓰기 완료
	@PostMapping("/writeQnaBoardOk")
	public String writeQuestionBoard(QnaBoardDTO writeQB, RedirectAttributes rttrs) {
		log.debug("writeQuestionBoard() invoked.", writeQB);
		boolean result = this.service.writeBoard(writeQB);
		rttrs.addAttribute("result", result);

		return "redirect:/qnaboard/getQnaBoardList";

	} // writeQuestionBoard

    // 문의 게시판 글 쓰기 화면
    @GetMapping("/writeQnaBoardView")
    public String writeQnaBoardView(@ModelAttribute("cri") Criteria cri) {
        log.debug("writeQnaBoardView() invoked.");

        return "/qnaboard/boardWrite";
    } // writeQnaBoardView

	// 문의 게시판 수정 view
	@GetMapping("/editQnaBoardView")
	public String editQnaBoardView(@ModelAttribute("cri") Criteria cri, Integer qrefer, Model model) {
		log.debug("editQnaBoardView({}, {}) invoked.", cri, qrefer);

		QnaBoardVO boardDetail = this.service.getBoardDetail(qrefer);
		log.info("\t + boardDetail : {}", boardDetail);

		model.addAttribute("__boardDetail__", boardDetail);

        return "/qnaboard/boardModify";

	} // editQnaBoardView

	// 문의 게시판  수정
	@PostMapping("/editQnaBoard")
	public String editQnaBoard(QnaBoardDTO QnaBoard) {
		log.debug("editQnaBoard({}) invoked.", QnaBoard);

		service.editBoard(QnaBoard);


		return "redirect:/qnaboard/getQnaBoardList";

	} // editQuestionBoard

	// 문의 게시판  삭제
	@PostMapping("/deleteQnaBoard")
	public String deleteQnaBoard(@RequestParam("qrefer") Integer qrefer, RedirectAttributes rttrs) {
		log.debug("deleteQuestionBoard({}) invoked.", qrefer);
		boolean result = this.service.deleteBoard(qrefer);
		rttrs.addAttribute("resultdel", result);

		return "redirect:/qnaboard/getQnaBoardList";

	} // deleteQuestionBoard

	// 문의 게시판  검색 결과 화면
	@GetMapping("/searchQnaBoard")
	public String searchQuestionBoard(@ModelAttribute("cri") Criteria cri, String searchWord, Integer option, Model model) {
		log.debug("searchQuestionBoard() invoked.");

		List<QnaBoardSearchVO> searchList = this.service.search(searchWord, option, cri);
		model.addAttribute("__list__", searchList);

		// 페이징 처리
		Integer totalAmount = this.service.getTotalSearch(searchWord, option);
		PageDTO pageDTO = new PageDTO(cri, totalAmount);
		model.addAttribute("pageMaker", pageDTO);

        return "/qnaboard/searchList";

	} // searchQuestionBoard

	// 문의 게시판  - 댓글 작성
	@PostMapping("/writeComment")
	public String writeComment(
            @ModelAttribute("qrefer") Integer qrefer,
            QnaBoardReplyDTO qnaReply,
            @ModelAttribute("cri") Criteria cri,
            @ModelAttribute("recri") ReplyCriteria recri,
            RedirectAttributes rttrs) {
		log.debug("writeComment({},{}) invoked.", qrefer, qnaReply);

		boolean result = this.service.writeReply(qnaReply);
		rttrs.addAttribute("qrefer", qrefer);
        rttrs.addAttribute("currPage", cri.getCurrPage());
        rttrs.addAttribute("reCurrPage", recri.getReCurrPage());

		return "redirect:/qnaboard/showQnaDetail";

	} // writeComment
	
	// 문의 게시판  - 댓글 수정
	@PostMapping("/editComment")
	public String editComment(
            QnaBoardReplyDTO qnaReply,
            @ModelAttribute("cri") Criteria cri,
            @ModelAttribute("recri") ReplyCriteria recri,
            RedirectAttributes rttrs) {
		log.debug("editComment({}) invoked.", qnaReply);

		boolean result = this.service.editReply(qnaReply);
		rttrs.addAttribute("resultEdit", result);
        rttrs.addAttribute("qrefer", qnaReply.getQrefer());
        rttrs.addAttribute("currPage", cri.getCurrPage());
        rttrs.addAttribute("reCurrPage", recri.getReCurrPage());

        return "redirect:/qnaboard/showQnaDetail";
	} // editComment
	
	// 문의 게시판  - 댓글 삭제
	@PostMapping("/deleteComment")
	public String deleteComment(
            @RequestParam("qrerefer") Integer qrerefer,
            @ModelAttribute("cri") Criteria cri,
            @ModelAttribute("recri") ReplyCriteria recri,
            RedirectAttributes rttrs) {
		log.debug("deleteComment({}) invoked.", qrerefer);

		boolean result = this.service.deleteReply(qrerefer);
		rttrs.addAttribute("resultDelete",result);
        rttrs.addAttribute("currPage", cri.getCurrPage());
        rttrs.addAttribute("reCurrPage", recri.getReCurrPage());

        return "redirect:/qnaboard/showQnaDetail";
	} // deleteComment
	
} // end class
