package fr.nexa.users.main;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.nexa.users.entity.Adresse;
import fr.nexa.users.entity.User;
import fr.nexa.users.service.IUserService;
import fr.nexa.users.service.UserService;

public class MainUsers {

	public static void main(String[] args) {
		
		User u1 = new User();
		u1.setNom("BLAISE");
		u1.setPrenom("Pascal");
		u1.setEmail("blaise@gmail.com");
		u1.setPassword("blaisepass");
		u1.setId(1);
		
		Adresse a11 = new Adresse("7", "Rue de la gare", "Paris", "75000");
		Adresse a12 = new Adresse("5", "Boulevard de France", "Lyon", "69000");
		u1.getAdresses().add(a11);
		u1.getAdresses().add(a12);
		
		User u2 = new User("HUGO", "Victor", "hugo@gmail.com", "hugopass");
		u2.setId(2);

		Adresse a21 = new Adresse("3", "Avenue Paul Bert", "Paris", "75000");
		Adresse a22 = new Adresse("5", "Boulevard de France", "Lille", "59000");
		u2.getAdresses().add(a21);
		u2.getAdresses().add(a22);
		
		UserService userService = new UserService();
		userService.getAllUsers().add(u1);
		userService.getAllUsers().add(u2);
		
		User u3 = new User("BLAISE", "Benoît", "benoit@gmail.com", "benoitpass");
		u3.setId(3);
		userService.getAllUsers().add(u3);
		
		List<User> users = userService.getAllUsers();
		
//		System.out.println("1============================================");
//
//		// boucle for avec le for avec des index
//		for (int i = 0; i < users.size(); i++) {
//			User u = users.get(i);
//			System.out.println(u);  // System.out.println(u.getNom() + " " u.getPrenom());
//			for (int j = 0; j < u.getAdresses().size(); j++) {
//				Adresse a = u.getAdresses().get(j);
//				System.out.println("  -> " + a);
//			}
//		}
//		System.out.println("2============================================");
//		
//		// boucle for avec les objets : le foreach (depuis Java 7)
//		for (User u : users) {
//			System.out.println(u);
//			for (Adresse a : u.getAdresses()) {
//				System.out.println("  ->" + a);
//			}
//		}
//		System.out.println("3============================================");
//		
//		// boucle for avec les expressions Lambda (depuis Java 8)
//		users.forEach(u -> { System.out.println(u);
//							 u.getAdresses().forEach(a -> System.out.println(" ->" + a));
//						   });
//		
//		System.out.println("4============================================");
//		
//		// boucle avec l'API Stream (depuis Java 8)
//		users.stream().forEach(u -> { System.out.println(u);
//							 u.getAdresses().forEach(a -> System.out.println(" ->" + a));
//						   });
//
//		System.out.println("5============================================");
//		
//		// boucle avec l'iterator (depuis Java 1.2)
//		for (Iterator<User> iterUser = users.iterator(); iterUser.hasNext();) {
//			User u = iterUser.next();
//			System.out.println(u);
//			for (Iterator<Adresse> iterAdresse = u.getAdresses().iterator(); iterAdresse.hasNext();) {
//				Adresse a = iterAdresse.next();
//				System.out.println(" -> " + a);
//			}
//		}
		
//		try {
//			System.out.println(userService.getUser(2));
//			System.out.println("----------------------");
//			System.out.println(userService.getUser("hugo@gmail.com"));
//			System.out.println("-----------------------");
//			userService.getUsers("blaise").forEach(u -> System.out.println(u));
//			System.out.println("-----------------------");
//			userService.findUsersOfVille("Lyon").forEach(u -> System.out.println(u));
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			Map<String, Set<User>> map = userService.findUsersByVille();
			for (Map.Entry<String, Set<User>> entry : map.entrySet()) {
				String ville = entry.getKey();
				Set<User> usersOfVille = entry.getValue();
				System.out.println("Ville : " + ville);
				usersOfVille.forEach(u -> System.out.println(" -> " + u));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
