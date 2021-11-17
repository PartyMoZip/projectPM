package com.pm.myapp.service.partyfm;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.MyPartyListVO;
import com.pm.myapp.domain.PartyDTO;
import com.pm.myapp.mapper.MyPartyMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@Service
public class MyPartyServiceImpl implements MyPartyService{
	
	@Setter(onMethod_= {@Autowired})
	private MyPartyMapper mapper;
	
	@Override
	public boolean doQuit(String email, Integer partyCode) {
		log.debug("doQuit({}, {}) invoked.",email, partyCode);
		
		int affectedLines = this.mapper.quitParty(email, partyCode);
		log.info("\t+ affectedLines : {}",affectedLines);
				
		return (affectedLines == 1);
		
	} // doQuit

	@Override
	public MyPartyListVO getPartyList(String email, Criteria cri) {
		log.debug("getPartyList({},{}) invoked.",email,cri);
		
		MyPartyListVO party = this.mapper.getList(email,cri);
		log.info("\t+ party : {}", party);
		
		return party;
	} // getPartyList

	@Override
	public boolean createParty(PartyDTO dto) {
		log.debug("createParty({}) invoked.",dto);
		
		int affectedLines = this.mapper.makeParty(dto);
		
		return (affectedLines == 1);
	} // createParty

	@Override
	public List<MyPartyListVO> getRcParties(Integer[] hobbyCode, Criteria cri) {
		log.debug("getRcParties({}, {}) invoked.", Arrays.toString(hobbyCode),cri);
		
		List<MyPartyListVO> list = this.mapper.getRecParties(hobbyCode,cri);
		
		return list;
	} // getRcParties

	@Override
	public Integer getTotalMPL(String email) {
		log.debug("getTotalMPL({}) invoked.",email);
		
		int totalNum = this.mapper.getTMPL(email);
		log.info("\t+ totalNum : {}", totalNum);
		
		return totalNum;
	} // getTotalMPL

	@Override
	public Integer getTotalRCP(Integer[] hobbyCode) {
		log.debug("getTotalRCP({}) invoked.", Arrays.toString(hobbyCode));
		
		int totalNum = this.mapper.getTRCP(hobbyCode);
		log.info("\t+ totalNum : {}", totalNum);
		
		return totalNum;
	} // getTotalRCP

} // end class
