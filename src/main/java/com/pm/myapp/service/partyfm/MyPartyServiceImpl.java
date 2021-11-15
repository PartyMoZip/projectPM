package com.pm.myapp.service.partyfm;
import java.util.List;

import org.apache.catalina.tribes.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.myapp.domain.MyPartyVO;
import com.pm.myapp.domain.PartyDTO;
import com.pm.myapp.domain.PartyVO;
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
	public MyPartyVO getPartyList(String email) {
		log.debug("getPartyList({}) invoked.",email);
		
		MyPartyVO party = this.mapper.getList(email);
		return null;
	} // getPartyList

	@Override
	public boolean createParty(PartyDTO dto) {
		log.debug("createParty({}) invoked.",dto);
		
		int affectedLines = this.mapper.makeParty(dto);
		
		return (affectedLines == 1);
	} // createParty

	@Override
	public List<MyPartyVO> getRcParties(Integer[] hobbyCode) {
		log.debug("getRcParties({}) invoked.", Arrays.toString(hobbyCode));
		
		List<MyPartyVO> list = this.mapper.getRecParties(hobbyCode);
		
		return list;
	} // getRcParties

} // end class
