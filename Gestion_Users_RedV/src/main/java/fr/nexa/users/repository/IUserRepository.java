package fr.nexa.users.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.nexa.users.entity.User;

public interface IUserRepository {

	Integer addUser(User user) throws Exception;
	void updateUser(User user) throws Exception;
	void removeUser(Integer id) throws Exception;
	
	User getUser(Integer id) throws Exception;
	User getUser(String email) throws Exception;
	List<User> getUsers(String name) throws Exception;
	Set<User> findUsersOfVille(String ville) throws Exception;
	Map<String, Set<User>> findUsersByVille() throws Exception;
}
