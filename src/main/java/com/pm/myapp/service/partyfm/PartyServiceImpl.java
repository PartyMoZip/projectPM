package com.pm.myapp.service.partyfm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyDTO;
import com.pm.myapp.domain.PartyMemberCheckVO;
import com.pm.myapp.domain.PartyUserVO;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.domain.UserDTO;
import com.pm.myapp.mapper.PartyMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@Service
public class PartyServiceImpl implements PartyService,InitializingBean, DisposableBean {
	
	@Setter(onMethod_= {@Autowired})
	private PartyMapper mapper;
	
	//========================================================
	
	@Override
	public void destroy() throws Exception {
		log.debug("destroy() invoked.");
		
	} // destroy

	@Override
	public void afterPropertiesSet() throws Exception {
		log.debug("afterPropertiesSet() invoked.");
		
		assert this.mapper!=null;
		log.info("\t + mapper : " + this.mapper);
		
	} // afterPropertiesSet
	
	//===========================================================================
	
	
	@Override
	public List<PartyMemberCheckVO> checkPartyMember(String email) {
		log.debug("checkPartyMember({}) invoked.",email);
		
		List<PartyMemberCheckVO> checkList = this.mapper.checkIt(email);
		
		return checkList;
	} // 
	
	@Override
	public PartyVO getParty(Integer partyCode) {
		log.debug("getParty({}) invoked.",partyCode);
		
		PartyVO party = this.mapper.getInfo(partyCode);

		log.info("\t + party : {}", party);
		
		return party;
		
	} // getParty
	
	@Override
	public boolean doJoin(String email, Integer partyCode) {
		log.debug("doJoin({}, {}) invoked.",email, partyCode);
		
		int affectedLine = this.mapper.makeJoin(email, partyCode);
		
		return (affectedLine==1);
	
	} // doJoin
	
	@Override
	public boolean undoJoin(String email, Integer partyCode) {
		log.debug("undoJoin({}, {}) invoked.",email, partyCode);
		
		int affectedLine = this.mapper.deleteJoin(email, partyCode);
		
		return (affectedLine==1);
		
	} // undoJoin

	@Override
	public boolean editInfo(Map<String, Object> partyInfo) {
		log.debug("editPartyProfile({}) invoked.",partyInfo);

		int affectedLine = this.mapper.modifyInfo(partyInfo);

		log.info("\t + affectedLine : {}",affectedLine);

		return (affectedLine==1);

	} // editPartyProfile


	@Override
	public boolean breakParty(Integer partyCode) {
		log.debug("breakParty({}) invoked.",partyCode);
		
		int affectedLine = this.mapper.makeDesPartyReq(partyCode);
		
		log.info("\t + affectedLine : {}",affectedLine);
		
		return (affectedLine==1);
		
	} // breakParty

	@Override
	public boolean editPL(Integer authCode, String email, Integer partyCode) {
		log.debug("editPL({}, {}) invoked.",email,partyCode);
		
		int affectedLine = this.mapper.delegatePL(authCode, email, partyCode);
		
		log.info("\t + affectedLine : {}",affectedLine);
		
		return (affectedLine==1);
	} // editPL

	@Override
	public boolean acceptJoin(String email, Integer partyCode) {
		log.debug("acceptJoin({}, {}) invoked.",email, partyCode);
		
		int affectedLine = this.mapper.upgradeJoin(email, partyCode);
		
		log.info("\t + affectedLine : {}",affectedLine);
		
		return (affectedLine==1);
		
	} // acceptJoin

	@Override
	public boolean rejectJoin(String email, Integer partyCode) {
		log.debug("rejectJoin({}, {}) invoked.",email, partyCode);
		
		int affectedLine = this.mapper.deleteJoin(email, partyCode);
		
		log.info("\t + affectedLine : {}",affectedLine);
		
		return (affectedLine==1);
		
	} // rejectJoin

	@Override
	public List<PartyUserVO> showMember(Integer partyCode, Criteria cri) {
		log.debug("showMember({},{}) invoked.", partyCode,cri);
		
		List<PartyUserVO> user = this.mapper.getMember(partyCode,cri);
		
		log.info("\t + user : {}",user);
		
		return user;
		
	} // showMember

	@Override
	public Integer getTotalMember(Integer partyCode) {
		log.debug("getTotalMember({}) invoked.", partyCode);
		
		int resultNum = this.mapper.getPartyMN(partyCode);
		log.info("\t+ resultNum : {}",resultNum);
		
		return resultNum;
	} // getTotalMember
	
	@Override
	public boolean kickMember(String email, Integer partyCode) {
		log.debug("kickMember({}, {}) invoked.",email, partyCode);
		
		int affectedLine = this.mapper.deleteJoin(email, partyCode);
		
		log.info("\t + affectedLine : {}",affectedLine);
		
		return (affectedLine==1);
		
	} // kickMember

	@Override
	public UserDTO getJoinMakingList(Integer partyCode, Criteria cri) {
		log.debug("getJoinMakingList({}, {}) invoked.",partyCode, cri);
		
		UserDTO dto = this.mapper.getMakingList(partyCode, cri);
		log.info("\t+ dto : ", dto);
		
		return dto;
		
	} // getJoinMakingList

	@Override
	public Integer getTotalJoinMakeMember(Integer partyCode) {
		log.debug("getTotalJoinMakeMember({}) invoked.", partyCode);
		
		Integer memberlist = this.mapper.getTotalMakingList(partyCode);
		log.info("\t+ memberlist : ", memberlist);
		
		return memberlist;
		
	} // getTotalJoinMakeMember

	

} // end class
