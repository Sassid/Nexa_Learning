package fr.nexa.banque.main;

import fr.nexa.banque.entity.Client;
import fr.nexa.banque.entity.Compte;
import fr.nexa.banque.service.ClientService;

public class Main {

	public static void main(String[] args) {

		final ClientService cs = new ClientService();
		
		Client client1 = new Client("blaise", "Pascal", "blaise@gmail.com", "blaisepass");
		client1.setId(1);
		Compte compte11 = new Compte("Principal", 100f, 0.01f);
		compte11.setId(11);
		Compte compte12 = new Compte("Epargne", 200f, 0.02f);
		compte12.setId(12);
		client1.getComptes().add(compte11);
		client1.getComptes().add(compte12);
		ClientService.getClients().add(client1);
		
		Client client2 = new Client("hugo", "Victor", "hugo@gmail.com", "hugopass");
		client2.setId(2);
		Compte compte21 = new Compte("Principal", 300f, 0.01f);
		compte21.setId(21);
		Compte compte22 = new Compte("Epargne", 400f, 0.02f);
		compte22.setId(22);
		client2.getComptes().add(compte21);
		client2.getComptes().add(compte22);
		ClientService.getClients().add(client2);
		
		Client client3 = new Client("popo", "Jin", "jin@gmail.com", "gackt");
		client3.setId(3);
		Compte compte31 = new Compte("Principal", -300f, 0.01f);
		compte31.setId(31);
		Compte compte32 = new Compte("Epargne", -400f, 0.02f);
		compte32.setId(32);
		client3.getComptes().add(compte31);
		client3.getComptes().add(compte32);
		ClientService.getClients().add(client3);
		
		
//		try {
//			System.out.println("Solde des comptes avant l'opération de bouclage :");
//			System.out.println("--------------------------------------------------");
//			cs.afficherSoldes();
//			System.out.println("Opération de bouclage en cours...");
//			System.out.println("---------------------------------");
//			cs.bouclerComptes();
//			System.out.println("Solde des comptes après l'opération de bouclage :");
//			System.out.println("--------------------------------------------------");
//			cs.afficherSoldes();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			System.out.println("Liste des clients débiteurs :");
			cs.getClientsAyantSoldesDebiteurs();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
