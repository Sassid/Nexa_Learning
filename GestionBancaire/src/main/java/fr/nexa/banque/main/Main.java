package fr.nexa.banque.main;

import java.util.HashSet;
import java.util.Set;

import fr.nexa.banque.entity.Client;
import fr.nexa.banque.entity.Compte;
import fr.nexa.banque.service.ClientService;
import fr.nexa.banque.service.CompteService;

public class Main {

	public static void main(String[] args) {
		
		Client client1 = new Client("Némar", "Jean", "JeanNémar@gmail.com", "cacapipi", new HashSet<>());
		Client client2 = new Client("Culent", "Fée", "FéeCulent@gmail.com", "patapatapatapon", new HashSet<>());

		
		Compte compte1 = new Compte("courant", 100.00f , 0.01f);
		Compte compte2 = new Compte("épargne", 200.00f , 0.02f);
		client1.getComptes().add(compte1);
		client1.getComptes().add(compte2);
		
		Compte compte3 = new Compte("courant", 300.00f , 0.01f);
		Compte compte4 = new Compte("épargne", 400.00f , 0.02f);
		client2.getComptes().add(compte3);
		client2.getComptes().add(compte4);

		ClientService clientService = new ClientService();
		CompteService compteService = new CompteService();
		
		try {
			clientService.afficherSolde();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		try {
//			compteService.boucler(2, 1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}

}
