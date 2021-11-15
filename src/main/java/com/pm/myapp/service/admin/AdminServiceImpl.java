package com.pm.myapp.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.myapp.domain.BlackMemberVO;
import com.pm.myapp.domain.BlackPartyVO;
import com.pm.myapp.mapper.AdminMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@Service
public class AdminServiceImpl implements AdminService {
	
	@Setter(onMethod_= {@Autowired})
	private AdminMapper mapper;

	@Override
	public List<BlackMemberVO> showBlackMember() {
		log.debug("showBlackMember() invoked.");
		
		List<BlackMemberVO> blackMember = this.mapper.getBlackMember();
		log.info("\t+ blackMember : {}", blackMember);
		
		return blackMember;
	} // showBlackMember

	@Override
	public List<BlackPartyVO> showBlackParty() {
		log.debug("showBlackParty() invoked.");

		List<BlackPartyVO> blackParty = this.mapper.getBlackParty();
		log.info("\t+ blackParty : {}", blackParty);
		
		return blackParty;
	} // showBlackParty

} // end class
