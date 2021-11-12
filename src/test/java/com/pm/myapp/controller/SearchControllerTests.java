package com.pm.myapp.controller;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Log4j2
@NoArgsConstructor

@WebAppConfiguration

@RunWith(SpringRunner.class)
@ContextConfiguration(
        locations = {
                "file:src/main/webapp/WEB-INF/spring/root-context.xml",
                "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
        }
)
public class SearchControllerTests {

    @Setter(onMethod_ = {@Autowired})
    private WebApplicationContext ctx;

    private MockMvc mockMvc;
    private MockMvcBuilder mockMvcBuilder;

    @Before
    public void setup() {
        log.debug("setup() invoked.");

        assert this.ctx != null;
        log.info("\t + ctx: {}", ctx);
    } // setup

    @Test
    public void testShowPartyList() throws Exception {
        log.debug("testShowPartyList() invoked.");

        MockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(ctx);
        MockMvc mockMvc = builder.build();

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/search/searchList");
        log.info("requestBuilder: {}", requestBuilder);

        ResultActions resultActions = mockMvc.perform(requestBuilder);
        log.info("resultActions: {}", resultActions);

        MvcResult mvcResult = resultActions.andReturn();

        ModelAndView modelAndView = mvcResult.getModelAndView();

        Map<String, Object> model = modelAndView.getModel();
        log.info("\t+ model: {}", model);
    } // testShowPartyList

    @Test
    public void testShowPartyListBySearch() throws Exception {
        log.debug("testShowPartyListBySearch() invoked.");

        MockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(ctx);
        MockMvc mockMvc = builder.build();

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/search/searchList");
        log.info("requestBuilder: {}", requestBuilder);

        // Criteria cri = new Criteria();
        // cri.setCurrPage(9);
        // cri.setAmount(9);

        requestBuilder.param("cri", "9", "9");
        requestBuilder.param("searchWord1", "%축구%");
        requestBuilder.param("searchWord2", "%축구%");
        requestBuilder.param("searchWord3", "%축구%");

        Map<String, Object> model =
                mockMvc
                        .perform(requestBuilder)
                        .andReturn()
                        .getModelAndView()
                        .getModel();

        model.forEach((t, u) -> {
            log.info("\t+ t: {}", t);
            log.info("\t+ u: {}", u);
        });

        model.clear();
        model = null;
    } // testShowPartyListBySearch

    @After
    public void tearDown() {
        log.debug("tearDown() invoked.");
    } // tearDown
} // end class
