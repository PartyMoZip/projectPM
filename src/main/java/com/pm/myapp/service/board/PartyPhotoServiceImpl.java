package com.pm.myapp.service.board;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.ReplyCriteria;
import com.pm.myapp.domain.board.PartyPhotoDTO;
import com.pm.myapp.domain.board.PartyPhotoReDTO;
import com.pm.myapp.mapper.board.PartyPhotoMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@Service
public class PartyPhotoServiceImpl implements PartyPhotoService {
	
	@Setter(onMethod_= {@Autowired})
	private PartyPhotoMapper mapper;
	
	@Override
	public List<PartyPhotoDTO> getPartyPhotoList(
			Integer partyCode, String searchWord, Integer option, Criteria cri) {
		log.debug("getPartyPhotoList({}, {}, {}, {}) invoked.",partyCode, searchWord, option, cri);
		
		List<PartyPhotoDTO> list = this.mapper.getList(partyCode, searchWord, option, cri);
		log.info("\t+ list : {}",list);
		
		return list;
		
	} // getPartyPhotoList

	@Override
	public Integer getTotalPartyPhotoList(
			Integer partyCode, String searchWord, Integer option) {
		log.debug("getTotalPartyPhotoList({}, {}, {}) invoked.",partyCode, searchWord, option);
		
		Integer result = this.mapper.getTotalList(partyCode, searchWord, option);
		log.info("\t+ result : {}",result);
		
		return result;
		
	} // getTotalPartyPhotoList

	@Override
	public PartyPhotoDTO getPhotoBoardDetail(Integer prefer, Integer partyCode) {
		log.debug("getPhotoBoardDetail({}, {}) invoked.",prefer,partyCode);
		
		PartyPhotoDTO dto = this.mapper.getDetail(prefer, partyCode);
		log.info("\t+ dto : {}",dto);
		
		return dto;
		
	} // getPhotoBoardDetail

	@Override
	public List<String> getPhotoAddress(Integer prefer, Integer partyCode) {
		log.debug("getPhotoAddress({}, {}) invoked.",prefer,partyCode);
		
		List<String> list = this.mapper.getPhoto(prefer, partyCode);
		log.info("\t+ list : {}",list);
		
		return list;
	} // getPhotoAddress

	@Override
	public List<PartyPhotoReDTO> getPhotoReplyList(Integer prefer, Integer partyCode, ReplyCriteria recri) {
		log.debug("getPhotoReplyList({}, {}, {}) invoked.",prefer,partyCode,recri);
		
		List<PartyPhotoReDTO> dto = this.mapper.getReplyList(prefer, partyCode, recri);
		log.info("\t+ dto : {}",dto);
		
		return dto;
	} // getPhotoReplyList

	@Override
	public Integer getTotalPhotoReplyList(Integer prefer, Integer partyCode) {
		log.debug("getTotalPhotoReplyList({}, {}) invoked.",prefer,partyCode);
		
		Integer totalNum = this.mapper.getTotalReply(prefer, partyCode);
		log.info("\t+ totalNum : {}",totalNum);
		
		return totalNum;
	} // getTotalPhotoReplyList

	@Override
	public Integer writePartyPhoto(PartyPhotoDTO dto) {
		log.debug("writePartyPhoto({}) invoked.",dto);
		
		// 파티별 게시판 최대 MaxRefer 찾기
		Integer refer = this.mapper.maxRefer(dto);
		Integer newRefer = refer + 1;
		dto.setPrefer(newRefer);
		
		// 게시글 등록
		Integer affectedLine = this.mapper.writePhotoBoard(dto);

		return newRefer;
	} // writePartyPhoto

	@Override
	public boolean registerImages(Map<String, Object> imageInfo) {
		log.debug("registerImages({}) invoked.",imageInfo);
		
		Integer affectedLine = this.mapper.registerImage(imageInfo);

		return (affectedLine==1);
	} // registerImages

	
	
} // end class
