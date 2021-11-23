package com.pm.myapp.service.board;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.board.NoticeBoardDTO;
import com.pm.myapp.domain.board.NoticeBoardListVO;
import com.pm.myapp.domain.board.NoticeBoardSearchVO;
import com.pm.myapp.domain.board.NoticeBoardVO;

import java.util.List;

public interface NoticeBoardService {

    // 공지 게시판 목록 - 페이징 처리
    public abstract List<NoticeBoardListVO> getListPerPage(Criteria criteria);

    // 공지 게시판 상세보기
    public abstract NoticeBoardVO getBoardDetail(Integer nrefer);

    // 공지 게시판 글쓰기
    public abstract boolean writeBoard(NoticeBoardDTO writeNB);

    // 공지 게시판 수정
    public abstract boolean editBoard(NoticeBoardDTO noticeBoard);

    // 공지 게시글 삭제
    public abstract  boolean deleteBoard(Integer nrefer);

    // 공지 게시판 검색
    public abstract List<NoticeBoardSearchVO> search(String searchOption, String keyword, Criteria cri);

    // 8. 총 게시물 개수 반환
    public abstract Integer getTotal();

    // 검색 결과 게시물 개수 반환
    public abstract Integer getTotalSearch(String option, String keyword);

} //end interface
