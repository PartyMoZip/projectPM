package com.pm.myapp.mapper.board;

import com.pm.myapp.domain.*;
import com.pm.myapp.domain.board.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FreeBoardMapper {

    // 자유 게시판 목록 - 페이징 처리
    public abstract List<FreeBoardListVO> getListWithPaging(Criteria cri);
    // public abstract List<FreeBoardVO> getFreeBoardList();

    // 자유 게시판 상세보기
    public abstract FreeBoardVO readFreeBoard(Integer frefer);

    // 자유 게시물 개수
    public abstract Integer getTotalCount();
    
    // 자유 게시판 글쓰기
    public abstract Integer registerFreeBoard(FreeBoardDTO writeFB);

    // 자유 게시판 수정
    public abstract Integer updateFreeBoard(FreeBoardDTO freeBoard);

    // 자유 게시물 검색
    public abstract List<FreeBoardSearchVO> searchFreeBoard(@Param("searchOption") String searchOption, @Param("keyword")String keyword, @Param("cri")Criteria cri);

    // 자유 게시판 삭제
    public abstract int deleteFreeBoard(Integer frefer);

    // 자유 게시판 댓글 목록
    public abstract List<FreeBoardReplyVO> getCommentListPaging(@Param("frefer")Integer frefer, @Param("cri") Criteria cri);

    // 자유 게시판 댓글 등록
    public abstract Integer writeComment(FreeBoardReplyDTO freeReply);

    // 자유 게시판 댓글 수정
    public abstract  int editComment(FreeBoardReplyDTO freeReply);

    // 자유 게시판 댓글 삭제
    public abstract int deleteComment(Integer frerefer);

    // 자유 게시판 총 댓글 개수
    public abstract Integer getTotalReply();







}
