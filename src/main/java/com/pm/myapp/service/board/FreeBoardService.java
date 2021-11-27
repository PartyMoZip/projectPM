package com.pm.myapp.service.board;

import com.pm.myapp.domain.*;
import com.pm.myapp.domain.board.*;

import java.util.List;

public interface FreeBoardService {

    // 자유 게시판 목록 - 페이징 처리
    public abstract  List<FreeBoardListVO> getListPerPage(String searchWord, Integer option, Criteria cri);

    // 자유 게시판 상세보기
    public abstract FreeBoardVO getBoardDetail(Integer frefer);

    // 자유 게시판 글쓰기
    public abstract boolean writeBoard(FreeBoardDTO writeFB);

    // 자유 게시판 글수정
    public abstract boolean editBoard(FreeBoardDTO freeBoard);

    // 자유 게시글 글삭제
    public abstract boolean deleteBoard(Integer frefer);

    // 자유 게시판 검색
    public abstract List<FreeBoardSearchVO> search(String searchWord, Integer option, Criteria cri);

    // 총 게시물 개수 반환
    public abstract Integer getTotal(String searchWord, Integer option);

    // 검색 결과 게시물 개수 반환
    public abstract Integer getTotalSearch(String searchWord, Integer option);

    // 9. 댓글 등록
    public abstract boolean writeReply(FreeBoardReplyDTO freeReply);

    // 10. 댓글 수정
    public abstract boolean editReply(FreeBoardReplyDTO freeReply);

    // 11. 댓글 목록
    public abstract List<FreeBoardReplyVO> getReply(Integer frefer, Criteria cri);

    // 12. 댓글 삭제
    public abstract boolean deleteReply(Integer frerefer);

    // 13. 댓글 개수
    public abstract Integer getTotalReply();

}//end interface
