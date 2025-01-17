package fr.nexa.users.main;

import fr.nexa.users.entity.User;
import fr.nexa.users.service.UserService;

public class MainGetUserByEmail {

	public static void main(String[] args) {
		final UserService userService = new UserService();
		
		try {
			User user = userService.getUser("r.finn@gmail.com");
			System.out.println(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
