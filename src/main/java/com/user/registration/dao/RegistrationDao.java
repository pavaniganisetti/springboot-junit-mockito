package com.user.registration.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.user.registration.model.User;


@Repository
public class RegistrationDao {
	
	private static final Logger log = LoggerFactory.getLogger(RegistrationDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addUser(User user) 
	{
		log.debug("RegistrationDao addUser");
		String query = "insert into AL364_user_details values(?,?,?,?)";
		try {
			jdbcTemplate.update(query,user.getFirstName(),user.getLastName(),user.getEmail(),user.getPhoneNumber());
		}
		catch(Exception e) {
			throw e;
		}
	}

	public List<Map<String, Object>> getAllUsers() 
	{
		log.debug("RegistrationDao getAllUsers");
		List<Map<String, Object>> users = null;
		try {
			String query = "select * from AL364_user_details";
			users = jdbcTemplate.queryForList(query);
		}
		catch(Exception e) {
			throw e;
		}
		return users;
	}

	public void deleteUser(String email) {
		log.debug("RegistrationDao deleteUser()");
		try {
			String query = "delete from AL364_user_details where email=?";
			jdbcTemplate.update(query, email);
		}
		catch(Exception e) {
			throw e;
		}
	}
}
