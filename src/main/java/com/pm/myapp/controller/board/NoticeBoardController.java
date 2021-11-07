package com.pm.myapp.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pm.myapp.service.board.NoticeBoardService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/noticeboard")
@Controller
public class NoticeBoardController {

	@Setter(onMethod_ = { @Autowired })
	private NoticeBoardService service;

	// 공지 게시판 목록
	@GetMapping("/getNoticeBoardList")
	public void getNoticeBoardList() {
		log.debug("getNoticeBoardList() invoked.");

	} // getNoticeBoardList

	// 공지 게시판 검색
	@GetMapping("/searchNoticeBoard")
	public void searchNoticeBoard() {
		log.debug("searchNoticeBoard() invoked.");

	} // searchNoticeBoard

	// 공지 게시판 작성
	@PostMapping("/writeNoticeBoard")
	public void writeNoticeBoard() {
		log.debug("writeNoticeBoard() invoked.");

	} // writeNoticeBoard

	// 공지 게시판 수정
	@PostMapping("/editNoticeBoard")
	public void editNoticeBoard() {
		log.debug("editNoticeBoard() invoked.");

	} // editNoticeBoard

	// 공지 게시판 삭제
	@PostMapping("/deleteNoticeBoard")
	public void deleteNoticeBoard() {
		log.debug("deleteNoticeBoard() invoked.");

	} // deleteNoticeBoard

} // end class
