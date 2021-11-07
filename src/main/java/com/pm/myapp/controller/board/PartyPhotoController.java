package com.pm.myapp.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pm.myapp.service.board.PartyPhotoService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@RequestMapping("/partyphoto")
@Controller
public class PartyPhotoController {
	
	@Setter(onMethod_= {@Autowired})
	private PartyPhotoService service;
	
	// 포토 갤러리 목록
	@GetMapping("/getPhotoBoardList")
	public void getPhotoBoardList() {
		log.debug("getPhotoBoardList() invoked.");
		
	} // getPhotoBoardList
	
	// 포토 갤러리 검색
	@GetMapping("/searchPhotoBoard")
	public void searchPhotoBoard() {
		log.debug("searchPhotoBoard() invoked.");
		
	} // searchPhotoBoard
	
	// 포토 갤러리 작성
	@PostMapping("/writePhotoBoard")
	public void writePhotoBoard() {
		log.debug("writePhotoBoard() invoked.");

	} // writePhotoBoard
	
	// 포토 갤러리 수정
	@PostMapping("/editPhotoBoard")
	public void editPhotoBoard() {
		log.debug("editPhotoBoard() invoked.");

	} // editPhotoBoard
	
	// 포토 갤러리 삭제
	@PostMapping("/deletePhotoBoard")
	public void deletePhotoBoard() {
		log.debug("deletePhotoBoard() invoked.");

	} // deletePhotoBoard
	
	// 포토갤러리 - 댓글 목록
	@GetMapping("/getComment")
	public void getComment() {
		log.debug("getComment() invoked.");
		
	} // getComment
	
	// 포토 갤러리 - 댓글 작성
	@PostMapping("/writeComment")
	public void writeComment() {
		log.debug("writeComment() invoked.");

	} // writeComment
	
	// 포토 갤러리 - 댓글 수정
	@PostMapping("/editComment")
	public void editComment() {
		log.debug("editComment() invoked.");

	} // editComment
	
	// 포토 갤러리 - 댓글 삭제
	@PostMapping("/deleteComment")
	public void deleteComment() {
		log.debug("deleteComment() invoked.");

	} // deleteComment

} // end class
