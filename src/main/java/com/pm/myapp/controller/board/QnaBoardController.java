package com.pm.myapp.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pm.myapp.service.board.QnaBoardService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@RequestMapping("/qnaboard")
@Controller
public class QnaBoardController {
	
	@Setter(onMethod_= {@Autowired})
	private QnaBoardService service;

	// 문의 게시판 목록
	@GetMapping("/getQuestionBoardList")
	public void getQuestionBoardList() {
		log.debug("getQuestionBoardList() invoked.");
		
	} // getQuestionBoardList
	
	// 문의 게시판  검색
	@GetMapping("/searchQuestionBoard")
	public void searchQuestionBoard() {
		log.debug("searchQuestionBoard() invoked.");
		
	} // searchQuestionBoard
	
	// 문의 게시판  작성
	@PostMapping("/writeQuestionBoard")
	public void writeQuestionBoard() {
		log.debug("writeQuestionBoard() invoked.");

	} // writeQuestionBoard
	
	// 문의 게시판  수정
	@PostMapping("/editQuestionBoard")
	public void editQuestionBoard() {
		log.debug("editQuestionBoard() invoked.");

	} // editQuestionBoard
	
	// 문의 게시판  삭제
	@PostMapping("/deleteQuestionBoard")
	public void deleteQuestionBoard() {
		log.debug("deleteQuestionBoard() invoked.");

	} // deleteQuestionBoard
	
	// 문의 게시판  - 댓글 목록
	@GetMapping("/getComment")
	public void getComment() {
		log.debug("getComment() invoked.");
		
	} // commentList
	
	// 문의 게시판  - 댓글 작성
	@PostMapping("/writeComment")
	public void writeComment() {
		log.debug("writeComment() invoked.");

	} // writeComment
	
	// 문의 게시판  - 댓글 수정
	@PostMapping("/editComment")
	public void editComment() {
		log.debug("editComment() invoked.");

	} // editComment
	
	// 문의 게시판  - 댓글 삭제
	@PostMapping("/deleteComment")
	public void deleteComment() {
		log.debug("deleteComment() invoked.");

	} // deleteComment
	
} // end class
