package com.pm.myapp.mapper.board;

import com.pm.myapp.domain.*;
import com.pm.myapp.domain.board.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PartyPhotoMapper {

    // 1. 게시판 목록 조회 //
	
	// 게시판 글 가져오기
    public abstract List<PartyPhotoDTO> getList(@Param("partyCode") Integer partyCode, @Param("cri") Criteria cri);
    // 글 총 개수 구하기
    public abstract Integer getTotalList(Integer partyCode);

    // 2. 게시글 상세 조회 //
    
    // 게시글 상세 가져오기
    public abstract PartyPhotoDTO getDetail(@Param("prefer") Integer prefer, @Param("partyCode") Integer partyCode);
    // 게시글 사진 가져오기
    public abstract List<String> getPhoto(@Param("prefer") Integer prefer, @Param("partyCode") Integer partyCode);
    // 게시글 댓글 가져오기
    public abstract List<PartyPhotoReDTO> getReplyList(@Param("prefer") Integer prefer, @Param("partyCode") Integer partyCode, @Param("recri") ReplyCriteria recri);
    // 게시글 댓글 총 개수 구하기
    public abstract Integer getTotalReply(@Param("prefer") Integer prefer, @Param("partyCode") Integer partyCode);

    
    // 2. 새로운 게시물 등록
    public abstract Integer insert (PartyPhotoVO partyPhoto);

    // 2. 자동 생성된 게시글 번호 얻기
    public abstract Integer insertSelectKey(PartyPhotoDTO partyPhoto);



    //4. 게시물 수정
    public abstract int update(PartyPhotoDTO partyPhoto);

    //5. 게시물 삭제
    public abstract int remove(Integer prefer);

    // 7. 댓글 목록
    public abstract List<FreeBoardReplyVO> getListReply();

    // 8. 댓글 등록
    public abstract Integer insert(FreeBoardReplyVO freeReply);

    // 9. 댓글 수정
    public abstract  int update(FreeBoardReplyDTO freeReply);

    // 10. 댓글 삭제
    public abstract int delete(Integer mfrrefer);

    // 11. 댓글 개수
    public abstract Integer getTotalReply();

    // 12. 댓글 번호 생성
    public abstract Integer insertRefer(FreeBoardReplyDTO freeReply);



}
