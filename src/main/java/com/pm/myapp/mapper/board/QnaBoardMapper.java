package com.pm.myapp.mapper.board;

import com.pm.myapp.domain.*;
import com.pm.myapp.domain.board.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QnaBoardMapper {

    // 1. 게시판 목록 조회 //
    // 문의 게시판 목록 - 페이징 처리
    public abstract List<QnaBoardListVO> getListWithPaging(@Param("searchWord") String searchWord, @Param("option") Integer option, @Param("cri") Criteria cri);
    // 총 게시물 개수
    public abstract Integer getTotalCount(@Param("searchWord") String searchWord, @Param("option") Integer option);

    // 2. 게시판 상세 조회 //
    // 게시글 조회수 증가
    public abstract Integer readIt(@Param("qrefer") Integer qrefer);
    // 문의 게시물 상세보기
    public abstract QnaBoardVO readQnaBoard(Integer qrefer);
    // 문의 게시판 댓글 목록
    public abstract List<QnaBoardReplyVO> getCommentListPaging(@Param("qrefer") Integer qrefer, @Param("recri") ReplyCriteria recri);
    // 문의 게시판 댓글 등록
    public abstract Integer writeComment(QnaBoardReplyDTO qnaReply);
    // 문의 게시판 댓글 수정
    public abstract int editComment(QnaBoardReplyDTO qnaReply);
    // 문의 게시판 총 댓글 개수
    public  abstract Integer getTotalQnaReply(Integer qrefer);

    // 3. 검색
    // 문의 게시판 검색 게시물 개수
    public abstract Integer getTotalSearchCount(@Param("searchWord") String searchWord, @Param("option") Integer option);
    // 문의 게시물 검색
    public abstract List<QnaBoardSearchVO> searchQnaBoard(@Param("searchOption") String searchOption, @Param("keyword")String keyword, @Param("cri")Criteria cri);


    // 문의 게시물 글쓰기
    public abstract Integer writeQnaBoard(QnaBoardDTO qnaBoard);

    // 문의 게시판 수정
    public abstract int editQnaBoard(QnaBoardDTO qnaBoard);

    // 문의 게시판 삭제
    public abstract int deleteQnaBoard(Integer qrefer);
    // 문의 게시판 댓글 삭제
    public abstract int deleteComment(Integer qrerefer);





}
