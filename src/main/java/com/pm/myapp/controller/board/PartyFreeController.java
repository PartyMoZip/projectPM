package com.pm.myapp.controller.board;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PageDTO;
import com.pm.myapp.domain.ReplyCriteria;
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
            @ModelAttribute("sdto") BoardSearchListDTO sdto,
			@ModelAttribute("cri") Criteria cri,
			Model model) {
		Integer partyCode = sdto.getPartyCode();
        String searchWord = sdto.getSearchWord();
        Integer option = sdto.getOption();

        // 처음으로 조회할 시에는 option 값이 함께 들어올 수 없음. 따라서 기본으로 1로 들어가는 것이 필요
        if(option == null || option == 0) {
            option = 1;
        } // if

		log.debug("getPFreeBoardList({}) invoked.", sdto);

        // 목록 불러오기
		List<PartyFreeListVO> list = this.service.getListPerPage(partyCode, searchWord, option, cri);

		log.info("\t + list size : {}", list.size());
		model.addAttribute("list", list);

		// 페이징 처리
		Integer totalAmount = this.service.getTotal(partyCode,searchWord, option);
		PageDTO pageDTO = new PageDTO(cri, totalAmount);
		model.addAttribute("pageMaker", pageDTO);
		
		// 파티 코드 강제 주입
		model.addAttribute("partyCode", partyCode);

		return "/partyFree/boardList";
		
	} // getPFreeBoardList

	// 파티 자유 게시판 상세보기
	@GetMapping("/showPartyFDetail")
	public String showPartyFDetail(
            @ModelAttribute("sdto") BoardSearchListDTO sdto,
			@ModelAttribute("cri") Criteria cri,
            @ModelAttribute("recri") ReplyCriteria recri,
            Integer pfrefer,
            Model model)

		{
		log.debug("get({}, {}, {}) invoked.", cri, pfrefer,  sdto);


        // 게시판 조회수 증가\
        boolean readOk = this.service.readPFreeBoard(pfrefer, sdto.getPartyCode());
        if(readOk) {
            log.info("파티 자유 게시판 {}글 읽기 성공", pfrefer);
        }

        // 파티 자유 게시판 글 상세보기
		PartyFreeVO partyFDetail = this.service.getBoardDetail(pfrefer, sdto.getPartyCode());
		log.info("\t + partyFree : {}", partyFDetail);
		List<PartyFreeReplyVO> reply = this.service.getReply(pfrefer, sdto.getPartyCode(), recri);
		model.addAttribute("boardDetail", partyFDetail);
		model.addAttribute("__COMMENT__", reply);


        // 댓글 총 개수 구하기
        Integer totalAmount = this.service.getTotalReply(pfrefer);

        // 댓글 페이지네이션 처리
        PageDTO pageDTO = new PageDTO(recri, totalAmount);
        model.addAttribute("replyPageMaker", pageDTO);

        
        return "/partyFree/boardDetail";
	} // showPartyFDetail

	// 파티 자유 게시판 글쓰기 완료
	@PostMapping("/writePFreeBoardOk")
	public String writePFreeBoard(PartyFreeDTO partyFB, @ModelAttribute("cri") Criteria cri,RedirectAttributes rttrs) {
		log.debug("writePFreeBoard({}) invoked.", partyFB);
        // 글 내용 업로드
        boolean result = this.service.writeFBoard(partyFB);
        log.info("\t+ result : {}", result);
        
		rttrs.addAttribute("partyCode",partyFB.getPartyCode());
		rttrs.addAttribute("currPage",cri.getCurrPage());
		
		return "redirect:/partyfree/getPFreeBoardList";

	} // writePFreeBoard

    // 파치 자유 게시판 글 쓰기 화면
    @GetMapping("/writePFreeBoardView")
    public String writePFBoardView(@ModelAttribute("cri") Criteria cri, @ModelAttribute("partyCode") Integer partyCode) {
        log.debug("writePFBoardView() invoked.");

        return "/partyFree/boardWrite";
    }

	// 파티 자유 게시판 수정 View
	@GetMapping("/editPFBoardView")
	public String editPFBoardView(@ModelAttribute("cri") Criteria cri, Integer pfrefer, @ModelAttribute("partyCode") Integer partyCode, Model model) {
		log.debug("editPFBoardView({}, {})", cri, pfrefer, partyCode);

		PartyFreeVO boardDetail = this.service.getBoardDetail(pfrefer, partyCode);
		log.info("\t + boardDetail : {}", boardDetail);

		model.addAttribute("__boardDetail__", boardDetail);
		return "/partyFree/boardModify";
	} // editPFBoardView

	// 파티 자유 게시판  수정
	@PostMapping("/editPFreeBoard")
	public String editPFreeBoard(PartyFreeDTO partyFree, RedirectAttributes rttrs) {
		log.debug("editPFreeBoard({}) invoked.", partyFree);
		this.service.editBoard(partyFree);


		return "redirect:/partyFree/getPFreeBoardList";

	} // editPFreeBoard

	// 파티 자유 게시판  삭제
	@PostMapping("/deletePFreeBoard")
	public String deletePFreeBoard(
            @RequestParam("pfrefer")Integer pfrefer,
            @RequestParam("partyCode") Integer partyCode,
            @ModelAttribute("cri") Criteria cri,
            RedirectAttributes rttrs) {

		log.debug("deletePFreeBoard({}) invoked.", pfrefer);

		boolean result = this.service.deleteBoard(pfrefer, partyCode);
		rttrs.addAttribute("result", result);

		return "redirect:/partyFree/getPFreeBoardList";
	} // deletePFreeBoard

	// 파티 자유 게시판  검색
	@GetMapping("/searchPFreeBoard")
	public String searchPFreeBoard(@ModelAttribute("cri") Criteria cri, @RequestParam("partyCode")Integer partyCode, String searchWord, Integer option, Model model) {

		log.debug("searchPFreeBoard() invoked.");

		List<PartyFreeSearchVO> searchList = this.service.search(partyCode, cri, searchWord, option);
		model.addAttribute("__list__", searchList);

		// 페이징 처리
		Integer totalAmount = this.service.getTotalSearch(partyCode, searchWord, option);
		PageDTO pageDTO = new PageDTO(cri, totalAmount);
		model.addAttribute("pageMaker", pageDTO);

        return "redirect:/partyFree/getPFreeBoardList";
	} // searchPFreeBoard

	// 파티 자유 게시판  - 댓글 작성
	@PostMapping("/writeComment")
	public String writeComment(
            @ModelAttribute("pfrefer") Integer pfrefer,
            PartyFreeReplyDTO partyReply,
            @ModelAttribute("cri") Criteria cri,
            @ModelAttribute("recri") ReplyCriteria recri,
            RedirectAttributes rttrs) {
		log.debug("writeComment({}, {}) invoked.",pfrefer, partyReply);

		boolean result = this.service.writeReply(partyReply);
        rttrs.addAttribute("pfrefer", pfrefer);
        rttrs.addAttribute("currPage", cri.getCurrPage());
        rttrs.addAttribute("reCurrPage",recri.getReCurrPage());

		return "redirect:/partyFree/showPartyFDetail";
	} // writeComment
	
	// 파티 자유 게시판  - 댓글 수정
	@PostMapping("/editComment")
	public String editComment(
            PartyFreeReplyDTO dto,
            @ModelAttribute("cri") Criteria cri,
            @ModelAttribute("recri") ReplyCriteria recri,
            RedirectAttributes rttrs) {
		log.debug("editComment({}, {}, {}) invoked.", cri, recri, dto);

		boolean result = this.service.editReply(dto);
		rttrs.addAttribute("pfrefer", dto.getPfrefer());
        rttrs.addAttribute("partyCode", dto.getPartyCode());
        rttrs.addAttribute("currPage", cri.getCurrPage());
        rttrs.addAttribute("reCurrPage",recri.getReCurrPage());



        return "redirect:/partyFree/boardDetail";
	} // editComment
	
	// 파티 자유 게시판  - 댓글 삭제
	@PostMapping("/deleteComment")
	public String deleteComment(
            PartyFreeReplyDTO dto,
            @ModelAttribute("cri") Criteria cri,
            @ModelAttribute("recri") ReplyCriteria recri,
            RedirectAttributes rttrs) {
		log.debug("deleteComment({},{},{}) invoked.", dto, cri, recri);

		boolean result = this.service.deleteReply(dto);
        log.info("\t+ result : {}", result);

        rttrs.addAttribute("pfrefer", dto.getPfrefer());
        rttrs.addAttribute("partyCode", dto.getPartyCode());
        rttrs.addAttribute("currPage", cri.getCurrPage());
        rttrs.addAttribute("reCurrPage",recri.getReCurrPage());

		return "redirect:/partyFree/boardDetail";
	} // deleteComment
	
} // end class
