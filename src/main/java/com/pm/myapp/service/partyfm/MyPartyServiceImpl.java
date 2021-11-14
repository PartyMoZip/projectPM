package com.pm.myapp.service.partyfm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.myapp.domain.MyPartyVO;
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

} // end class
