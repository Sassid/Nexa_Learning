package fr.nexa.users.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.nexa.users.entity.User;

public interface IUserService {

	User getUser(Integer id) throws Exception;
	User getUser(String email) throws Exception;
	List<User> getUsers(String name) throws Exception;
	Set<User> findUsersOfVille(String ville) throws Exception;
	Map<String, Set<User>> findUsersByVille() throws Exception;
}
