package com.pm.myapp.service.board;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.board.NoticeBoardDTO;
import com.pm.myapp.domain.board.NoticeBoardListVO;
import com.pm.myapp.domain.board.NoticeBoardSearchVO;
import com.pm.myapp.domain.board.NoticeBoardVO;

import java.util.List;

public interface NoticeBoardService {

    // 1. 공지 게시판 목록 불러오기 //
    // 공지 게시판 목록 - 페이징 처리
    public abstract List<NoticeBoardListVO> getListPerPage(String searchWord, Integer option, Criteria cri);
    // 총 게시물 개수 반환
    public abstract Integer getTotal(String searchWord, Integer option);

    // 2. 공지 게시판 상세보기 //
    // 공지 게시판 상세보기
    public abstract NoticeBoardVO getBoardDetail(Integer nrefer);
    // 공지 게시판 조회수 증가
    public abstract boolean readNoticeBoard(Integer nrefer);


    // 공지 게시판 글쓰기
    public abstract boolean writeBoard(NoticeBoardDTO writeNB);

    // 공지 게시판 수정
    public abstract void editBoard(NoticeBoardDTO noticeBoard);

    // 공지 게시글 삭제
    public abstract  boolean deleteBoard(Integer nrefer);

    // 공지 게시판 검색 //
    // 공지 게시판 검색
    public abstract List<NoticeBoardSearchVO> search(String searchWord, Integer option, Criteria cri);
    // 검색 결과 게시물 개수 반환
    public abstract Integer getTotalSearch(String searchWord, Integer option);

} //end interface
