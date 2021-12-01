package com.pm.myapp.mapper.board;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.ReplyCriteria;
import com.pm.myapp.domain.board.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PartyFreeMapper {

    // 파티 자유 게시판 목록 - 페이징 처리
    public abstract List<PartyFreeListVO> getListWithPaging(@Param("partycode")Integer partycode, @Param("searchWord") String searchWord, @Param("option") Integer option, @Param("cri") Criteria cri);
    // 파티 내 자유 게시판  개수 반환
    public abstract Integer getTotalCount(@Param("partyCode") Integer partyCode, @Param("searchWord") String searchWord, @Param("option") Integer option);

    // 파티 내 자유 게시판 조회수 증가
    public abstract Integer readIt(@Param("pfrefer") Integer pfrefer, @Param("partycode") Integer partycode);
    // 파티 자유 게시판 상세조회
    public abstract PartyFreeVO readPFreeBoard(@Param("pfrefer")Integer pfrefer, @Param("partycode")Integer partycode);
    // 8. 댓글 목록
    public abstract List<PartyFreeReplyVO> getCommentListPaging(@Param("pfrefer")Integer pfrefer, @Param("partycode") Integer partycode, @Param("recri") ReplyCriteria recri);

    // 9. 댓글 등록
    public abstract Integer writeComment(PartyFreeReplyDTO freeReply);

    // 10. 댓글 수정
    public abstract  int editComment(PartyFreeReplyDTO freeReply);

    // 11. 댓글 삭제
    public abstract int deleteComment(PartyFreeReplyDTO pfreeReply);

    // 12. 총 댓글 개수
    public abstract Integer getTotalReply(Integer pfrefer);

    // 파티 자유 게시판 글쓰기
    public abstract Integer writePFreeBoard(PartyFreeDTO partyFree);

    // 파티 자유 게시판 수정
    public abstract int editPFreeBoard(PartyFreeDTO partyFree);

    // 파티 자유 게시판 삭제
    public abstract int deletePFreeBoard(Integer pfrefer, Integer partyCode);

    // 파티 자유 게시물 검색
    public abstract List<PartyFreeSearchVO> searchPartyFree(Integer partyCode, @Param("searchWord") String searchWord, @Param("keyword_mod") Integer keyword_mod, @Param("cri")Criteria cri);
    // 파티 내 자유 게시판 검색 게시물 개수
    public abstract  Integer getTotalSearchCount(Integer partyCode, String option, Integer keyword);






}
