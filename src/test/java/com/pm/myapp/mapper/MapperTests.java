package com.pm.myapp.mapper;/*
package com.pm.myapp.mapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MapperTests {

	@Setter(onMethod_= {@Autowired})
	private xxxMapper mapper;

	@Before
	public void setup() {
		log.debug("setup() invoked.");
		
		assert this.mapper != null;
		log.info("\t + mapper : {}", this.mapper);
		log.info("\t + type : {}", this.mapper.getClass().getName());
	} // setup
	
	
	@Test
	public void testXXX() {
		log.debug("testGetlist() invoked.");

	} // testXXX
	
	@After
	public void tearDown() {
		log.debug("tearDown() invoked.");
	} // tearDown
	
} // end class
*/





