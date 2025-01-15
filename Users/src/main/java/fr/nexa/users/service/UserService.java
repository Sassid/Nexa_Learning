package fr.nexa.users.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import fr.nexa.users.entity.Address;
import fr.nexa.users.entity.User;

public class UserService implements IUserService {
	private static List<User> users = new ArrayList<>();

	@Override
	public User getUser(String email) throws Exception {
		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("L'email est incorrect !");
		}
		if (users.isEmpty()) {
			return null;
		}
//		for (User u : users) {
//			if (u.getEmail().equalsIgnoreCase(email)) {
//				return u;
//			}
//		}
//		return null;(

		// With Stream Method :

		return users.stream().filter(u -> (u.getEmail().equalsIgnoreCase(email))).findFirst().orElse(null);

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

		// With Stream Method :
		return users.stream().filter(u -> (u.getId() == id)).findFirst().orElse(null);
	}

	@Override
	public List<User> getUsers(String firstname) throws Exception {
		if (firstname == null || firstname.isBlank()) {
			throw new IllegalArgumentException("Le nom à rechercher est incorrect !");
		}
		if (users.isEmpty()) {
			return null;
		}
//		List<User> foundUsers = new ArrayList<>();
//		for (User u : users) {
//			if (u.getFirstname().equalsIgnoreCase(firstname)) {
//				foundUsers.add(u);
//			}
//		}
//		return foundUsers;

		// With Stream Method :
		return users.stream().filter(u -> u.getFirstname().equals(firstname)).collect(Collectors.toList());
	}

	@Override
	public Set<User> findUserFromCity(String city) throws Exception {
		if (city == null || city.isBlank()) {
			throw new IllegalArgumentException("La ville est obligatoire!");
		}
		if (users.isEmpty()) {
			return new HashSet<User>();
		}

//		Set<User> foundUsers = new HashSet<User>();
//		for (User u : users) {
//			for (Address a : u.getAddresses()) {
//				if (a.getCity().equalsIgnoreCase(city)) {
//					foundUsers.add(u);
//				}
//			}
//		}
//		return foundUsers;

		// With Stream Method :

		return users.stream().filter(u -> u.getAddresses().stream().anyMatch(a -> a.getCity().equalsIgnoreCase(city)))
				.collect(Collectors.toSet());
	}

	@Override
	public Map<String, Set<User>> findUserByCity() throws Exception {

		if (users.isEmpty()) {
			return new HashMap<>();
		}
		Map<String, Set<User>> map = new HashMap<>();
		Set<String> cities = new HashSet<>();
		// on détermine d'abord la liste de toutes les villes
		for (User u : users) {
			for (Address a : u.getAddresses()) {
				cities.add(a.getCity());
			}
		}
		for (String v : cities) {
			Set<User> usersOfCity = findUserFromCity(v);
			map.put(v, usersOfCity);
		}
		return map;
	}

	public List<User> getAllUsers() {
		return users;
	}

}
