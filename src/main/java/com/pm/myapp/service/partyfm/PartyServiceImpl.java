package com.pm.myapp.service.partyfm;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public PartyVO getParty(String ptname) {
		log.debug("getParty({}) invoked.",ptname);
		
		PartyVO party = this.mapper.getInfo(ptname);
		log.info("\t + party : {}", party);
		
		return party;
		
	}

	@Override
	public boolean editLogo(String Logo) {
		log.debug("editLogo({}) invoked.",Logo);
		
		int affectedLine = this.mapper.modifyLogo(Logo);
		
		log.info("\t + affectedLine : {}",affectedLine);
		
		return (affectedLine==1);
	} // getParty

}
