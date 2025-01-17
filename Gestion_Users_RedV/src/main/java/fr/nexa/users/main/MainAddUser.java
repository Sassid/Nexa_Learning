package fr.nexa.users.main;

import fr.nexa.users.entity.User;
import fr.nexa.users.service.UserService;

public class MainAddUser {

	public static void main(String[] args) {

		final UserService userService = new UserService();

		try {
			User user = new User("Boulga", "Globby", "gbgba@gmail.com", "shumiruburikku");
			int id = userService.addUser(user);
			System.out.println("Utilisateur créé avec succès : id = " + id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
