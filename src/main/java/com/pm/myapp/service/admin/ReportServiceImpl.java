package com.pm.myapp.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.myapp.mapper.ReportMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@Service
public class ReportServiceImpl implements ReportService{

	@Setter(onMethod_= {@Autowired})
	private ReportMapper mapper;
	
	@Override
	public boolean reportBlackParty(Integer partyCode) {
		
		//Integer checkReport = this.mapper.checkReportParty(partyCode);
		
		Integer report = this.mapper.reportParty(partyCode);
		
		return (report==1);
	}

}
