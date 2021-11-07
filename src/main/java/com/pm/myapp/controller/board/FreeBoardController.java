package com.pm.myapp.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pm.myapp.service.board.FreeBoardService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/freeboard")
@Controller
public class FreeBoardController {
	
	@Setter(onMethod_= {@Autowired})
	private FreeBoardService service;

	// 자유 게시판 목록
	@GetMapping("/getFreeBoardList")
	public void getFreeBoardList() {
		log.debug("getFreeBoardList() invoked.");
		
	} // getFreeBoardList
	
	// 자유 게시판  검색
	@GetMapping("/searchFreeBoard")
	public void searchFreeBoard() {
		log.debug("searchFreeBoard() invoked.");
		
	} // searchFreeBoard
	
	// 자유 게시판  작성
	@PostMapping("/writeFreeBoard")
	public void writeFreeBoard() {
		log.debug("writeFreeBoard() invoked.");

	} // writeFreeBoard
	
	// 자유 게시판  수정
	@PostMapping("/editFreeBoard")
	public void editFreeBoard() {
		log.debug("editFreeBoard() invoked.");

	} // editFreeBoard
	
	// 자유 게시판  삭제
	@PostMapping("/deleteFreeBoard")
	public void deleteFreeBoard() {
		log.debug("deleteFreeBoard() invoked.");

	} // deleteFreeBoard
	
	// 자유 게시판  - 댓글 목록
	@GetMapping("/getComment")
	public void getComment() {
		log.debug("getComment() invoked.");
		
	} // commentList
	
	// 자유 게시판  - 댓글 작성
	@PostMapping("/writeComment")
	public void writeComment() {
		log.debug("writeComment() invoked.");

	} // writeComment
	
	// 자유 게시판  - 댓글 수정
	@PostMapping("/editComment")
	public void editComment() {
		log.debug("editComment() invoked.");

	} // editComment
	
	// 자유 게시판  - 댓글 삭제
	@PostMapping("/deleteComment")
	public void deleteComment() {
		log.debug("deleteComment() invoked.");

	} // deleteComment
	
} // end class
