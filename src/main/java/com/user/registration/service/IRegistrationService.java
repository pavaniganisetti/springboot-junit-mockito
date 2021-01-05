package com.user.registration.service;

import java.util.List;
import java.util.Map;

import com.user.registration.model.User;

public interface IRegistrationService {
	public String check();
	public User addUser(User user) ;
	public List<Map<String, Object>> getAllUsers() ;
	public void deleteUser(String email) ;
}
