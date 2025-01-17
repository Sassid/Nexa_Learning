package fr.nexa.users.main;

import fr.nexa.users.entity.User;
import fr.nexa.users.service.UserService;

public class MainRemoveUser {

	public static void main(String[] args) {
		final UserService userService = new UserService();

		try {
			// Retrieve the user before deletion
			User user = userService.getUser(7);
			if (user == null) {
				System.out.println("Aucun utilisateur trouvé avec l'ID donné.");
				return;
			}

			// Remove the user
			userService.removeUser(7);

			// Display confirmation message
			System.out.println("Le user : " + user.getNom() + " " + user.getPrenom() + " a été supprimé avec succès");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
