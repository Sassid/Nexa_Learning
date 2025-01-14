package fr.nexa.users.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.nexa.users.entity.User;

public interface IUserService {
	
	User getUser(String email) throws Exception;
	User getUser(Integer id) throws Exception;
	List<User> getUsers(String name) throws Exception;
	
	Set<User> findUserFromCity(String city) throws Exception;
	
	Map<String, Set<User>> findUserbyCity(String city) throws Exception;
	

}
