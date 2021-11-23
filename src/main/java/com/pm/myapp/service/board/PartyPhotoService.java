package com.pm.myapp.service.board;

import java.util.List;
import java.util.Map;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.ReplyCriteria;
import com.pm.myapp.domain.board.HeartDTO;
import com.pm.myapp.domain.board.PartyPhotoDTO;
import com.pm.myapp.domain.board.PartyPhotoReDTO;

public interface PartyPhotoService {
	
	// 1. 포토 갤러리 목록 불러오기
	// 글 목록 불러오기
	public abstract List<PartyPhotoDTO> getPartyPhotoList(
			Integer partyCode, String searchWord, Integer option, Criteria cri);
	// 글 총 개수 구하기
	public abstract Integer getTotalPartyPhotoList(
			Integer partyCode, String searchWord, Integer option);
	
	// 2. 포토 갤러리 상세 보기
	// 조회수 올리기
	public abstract boolean readPhotoBoard(Integer prefer, Integer partyCode);
	// 글 상세 보기
	public abstract PartyPhotoDTO getPhotoBoardDetail(Integer prefer, Integer partyCode);
	// 사진 불러오기
	public abstract List<String> getPhotoAddress(Integer prefer, Integer partyCode);
	// 댓글 목록 불러오기
	public abstract List<PartyPhotoReDTO> getPhotoReplyList(Integer prefer, Integer partyCode, ReplyCriteria recri);
	// 댓글 총 개수 구하기
	public abstract Integer getTotalPhotoReplyList(Integer prefer, Integer partyCode);
	
	// 3. 포토 갤러리 쓰기
	// 글 내용 등록
	public abstract Integer writePartyPhoto(PartyPhotoDTO dto);
	// 글 사진 등록
	public abstract boolean registerImages(Map<String, Object> imageInfo);
	
    // 4. 게시물 수정 //
	// 글 내용 수정
	public abstract boolean modifyPartyPhoto(PartyPhotoDTO dto);
	// 삭제할 사진 지우기
	public abstract boolean deleteImages(String file);
	
	// 5. 게시물 삭제 //
	// 해당 글 댓글 삭제
	public abstract boolean deletePartyPhotoReply(Integer prefer, Integer partyCode);
	// 글 내용 삭제
	public abstract boolean deletePartyPhoto(Integer prefer, Integer partyCode);

	// 6. 게시물 댓글 작성 //
	public abstract boolean writePhotoBoardComment(PartyPhotoReDTO dto);
	
	// 7. 게시물 댓글 수정 //
	public abstract boolean modifyPhotoBoardComment(PartyPhotoReDTO dto);
	
	// 8. 게시물 댓글 삭제 //
	public abstract boolean deletePhotoBoardComment(PartyPhotoReDTO dto);
	
	// 9. 좋아요 기능 //
	public abstract boolean checkPhotoBoardHeart(HeartDTO hdto);
	
} // end interface
