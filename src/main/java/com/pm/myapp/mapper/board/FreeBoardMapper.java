package com.pm.myapp.mapper.board;

import com.pm.myapp.domain.*;
import com.pm.myapp.domain.board.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FreeBoardMapper {

    // 1. 게시판 목록 조회 //
    // 자유 게시판 목록 - 페이징 처리
    public abstract List<FreeBoardListVO> getListWithPaging(@Param("searchWord") String searchWord, @Param("option") Integer option, @Param("cri") Criteria cri);
    // 자유 게시판 개수
    public abstract Integer getTotalCount(@Param("searchWord") String searchWord, @Param("option") Integer option);


    // 2. 자유 게시판 상세 조회 //
    // 게시글 조회수 증가
    public abstract Integer readIt(@Param("frefer") Integer frefer);
    // 자유 게시판 상세보기
    public abstract FreeBoardVO readFreeBoard(Integer frefer);
    // 자유 게시판 댓글 목록
    public abstract List<FreeBoardReplyDTO> getCommentListPaging(@Param("frefer")Integer frefer, @Param("recri") ReplyCriteria recri);
    // 자유 게시판 댓글 등록
    public abstract Integer writeComment(FreeBoardReplyDTO freeReply);
    // 자유 게시판 댓글 수정
    public abstract  Integer editComment(FreeBoardReplyDTO freeReply);
    // 자유 게시판 총 댓글 개수
    public abstract Integer getTotalFreeReply(Integer frefer);

    // 자유 게시판 검색 게시물 개수
    public abstract Integer getTotalSearchCount(String searchWord, Integer option);
    // 자유 게시물 검색
    public abstract List<FreeBoardSearchVO> searchFreeBoard(@Param("searchWord") String searchOption_mod, @Param("option") String keyword_mod, @Param("cri")Criteria cri);

    // 3. 게시판 글쓰기 //
    // 자유 게시판 글쓰기
    public abstract Integer registerFreeBoard(FreeBoardDTO writeFB);

    // 4. 게시물 수정 //
    // 자유 게시판 수정
    public abstract Integer updateFreeBoard(FreeBoardDTO freeBoard);

    // 5. 게시물 삭제 //
    // 자유 게시판 삭제
    public abstract Integer deleteFreeBoard(Integer frefer);
    // 자유 게시판 댓글 삭제
    public abstract Integer deleteFreeBoardReply(Integer frefer);










}
