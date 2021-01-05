package com.user.registration.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.user.registration.model.User;
import com.user.registration.service.IRegistrationService;
import com.user.registration.service.RegistrationService;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)

class RegistrationControllerTest {
	

	@Mock
	public IRegistrationService serviceMock;
	
	@InjectMocks
	public RegistrationController controller;
	
	User user = new User("bill1","shardon","bill1@gmail.com","234531");
//	String userJson = "{\"first_name\":\"bill1\",\"last_name\":\"shardon\",\"email\":\"bill@gmail.com\",\"phone_number\":\"243522\"}";

//	@Autowired
//	private MockMvc mockMvc;


	@BeforeEach
	void init() {
//		controller = new RegistrationController(); //remove new
		controller.setRegistrationService(serviceMock);
	}
	
	@Test
	void testCheck() throws Exception {
		when(serviceMock.check()).thenReturn("Hello");
		assertEquals("Hello",controller.check());
	}

	@Test
	void testAddUser() throws Exception {
		Mockito.when(serviceMock.addUser(user)).thenReturn(user).thenReturn(user);
	}

	@Test
	void testAddUser_null() throws Exception {
		Mockito.when(serviceMock.addUser(user)).thenReturn(null);
	}
	
	@Test
	void testGetAllUsers() {
		Mockito.when(serviceMock.getAllUsers()).thenReturn(null);
		assertEquals(null,controller.getAllUsers());
	}

	@Test
	void testDeleteUser() {
		fail("Not yet implemented");
	}

}
