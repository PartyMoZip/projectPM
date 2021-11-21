package com.pm.myapp.service.board;

import java.util.List;
import java.util.Map;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.ReplyCriteria;
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
	
} // end interface
