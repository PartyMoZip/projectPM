package com.pm.myapp.mapper.board;

import com.pm.myapp.domain.*;
import com.pm.myapp.domain.board.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PartyPhotoMapper {

    // 1. 게시판 목록 조회 //	
	// 게시판 글 가져오기
    public abstract List<PartyPhotoDTO> getList(
    		@Param("partyCode") Integer partyCode,
    		@Param("searchWord") String searchWord,
    		@Param("option") Integer option,
    		@Param("cri") Criteria cri);
    // 글 총 개수 구하기
    public abstract Integer getTotalList(
    		@Param("partyCode") Integer partyCode,
    		@Param("searchWord") String searchWord,
    		@Param("option") Integer option
    		);

    
    // 2. 게시글 상세 조회 //
    // 게시글 조회수 증가
    public abstract Integer readIt(@Param("prefer") Integer prefer, @Param("partyCode") Integer partyCode);
    // 게시글 상세 가져오기
    public abstract PartyPhotoDTO getDetail(@Param("prefer") Integer prefer, @Param("partyCode") Integer partyCode);
    // 게시글 사진 가져오기
    public abstract List<String> getPhoto(@Param("prefer") Integer prefer, @Param("partyCode") Integer partyCode);
    // 게시글 댓글 가져오기
    public abstract List<PartyPhotoReDTO> getReplyList(@Param("prefer") Integer prefer, @Param("partyCode") Integer partyCode, @Param("recri") ReplyCriteria recri);
    // 게시글 댓글 총 개수 구하기
    public abstract Integer getTotalReply(@Param("prefer") Integer prefer, @Param("partyCode") Integer partyCode);

    
    // 3. 새로운 게시물 등록 //    
    // 게시글 등록 전 파티 별 게시판 최대 글 번호 알아내기
    public abstract Integer checkPrefer(@Param("dto") PartyPhotoDTO dto);
    // 게시글 등록 하기
    public abstract Integer writePhotoBoard(@Param("dto") PartyPhotoDTO dto);
    // 사진 등록 하기
    public abstract Integer registerImage(Map<String, Object> imageInfo);

    
    // 4. 게시물 수정 //
    // 게시글 내용 수정
    public abstract Integer updatePartyPhoto(@Param("dto") PartyPhotoDTO dto);
    // 기존 사진 삭제
    public abstract Integer deletePhoto(String file);
    // 새로운 사진 등록 >> 3. 새로운 게시물 등록의 사진 등록 하기 이용

    
    // 5. 게시물 삭제
    // 게시물의 댓글 삭제
    public abstract Integer deletePhotoReply(@Param("prefer") Integer prefer, @Param("partyCode") Integer partyCode);
    // 게시물 삭제
    public abstract Integer deletePhotoBoard(@Param("prefer") Integer prefer, @Param("partyCode") Integer partyCode);

    
    // 6. 댓글 등록
    // 글 개수 체크
    public abstract Integer checkReply(@Param("dto") PartyPhotoReDTO dto);
    // 시퀀스 마지막 번호 체크
    public abstract Integer checkLastSeq(String last_seq);
    // 시퀀스 만들기 ( 글 개수가 0이라면 )
    public abstract Integer createSeq(String create_seq);
    // 시퀀스 실행
    public abstract Integer getNextVal(String read_seq);
    // 댓글 등록
    public abstract Integer writePartyPhotoReply(@Param("dto") PartyPhotoReDTO dto);

    
    // 7. 댓글 수정
    public abstract Integer updatePhotoBoardReply(@Param("dto") PartyPhotoReDTO dto);

    
    // 8. 댓글 삭제
    public abstract Integer deletePhotoBoardReply(@Param("dto") PartyPhotoReDTO dto);
    
    
    // 9. 좋아요 기능
    // 좋아요 확인
    public abstract Integer checkPhotoHeart(@Param("hdto")HeartDTO hdto);
    // 좋아요 없으면 만들기
    public abstract Integer makeHeart(@Param("hdto")HeartDTO hdto);
    // 좋아요 up
    public abstract Integer upHeart(@Param("hdto")HeartDTO hdto);
    // 좋아요 down
    public abstract Integer downHeart(@Param("hdto")HeartDTO hdto);

} // end interface
