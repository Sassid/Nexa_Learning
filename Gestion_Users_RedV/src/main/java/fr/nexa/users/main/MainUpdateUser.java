package fr.nexa.users.main;

import fr.nexa.users.entity.User;
import fr.nexa.users.service.UserService;

public class MainUpdateUser {

	public static void main(String[] args) {

		final UserService userService = new UserService();

		try {
			User user = userService.getUser(3);
			user.setNom(user.getNom().concat("-MAJ"));
			user.setPrenom(user.getPrenom().concat("-MAJ"));
			userService.updateUser(user);
			System.out.println("Utilisateur mis à jour avec succès :");
			System.out.println(userService.getUser(3));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
