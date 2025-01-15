package fr.nexa.banque.service;

import fr.nexa.banque.entity.Client;
import fr.nexa.banque.entity.Compte;

public class CompteService implements ICompteService {

	public CompteService() {
	}
	
	@Override
	public void boucler(Integer clientId, Integer compteId) throws Exception {
		
		if (clientId == null || clientId <= 0 ) {
			throw new IllegalArgumentException("L'id du client doit ête > 0 !");
		}
		if (compteId == null || compteId <= 0) {
			throw new IllegalArgumentException("L'id du compte doit ête > 0 !");
		}
		
		Client client = ClientService.getClients()
							.stream()
							.filter(c -> c.getId() == clientId)
							.findFirst().orElse(null);
		
		if (client == null) {
			throw new NullPointerException("Le client avec l'id suivant n'existe pas : " + clientId);
		}
		
		Compte compte = client.getComptes()
								.stream()
								.filter(c -> c.getId() == compteId)
								.findFirst()
								.orElse(null);
		if (compte == null) {
			throw new NullPointerException("Le compte à boucler n'existe pas : id = " + compteId);
		}
		compte.setSolde(compte.getSolde()*(1 + compte.getTaux()));
	}

}
