package com.pm.myapp.service.board;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.board.*;

import java.util.List;

public interface QnaBoardService {

    // 문의 게시글 등록 - 페이징 처리
    public abstract  List<QnaBoardListVO> getListPerPage(Criteria cri);

    // 문의 게시판 게시물의 상세보기
    public abstract QnaBoardVO getBoardDetail(Integer qrefer);

    // 문의 게시판 글쓰기
    public abstract boolean writeBoard(QnaBoardDTO qnaBoard);

    // 문의 게시판 글수정
    public abstract boolean editBoard(QnaBoardDTO qnaBoard);

    // 문의 게시판 글삭제
    public abstract boolean deleteBoard(Integer qrefer);

    // 문의 게시글 검색
    public abstract List<QnaBoardSearchVO> search(String searchOption, String keyword, Criteria cri);

    // 총 게시물 개수 반환
    public abstract Integer getTotal();

    // 9. 댓글 등록
    public abstract boolean writeReply(QnaBoardReplyDTO QnaReply);

    // 10. 댓글 수정
    public abstract  boolean editReply(QnaBoardReplyDTO QnaReply);

    // 11. 댓글 목록
    public abstract List<QnaBoardReplyVO> getReply(Integer qrefer,Criteria cri);

    // 12. 댓글 삭제
    public abstract boolean deleteReply(Integer qrerefer);

    // 13. 댓글 개수
    public abstract Integer getTotalReply();

} // end interface
