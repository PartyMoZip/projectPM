package com.pm.myapp.service.board;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.ReplyCriteria;
import com.pm.myapp.domain.board.*;

import java.util.List;

public interface QnaBoardService {

    // 1. 문의 게시판 목록 불러오기 //
    // 문의 게시글 등록 - 페이징 처리
    public abstract  List<QnaBoardListVO> getListPerPage(String searchWord, Integer option, Criteria cri);
    // 총 게시물 개수 반환
    public abstract Integer getTotal(String searchWord, Integer option);

    // 2. 문의 게시판 상세보기 //
    // 문의 게시판 게시물의 상세보기
    public abstract QnaBoardVO getBoardDetail(Integer qrefer);
    // 문의 게시판 댓글 목록
    public abstract List<QnaBoardReplyDTO> getReply(Integer qrefer, ReplyCriteria recri);
    // 문의 게시판 댓글 등록
    public abstract boolean writeReply(QnaBoardReplyDTO QnaReply);
    // 문의 게시판 댓글 수정
    public abstract  boolean editReply(QnaBoardReplyDTO QnaReply);
    // 문의 게시판 댓글 총 개수 구하기
    public abstract Integer getTotalQnaReplyList(Integer qrefer);
    // 문의 게시판 조회수 증가
    public abstract boolean readQnaBoard(Integer qrefer);


    // 3. 문의 게시판 글쓰기
    public abstract boolean writeBoard(QnaBoardDTO qnaBoard);

    // 4. 문의 게시판 글수정
    public abstract void editBoard(QnaBoardDTO qnaBoard);

    // 5. 문의 게시판 삭제 //
    // 문의 게시판 글삭제
    public abstract boolean deleteBoard(Integer qrefer);
    // 문의 게시판 댓글 삭제
    public abstract boolean deleteReply(Integer qrefer);

    // 6. 문의 게시판 검색 //
    // 문의 게시글 검색
    public abstract List<QnaBoardSearchVO> search(String searchWord, Integer option, Criteria cri);
    // 검색 결과 게시물 개수 반환
    public abstract Integer getTotalSearch(String searchWord, Integer option);

} // end interface
