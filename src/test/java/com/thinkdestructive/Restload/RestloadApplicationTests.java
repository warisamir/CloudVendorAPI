package com.thinkdestructive.Restload;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring/applicationContext.xml",
		"classpath:spring/applicationContext-jpa.xml",
		"classpath:spring/applicationContext-security.xml" })
class RestloadApplicationTests {

	@Test
	void contextLoads() {
	}

}
