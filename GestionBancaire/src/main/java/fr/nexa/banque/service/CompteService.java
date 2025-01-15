package fr.nexa.banque.service;

import java.util.ArrayList;
import java.util.List;

import fr.nexa.banque.entity.Client;
import fr.nexa.banque.entity.Compte;



public class CompteService implements ICompteService {
	
	private static List<Client> clients = new ArrayList<>();

	@Override
	public void boucler(Integer compteId, Integer clientId) throws Exception {
		
		if (compteId == null || compteId <= 0 && clientId == null || clientId <= 0) {
			throw new IllegalArgumentException("L'id doit être non NULL et > 0 !");
		}
		if (clients.isEmpty()) {
			throw new IllegalArgumentException("cherche pas frérot, y'a R");
		}
		
		for (Client client : clients) {
			for (Compte compte : client.getComptes()) {
				compte.setSolde(compte.getSolde() * compte.getTaux());
			}
		}
		
	}


	public List<Client> getClients() {
		return clients;
	}
	
	

}
