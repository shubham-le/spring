package com.aop.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;
	private final static String[] URLS = { "/live", "/id?name=Test", "/name?id=1", "/getUserById?id=1" };

	@BeforeEach
	void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testLive() throws Exception {
		for (String uri : URLS) {
			var mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();
			System.out.println(uri + " response: " + mvcResult.getResponse().getContentAsString() + "\n");
		}
	}

}
