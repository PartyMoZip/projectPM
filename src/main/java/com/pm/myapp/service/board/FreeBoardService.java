package com.pm.myapp.service.board;

import com.pm.myapp.domain.*;
import com.pm.myapp.domain.board.*;

import java.util.List;
import java.util.Map;

public interface FreeBoardService {

    // 1. 자유 게시판 목록 불러오기 //
    // 자유 게시판 목록 - 페이징 처리
    public abstract  List<FreeBoardListVO> getListPerPage(String searchWord, Integer option, Criteria cri);
    // 총 게시물 개수 반환
    public abstract Integer getTotal(String searchWord, Integer option);

    // 2. 자유 게시판 상세보기 //
    // 자유 게시판 상세보기
    public abstract FreeBoardVO getBoardDetail(Integer frefer);
    // 자유 게시판 댓글 목록
    public abstract List<FreeBoardReplyDTO> getReply(Integer frefer, ReplyCriteria recri);
    // 자유 게시판 댓글 등록
    public abstract boolean writeReply(FreeBoardReplyDTO freeReply);
    // 자유 게시판 댓글 수정
    public abstract boolean editReply(FreeBoardReplyDTO freeReply);
    // 자유 게시판 댓글 총 개수 구하기
    public abstract Integer getTotalFreeReplyList(Integer frefer);
    // 자유 게시판 조회수 증가
    public abstract boolean readFreeBoard(Integer frefer);


    // 3. 자유 게시판 등록 //
    // 자유 게시판 글쓰기
    public abstract boolean writeBoard(FreeBoardDTO writeFB);

    // 4. 자유 게시판 수정 //
    // 자유 게시판 글수정
    public abstract boolean editBoard(FreeBoardDTO freeBoard);

    // 5. 자유 게시판 삭제 //
    // 자유 게시판 글 삭제
    public abstract boolean deleteBoard(Integer frefer);
    // 자유 게시판 댓글 삭제
    public abstract boolean deleteFreeBoardReply(Integer frefer);

    // 6. 자유 게시판 검색 //
    // 자유 게시판 검색
    public abstract List<FreeBoardSearchVO> search(String searchWord, Integer option, Criteria cri);
    // 검색 결과 게시물 개수 반환
    public abstract Integer getTotalSearch(String searchWord, Integer option);

}//end interface
