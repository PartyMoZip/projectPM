package com.pm.myapp.service.partyfm;

import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.myapp.domain.PartyDTO;
import com.pm.myapp.domain.PartyUserVO;
import com.pm.myapp.domain.PartyVO;
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
	public boolean editLogo(String logoPic, Integer partyCode) {
		log.debug("editLogo({}, {}) invoked.",logoPic, partyCode);
		
		int affectedLine = this.mapper.modifyLogo(logoPic, partyCode);
		
		log.info("\t + affectedLine : {}",affectedLine);
		
		return (affectedLine==1);
		
	} // editLogo

	@Override
	public PartyVO editInfo(PartyDTO dto, Integer partyCode) {
		log.debug("editInfo({}, {}) invoked.",dto,partyCode);
		
		PartyVO vo = this.mapper.modifyInfo(dto,partyCode);
		
		log.info("\t + vo : {}",vo);
		
		return vo;
	} // editInfo

	@Override
	public boolean breakParty(Integer partyCode) {
		log.debug("breakParty({}) invoked.",partyCode);
		
		int affectedLine = this.mapper.makeDesPartyReq(partyCode);
		
		return (affectedLine==1);
		
	} // breakParty

	@Override
	public boolean editPL(Integer authCode, String email, Integer partyCode) {
		log.debug("editPL({}, {}) invoked.",email,partyCode);
		
		int affectedLine = this.mapper.delegatePL(authCode, email, partyCode);
		
		return (affectedLine==1);
	} // editPL

	@Override
	public boolean acceptJoin(String email, Integer partyCode) {
		log.debug("acceptJoin({}, {}) invoked.",email, partyCode);
		
		int affectedLine = this.mapper.upgradeJoin(email, partyCode);
		
		return (affectedLine==1);
	} // acceptJoin

	@Override
	public boolean rejectJoin(String email, Integer partyCode) {
		log.debug("rejectJoin({}, {}) invoked.",email, partyCode);
		
		int affectedLine = this.mapper.deleteJoin(email, partyCode);
		
		return (affectedLine==1);
		
	} // rejectJoin

	@Override
	public List<PartyUserVO> showMember(Integer partyCode) {
		log.debug("showMember({}) invoked.", partyCode);
		
		List<PartyUserVO> user = this.mapper.getMember(partyCode);
		
		return user;
	} // showMember

	@Override
	public boolean kickMember(String email, Integer partyCode) {
		log.debug("kickMember({}, {}) invoked.",email, partyCode);
		
		int affectedLine = this.mapper.deleteJoin(email, partyCode);
		
		return (affectedLine==1);
	} // kickMember


	

}
