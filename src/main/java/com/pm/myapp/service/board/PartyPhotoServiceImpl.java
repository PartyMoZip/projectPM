package com.pm.myapp.service.board;
import java.util.List;

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
	public List<PartyPhotoDTO> getPartyPhotoList(Integer partyCode, Criteria cri) {
		log.debug("getPartyPhotoList({}, {}) invoked.",partyCode, cri);
		
		List<PartyPhotoDTO> list = this.mapper.getList(partyCode,cri);
		log.info("\t+ list : {}",list);
		
		return list;
		
	} // getPartyPhotoList

	@Override
	public Integer getTotalPartyPhotoList(Integer partyCode) {
		log.debug("getTotalPartyPhotoList({}) invoked.",partyCode);
		
		Integer result = this.mapper.getTotalList(partyCode);
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
		
		return null;
	}

	
	
} // end class
