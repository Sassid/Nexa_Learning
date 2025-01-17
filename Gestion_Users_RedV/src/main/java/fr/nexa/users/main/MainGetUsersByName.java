package fr.nexa.users.main;

import java.util.List;

import fr.nexa.users.entity.User;
import fr.nexa.users.service.UserService;

public class MainGetUsersByName {

	public static void main(String[] args) {

		final UserService userService = new UserService();

		try {
			List<User> users = userService.getUsers("Blaise");
			users.forEach(u -> System.out.println(u));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}