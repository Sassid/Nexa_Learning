package fr.nexa.users.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import fr.nexa.users.entity.Adresse;
import fr.nexa.users.entity.User;
import fr.nexa.users.repository.UserRepository;

public class UserService implements IUserService {

	private final UserRepository userRepository = new UserRepository();

	public UserService() {
	}

	@Override
	public Integer addUser(User user) throws Exception {
		if (user == null) {
			throw new NullPointerException("Le user à créer doit être non NULL !");
		}

		if (user.getNom() == null || user.getNom().isBlank() || user.getPrenom() == null || user.getPrenom().isBlank()
				|| user.getEmail() == null || user.getEmail().isBlank() || user.getPassword() == null
				|| user.getPassword().isBlank()) {
			throw new IllegalArgumentException("Un ou plusieurs paramètres sont manquants");

		}

		return userRepository.addUser(user);
	}

	@Override
	public void updateUser(User user) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUser(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUser(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<User> findUsersOfVille(String ville) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Set<User>> findUsersByVille() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
