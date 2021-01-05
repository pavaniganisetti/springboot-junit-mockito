package com.user.registration.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.user.registration.dao.RegistrationDao;
import com.user.registration.model.User;

@Service
@Qualifier("regService")
public class RegistrationService implements IRegistrationService{
	
	private static final Logger log = LoggerFactory.getLogger(RegistrationService.class);
	
	@Autowired
	private RegistrationDao dao;

	public User addUser(User user) 
	{
		log.debug("RegistrationService addUser");
		try {
			dao.addUser(user);
		}
		catch(Exception e) {
			throw e;
		}
		return user;
	}

	public List<Map<String, Object>> getAllUsers() 
	{
		log.debug("RegistrationService getAllUsers()");
		List<Map<String, Object>> users;
		try {
			users = dao.getAllUsers();
		}
		catch(Exception e) {
			throw e;
		}
		return users;
	}

	public void deleteUser(String email) 
	{
		log.debug("RegistrationService deleteUser()");
		try {
			dao.deleteUser(email);
		}
		catch(Exception e) {
			throw e;
		}
	}

	@Override
	public String check() {
		return "Hello";
	}
}
