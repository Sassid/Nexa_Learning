package fr.nexa.banque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.nexa.banque.entity.Client;
import fr.nexa.banque.entity.Compte;



public class CompteService implements ICompteService {
	
	private static List<Client> clients = new ArrayList<>();

	@Override
	public void boucler(Integer compteId) throws Exception {
		
		if (compteId == null || compteId <= 0) {
			throw new IllegalArgumentException("L'id doit être non NULL et > 0 !");
		}
		if (clients.isEmpty()) {
			throw new IllegalArgumentException("cherche pas frérot, y'a R");
		}
		
		for (Client client : clients) {
			for (Compte compte : client.getComptes()) {
				System.out.println(compte.getSolde() * compte.getTaux());
			}
		}
		
	}

}
