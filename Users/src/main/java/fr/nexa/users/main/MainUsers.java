package fr.nexa.users.main;

import java.util.Iterator;
import java.util.List;

import fr.nexa.users.entity.Address;
import fr.nexa.users.entity.User;
import fr.nexa.users.service.UserService;

public class MainUsers {

	public static void main(String[] args) {
		
		User u1 = new User();
		
		u1.setFirstname("Blaze");
		u1.setLastname("Fielding");
		u1.setEmail("blaze.f@gmail.com");
		u1.setPassword("GoFire!");
		u1.setId(1);
		
		Address a11 = new Address("555", "rage street", "LA", "90102");
		Address a12 = new Address("666", "rage street", "NYC", "12548");
		u1.getAddresses().add(a11);
		u1.getAddresses().add(a12);
		
		 User u2 = new User("Hugo", "Victor", "hugo@gmail.com","azerty");
		 u1.setId(2);


	     Address a21 = new Address("3", "Avenue Paul Bert", "Paris", "75000");
	     Address a22 = new Address("5", "Boulevard de France", "Lille", "69000");
	     u2.getAddresses().add(a21);
	     u2.getAddresses().add(a22);
	     
	     UserService userService = new UserService();
	     userService.getAllUsers().add(u1);
	     userService.getAllUsers().add(u2);
	     
	     User u3 = new User("Amy", "Fielding", "benoit@gmail.com", "benoitpass");
		 u1.setId(3);

	     userService.getAllUsers().add(u3);
	     
	     List<User> users = userService.getAllUsers();
	     
//	     // For Loop (classic)
//	     for (int i = 0; i < users.size(); i++) {
//	    	 User u = users.get(i);
////	    	 System.out.println(u.getFirstname() + " " + u.getLastname());
//	    	 System.out.println(u);
//	    	 for (int j = 0; j < u.getAddresses().size(); j++) {
//				Address a = u.getAddresses().get(j);
//				System.out.println(" -> " + a);
//			}
//			
//		}
//	     
//	     System.out.println("------------------------------------");
//	
//	     //For Loop with object : for(each) (since Java7)
//	     for (User u : users) {
//			System.out.println(u);
//			for (Address a : u.getAddresses()) {
//				System.out.println(" -> " + a);
//				
//			}
//		}
//	     
//	     System.out.println("------------------------------------");
//	     
//	     // For Loop with Lambda expression (since Java 8)
//	     users.forEach(u -> {
//	            System.out.println(u); 
//	            u.getAddresses().forEach(a -> System.out.println(" ->" + a));
//	            });
//
//	     System.out.println("------------------------------------");
//	     
//	     // For Loop with API Stream (since Java8)
//	     users.stream().forEach(u -> {
//	            System.out.println(u); 
//	            u.getAddresses().forEach(a -> System.out.println(" ->" + a));
//	            });
//	     
//	     System.out.println("------------------------------------");
//	     
//	     // For Loop with iterator (since Java2)
//	     for (Iterator<User> iteratUser = users.iterator(); iteratUser.hasNext();) {
//			User u = (User) iteratUser.next();
//			System.out.println(u);
//			for (Iterator<Address> iteraAddress = u.getAddresses().iterator(); iteraAddress.hasNext();) {
//				Address a = (Address) iteraAddress.next();
//				System.out.println(" -> " + a);
//			}
//			
//		}
	     
//	     try {
//	         System.out.println(userService.getUser(-3));
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	     
//	     try {
//	    	 System.out.println(userService.getUser(""));
//	     	} catch (Exception e) {
//	    	 	e.printStackTrace();
//	     	}
	     
	     try {
	    	 System.out.println(userService.findUserFromCity("paris"));
	    	 System.out.println("----------------------------------");
	    	 userService.getUsers("blaze").forEach(u -> System.out.println(u));
	     } catch (Exception e) {
	    	 e.printStackTrace();
	     }
	     
	     
	}

}
