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
		log.info("\t+ affectedLine : {}", affectedLine);
		
		return newRefer;
		
	} // writePartyPhoto

	@Override
	public boolean registerImages(Map<String, Object> imageInfo) {
		log.debug("registerImages({}) invoked.",imageInfo);
		
		Integer affectedLine = this.mapper.registerImage(imageInfo);
		log.info("\t+ affectedLine : {}", affectedLine);
		
		return (affectedLine==1);
		
	} // registerImages

	@Override
	public boolean modifyPartyPhoto(PartyPhotoDTO dto) {
		log.debug("modifyPartyPhoto({}) invoked.",dto);
		
		Integer affectedLine = this.mapper.updatePartyPhoto(dto);
		log.info("\t+ affectedLine : {}", affectedLine);
		
		return (affectedLine==1);
		
	} // modifyPartyPhoto

	@Override
	public boolean deleteImages(String file) {
		log.debug("deleteImages({}) invoked.",file);
		
		Integer affectedLine = this.mapper.deletePhoto(file);
		log.info("\t+ affectedLine : {}", affectedLine);
		
		return (affectedLine==1);
		
	} // deleteImages

	@Override
	public boolean deletePartyPhotoReply(Integer prefer, Integer partyCode) {
		log.debug("deletePartyPhotoReply({},{}) invoked.",prefer,partyCode);
		
		Integer affectedLine = this.mapper.deletePhotoReply(prefer,partyCode);
		log.info("\t+ affectedLine : {}", affectedLine);
		
		return (affectedLine!=0);
		
	} // deletePartyPhotoReply

	@Override
	public boolean deletePartyPhoto(Integer prefer, Integer partyCode) {
		log.debug("deletePartyPhoto({},{}) invoked.",prefer,partyCode);
		
		Integer affectedLine = this.mapper.deletePhotoBoard(prefer,partyCode);
		log.info("\t+ affectedLine : {}", affectedLine);
		
		return (affectedLine==1);
		
	} // deletePartyPhoto

	@Override
	public boolean writePhotoBoardComment(PartyPhotoReDTO dto) {
		log.debug("writePhotoBoardComment({}) invoked.",dto);
		
		Integer writeNumber = this.mapper.checkReply(dto);
		log.info("\t+ writeNumber : {}", writeNumber);
		
		int prefer = dto.getPrefer();
		int partyCode = dto.getPartyCode();
		
		if(writeNumber==0) {
			
			String create_seq = "create sequence SEQ_PARTYPHOTORE"  + "_" + partyCode + "_" + prefer + " START WITH 1 INCREMENT BY 1 Nocache";
			this.mapper.createSeq(create_seq);
			
		} // if
		
		String read_seq = "SELECT SEQ_PARTYPHOTORE"  + "_" + partyCode + "_" + prefer + "." + "NEXTVAL " + "FROM DUAL";
		Integer seqNum = this.mapper.getMaxPrerefer(read_seq);
		
		dto.setPrerefer(seqNum);
		
		Integer affectedLine = this.mapper.writePartyPhotoReply(dto);
		log.info("\t+ affectedLine : {}", affectedLine);
		
		return (affectedLine==1);
		
	} // writePhotoBoardComment

	@Override
	public boolean modifyPhotoBoardComment(PartyPhotoReDTO dto) {
		log.debug("modifyPhotoBoardComment({}) invoked.",dto);
		
		Integer affectedLine = this.mapper.updatePhotoBoardReply(dto);
		log.info("\t+ affectedLine : {}", affectedLine);
		
		return (affectedLine==1);
		
	} // modifyPhotoBoardComment

	@Override
	public boolean deletePhotoBoardComment(PartyPhotoReDTO dto) {
		log.debug("deletePhotoBoardComment({}) invoked.",dto);
		
		Integer affectedLine = this.mapper.deletePhotoBoardReply(dto);
		log.info("\t+ affectedLine : {}", affectedLine);
		
		return (affectedLine==1);
	} // deletePhotoBoardComment

	
	
} // end class
