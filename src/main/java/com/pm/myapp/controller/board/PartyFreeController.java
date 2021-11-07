package com.pm.myapp.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pm.myapp.service.board.PartyFreeService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/partyfree")
@Controller
public class PartyFreeController {
	
	@Setter(onMethod_= {@Autowired})
	private PartyFreeService service;

	// 파티 자유 게시판 목록
	@GetMapping("/getPFreeBoardList")
	public void getPFreeBoardList() {
		log.debug("getPFreeBoardList() invoked.");
		
	} // getPFreeBoardList
	
	// 파티 자유 게시판  검색
	@GetMapping("/searchPFreeBoard")
	public void searchPFreeBoard() {
		log.debug("searchPFreeBoard() invoked.");
		
	} // searchPFreeBoard
	
	// 파티 자유 게시판  작성
	@PostMapping("/writePFreeBoard")
	public void writePFreeBoard() {
		log.debug("writePFreeBoard() invoked.");

	} // writePFreeBoard
	
	// 파티 자유 게시판  수정
	@PostMapping("/editPFreeBoard")
	public void editPFreeBoard() {
		log.debug("editPFreeBoard() invoked.");

	} // editPFreeBoard
	
	// 파티 자유 게시판  삭제
	@PostMapping("/deletePFreeBoard")
	public void deletePFreeBoard() {
		log.debug("deletePFreeBoard() invoked.");

	} // deletePFreeBoard
	
	// 파티 자유 게시판  - 댓글 목록
	@GetMapping("/getComment")
	public void getComment() {
		log.debug("getComment() invoked.");
		
	} // commentList
	
	// 파티 자유 게시판  - 댓글 작성
	@PostMapping("/writeComment")
	public void writeComment() {
		log.debug("writeComment() invoked.");

	} // writeComment
	
	// 파티 자유 게시판  - 댓글 수정
	@PostMapping("/editComment")
	public void editComment() {
		log.debug("editComment() invoked.");

	} // editComment
	
	// 파티 자유 게시판  - 댓글 삭제
	@PostMapping("/deleteComment")
	public void deleteComment() {
		log.debug("deleteComment() invoked.");

	} // deleteComment
	
} // end class
