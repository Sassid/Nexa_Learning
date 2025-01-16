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

public class UserService implements IUserService {

	
	
	public UserService() {
	}

	@Override
	public User getUser(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("L'id doit être non NULL et > 0 !");
		}
		if (users.isEmpty()) {
			return null;
		}
//		for (User u : users) {
//			if (u.getId() == id) {
//				return u;
//			}
//		}
//		return null;
		return users.stream()
					.filter(u -> (u.getId() == id))
					.findFirst()
					.orElse(null);
	}

	@Override
	public User getUser(String email) throws Exception {
		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("L'email à rechercher est incorrect !");
		}
		if (users.isEmpty()) {
			return null;
		}
//		for (User u : users) {
//			if (u.getEmail().equalsIgnoreCase(email)) {
//				return u;
//			}
//		}
//		return null;
		return users.stream()
					.filter(u -> (u.getEmail().equalsIgnoreCase(email)))
					.findFirst()
					.orElse(null);
	}

	@Override
	public List<User> getUsers(String name) throws Exception {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Le nom à rechercher est incorrect !");
		}
		if (users.isEmpty()) {
			return null;
		}
//		List<User> foundedUsers = new ArrayList<>();
//		for (User u : users) {
//			if (u.getNom().equalsIgnoreCase(name)) {
//				foundedUsers.add(u);
//			}
//		}
//		return foundedUsers;
		
		return users.stream()
				.filter(u -> u.getNom().equalsIgnoreCase(name))
				.collect(Collectors.toList());
	}

	@Override
	public Set<User> findUsersOfVille(String ville) throws Exception {
		if (ville == null || ville.isBlank()) {
			throw new IllegalArgumentException("La ville est obligatoire !");
		}
		if (users.isEmpty()) {
			return new HashSet<>();
		}
//		Set<User> foundedUsers = new HashSet<>();
//		for (User u : users) {
//			for (Adresse a : u.getAdresses()) {
//				if (a.getVille().equalsIgnoreCase(ville)) {
//					foundedUsers.add(u);
//				}
//			}
//		}
//		return foundedUsers;
		
		return users.stream()
					.filter(u -> u.getAdresses()
									.stream()
									.anyMatch(a -> a.getVille().equalsIgnoreCase(ville))
							)
					.collect(Collectors.toSet());
	}

	@Override
	public Map<String, Set<User>> findUsersByVille() throws Exception {
		
		if (users.isEmpty()) {
			return new HashMap<>();
		}
		Map<String, Set<User>> map = new HashMap<>();
		Set<String> villes = new HashSet<>();
		// on détermine d'abord la liste de toutes les villes
		for (User u : users) {
			for (Adresse a : u.getAdresses()) {
				villes.add(a.getVille());
			}
		}
		for (String v : villes) {
			Set<User> usersOfVille = findUsersOfVille(v);
			map.put(v, usersOfVille);
		}
		return map;
	}

	public List<User> getAllUsers() {
		return users;
	}
	
}
