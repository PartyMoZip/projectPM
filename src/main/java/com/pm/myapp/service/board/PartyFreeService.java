package com.pm.myapp.service.board;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.board.*;

import java.util.List;

public interface PartyFreeService {

    // 파티 자유 게시판 목록 - 페이징 처리
    public abstract List<PartyFreeListVO> getListPerPage(Criteria criteria);

    // 파티 자유 게시판 상세보기
    public abstract PartyFreeVO getBoardDetail(Integer  pfrefer, Integer partycode);

    // 파티 자유 게시판 글쓰기
    public abstract boolean writeFBoard(PartyFreeDTO partyFree);

    // 파티 자유 게시판 글수정
    public abstract boolean editBoard(PartyFreeDTO partyFree);

    // 파티 자유 게시판 글삭제
    public abstract boolean deleteBoard(Integer pfrefer);

    // 파티 자유 게시판 검색
   public abstract List<PartyFreeSearchVO> search(String searchOption, String keyword, Criteria cri);

    // 파티 자유 게시판 총 개수 반환
    public abstract Integer getTotal();

    // 9. 댓글 목록
    public abstract List<PartyFreeReplyVO> getReply(Integer pfrefer, Integer partycode, Criteria cri);

    // 10. 댓글 등록
    public abstract boolean writeReply(PartyFreeReplyDTO pfreeReply);

    // 11. 댓글 수정
    public abstract boolean editReply(PartyFreeReplyDTO partyReply);

    // 12. 댓글 삭제
    public abstract boolean deleteReply(Integer pfrefer);

    // 13. 총 댓글 개수
    public abstract Integer getTotalReply();

} //end interface
