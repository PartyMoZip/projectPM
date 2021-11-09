package com.pm.myapp.controller;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor
@WebAppConfiguration

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})

public class PartyControllerTests {

	@Setter(onMethod_= {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	private MockMvcBuilder mockMvcBuilder;
	
	@Before
	public void setup() {
		log.debug("setup() invoked.");
		
		assert this.ctx !=null;
		log.info("\t + ctx : {}", ctx);
		
	} // setup
	
	@Test
	public void testshowPartyDetail() throws Exception {
		log.debug("testshowPartyDetail() invoked.");
		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();
		
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/party/showPartyDetail");
		reqBuilder.param("partyCode", "11111");
		
		Map<String, Object> modelMap =  mockMvc.
										perform(reqBuilder).
										andReturn().
										getModelAndView().
										getModel();
		
		String viewName =  mockMvc.
				perform(reqBuilder).
						andReturn().
				  getModelAndView().
				  	  getViewName();
		
		modelMap.forEach((k,v)->{
			log.info("\t+ k : {}",k);
			log.info("\t+ v : {}",v);
		});
		log.info("\t+ viewName : {}",viewName);
		
		// for GC of a Map Object.
		modelMap.clear();
		modelMap=null;
		
	} // testshowPartyDetail
	
	@Test
	public void testshowPartyMain() throws Exception {
		log.debug("testshowPartyMain() invoked.");
		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();
		
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/party/showPartyMain");
		reqBuilder.param("partyCode", "11111");
		
		Map<String, Object> modelMap =  mockMvc.
										perform(reqBuilder).
										andReturn().
										getModelAndView().
										getModel();
		
		String viewName =  mockMvc.
				perform(reqBuilder).
						andReturn().
				  getModelAndView().
				  	  getViewName();
		
		modelMap.forEach((k,v)->{
			log.info("\t+ k : {}",k);
			log.info("\t+ v : {}",v);
		});
		log.info("\t+ viewName : {}",viewName);
		
		// for GC of a Map Object.
		modelMap.clear();
		modelMap=null;
		
	} // testshowPartyMain
	
	//doPartyJoin
	@Test
	public void testeditParty() throws Exception {
		log.debug("testeditParty() invoked.");
		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();
		
		// 요청 URI + 전송방식(POST)이 설정되어 있는 요청 객체를 생성
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/party/editParty");
		

		// 3개의 전송파라미터를 요청 문서에 설정
		reqBuilder.param("partyName", "수정_파티1");
		reqBuilder.param("partyProfile", "수정_테스트프로필1");
		reqBuilder.param("localCode", "2");
		reqBuilder.param("hobbyCode", "3");
		reqBuilder.param("partyCode", "11111");

		String viewName =  mockMvc.
				perform(reqBuilder).
						andReturn().
				  getModelAndView().
				  	  getViewName();
		
		log.info("\t+ viewName : {}",viewName);
		

		
	} // testeditParty
	
	@After
	public void tearDown() {
		log.debug("tearDown() invoked.");
	} // tearDown
	
	
}
