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

public class ControllerTests {

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
	public void testList() throws Exception {
		log.debug("testList() invoked.");
		
		// Step.1 : MockMvcBuilder 객체를 생성
		MockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(ctx);
		log.info("\t + builder : {}",builder);
		
		// Step.2 : MockMvcBuilder 객체를 이용해서, MockMvc(like web browser) 객체를 얻어냄
		MockMvc mockMvc = builder.build();
		log.info("\t + mockMvc : {}",mockMvc);
		
		// Step.3 : RequestBuilder 객체를 얻어내야 함
		// 사용법 : MockMvcRequestBuilders.전송방식메서드(우리가 요청할 requestURI 지정)
		RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/admin/doKickUser");
		
		// Step.4 : MockMvc 객체를 통해서, 위의 RequestBuilder를 이용해서, 실제 요청을 보냄.
		ResultActions resultActions = mockMvc.perform(reqBuilder);
		
		// Step.5 : resultActions 로부터 테스트 대상이되는 개발자가 만든 컨트롤러
		// 로부터 2가지를 얻을 수 있다 model and viewname
		MvcResult mvcResult = resultActions.andReturn();
				
		// Step.6 : Step.5 에서 얻어낸 MvcResult로 부터, Model and View 이름
		ModelAndView modelAndView = mvcResult.getModelAndView();
		
		// Step.7 : ModelAndView 객체로부터 우리가 알고자하는 model이나 view이름을 끄집어 낼 수 있다
		Map<String,Object> model = modelAndView.getModel();
		log.info("\t+ model : {}",model);
		
		// Step.8 : ModelAndView 객체로부터 우리가 알고자 하는 View이름을 얻어내어 출력
		String viewName = modelAndView.getViewName();
		log.info("\t+ viewName : {}",viewName);
		
	} // testList
	
	@After
	public void tearDown() {
		log.debug("tearDown() invoked.");
	} // tearDown
	
	
}
