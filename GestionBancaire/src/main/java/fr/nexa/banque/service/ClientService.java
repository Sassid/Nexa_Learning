package fr.nexa.banque.service;

import java.util.ArrayList;
import java.util.List;

import fr.nexa.banque.entity.Client;

public class ClientService implements IClientService {
	
	private static List<Client> clients = new ArrayList<>();

	@Override
	public void afficherSolde() throws Exception {
		clients.forEach(c -> c.getNom());
		
	}



}
