package com.pm.myapp.mapper.board;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.board.NoticeBoardDTO;
import com.pm.myapp.domain.board.NoticeBoardListVO;
import com.pm.myapp.domain.board.NoticeBoardSearchVO;
import com.pm.myapp.domain.board.NoticeBoardVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeBoardMapper {

    // 공지 게시판 목록 - 페이징 처리
    public  abstract List<NoticeBoardListVO> getListWithPaging(Criteria cri);
// public abstract List<NoticeBoardVO> getNoticeBoardList();

    // 공지 게시판 상세보기
    public abstract NoticeBoardVO readNoticeBoard(Integer nrefer);

    // 자유게시판 총 게시물 개수 반환
    public abstract Integer getTotalCount();

    // 공지 게시판 글쓰기
    public abstract Integer writeNoticeBoard(NoticeBoardDTO noticeBoard);

    // 공지 게시판 수정
    public abstract int editNoticeBoard(NoticeBoardDTO noticeBoard);

    // 공지 게시판 검색
    public abstract List<NoticeBoardSearchVO> searchNoticeBoard(@Param("searchOption") String searchOption, @Param("keyword")String keyword, @Param("cri")Criteria cri);

    // 공지 게시판 삭제
    public abstract int deleteNoticeBoard(Integer nrefer);


}