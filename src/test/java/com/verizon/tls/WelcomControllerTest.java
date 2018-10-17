package com.verizon.tls;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.tls.controller.WelcomeController;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=WelcomeController.class)
public class WelcomControllerTest {
	
	//mock is something which doesn't exist but it reacts as if it exists
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp(){
		mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@After
	public void tearDown(){
		mockMvc=null;
	}
	
	@Test
	public void testShowHome() throws Exception{
		this.mockMvc.perform(get("/"))
		.andExpect(status().isOk()).andExpect(view().name("index")).andDo(print());
	
		this.mockMvc.perform(get("/home"))
		.andExpect(status().isOk()).andExpect(view().name("index")).andDo(print());
	}
	
	
	@Test
	public void testPostNotSupported() throws Exception{
		this.mockMvc.perform(post("/"))
		.andExpect(status().is4xxClientError()).andDo(print());
	}
}
