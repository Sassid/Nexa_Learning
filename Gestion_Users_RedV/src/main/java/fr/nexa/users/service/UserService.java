package fr.nexa.users.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

			throw new IllegalArgumentException("Un ou plusieurs paramètres sont manquants !");
		}
		return userRepository.addUser(user);
	}

	@Override
	public void updateUser(User user) throws Exception {
		if (user == null) {
			throw new NullPointerException("Le user à créer doit être non NULL !");
		}
		if (user.getId() == null || user.getId() <= 0 || user.getNom() == null || user.getNom().isBlank()
				|| user.getPrenom() == null || user.getPrenom().isBlank()) {

			throw new IllegalArgumentException("Un ou plusieurs paramètres sont manquants !");
		}
		userRepository.updateUser(user);
	}

	@Override
	public void removeUser(Integer id) throws Exception {
		userRepository.removeUser(id);

	}

	@Override
	public User getUser(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("L'id doit être > 0");
		}
		return userRepository.getUser(id);
	}

	@Override
	public User getUser(String email) throws Exception {
		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("l'e-mail ne peut pas être vide");
		}
		return userRepository.getUser(email);
	}

	@Override
	public List<User> getUsers(String name) throws Exception {
		return userRepository.getUsers(name);
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
