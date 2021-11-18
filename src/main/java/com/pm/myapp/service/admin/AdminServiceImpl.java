package com.pm.myapp.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.myapp.domain.AllPartyVO;
import com.pm.myapp.domain.BlackMemberVO;
import com.pm.myapp.domain.BlackPartyVO;
import com.pm.myapp.domain.Criteria;
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
	public List<BlackMemberVO> showBlackMember(Criteria cri) {
		log.debug("showBlackMember({}) invoked.",cri);
		
		List<BlackMemberVO> blackMember = this.mapper.getBlackMember(cri);
		log.info("\t+ blackMember : {}", blackMember);
		
		return blackMember;
	} // showBlackMember
	
	@Override
	public Integer getTotalBM() {
		log.debug("getTotalBM({}) invoked.");
		
		int totalNum = this.mapper.getAllBM();
		log.info("\t+ totalnum : {}",totalNum);
		
		return totalNum;
	} // getTotalBM

	@Override
	public List<BlackPartyVO> showBlackParty(Criteria cri) {
		log.debug("showBlackParty({}) invoked.",cri);

		List<BlackPartyVO> blackParty = this.mapper.getBlackParty(cri);
		log.info("\t+ blackParty : {}", blackParty);
		
		return blackParty;
	} // showBlackParty
	
	@Override
	public Integer getTotalBP() {
		log.debug("getTotalBP({}) invoked.");

		int totalNum = this.mapper.getAllBP();
		log.info("\t+ totalnum : {}",totalNum);
		
		return totalNum;
	} // getTotalBP

	@Override
	@Transactional
	public boolean kickUser(String email) {
		log.debug("showBlackParty({}) invoked.",email);
		
		int result1 = this.mapper.deletePartyUser(email);
		int result2 = this.mapper.deleteUserInfo(email);
		
		log.info("\t+ result1 & result2 : {}, {}", result1, result2);
		
		return (result1!=0 && result2==1);
	} // kickUser

	@Override
	@Transactional
	public boolean breakParty(Integer partyCode) {
		log.debug("breakParty({}) invoked.",partyCode);
		
		int result1 = this.mapper.cutPartyUser(partyCode);
		int result2 = this.mapper.deleteParty(partyCode);
		
		log.info("\t+ result1 & result2 : {}, {}", result1, result2);
		
		return (result1!=0 && result2==1);
	} // breakParty

	@Override
	public List<AllPartyVO> getList(Criteria cri) {
		log.debug("getList({}) invoked.",cri);
		
		List<AllPartyVO> partyList = this.mapper.getAllList(cri);
		
		return null;
	} // getList

	@Override
	public Integer getTotalPL() {
		log.debug("getTotalPL({}) invoked.");

		int totalNum = this.mapper.getAllPL();
		log.info("\t+ totalnum : {}",totalNum);
		
		return totalNum;
	} // getTotalPL

} // end class
