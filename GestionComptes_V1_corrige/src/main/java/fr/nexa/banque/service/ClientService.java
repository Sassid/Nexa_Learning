package fr.nexa.banque.service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import fr.nexa.banque.entity.Client;
import fr.nexa.banque.entity.Compte;

public class ClientService implements IClientService {

	private static Set<Client> clients = new HashSet<>();
	
	private final CompteService cs = new CompteService();
	
	public ClientService() {
	}
	
	@Override
	public void bouclerComptes() throws Exception {
		
		for (Client client : clients) {
			for (Compte compte : client.getComptes()) {
				cs.boucler(client.getId(), compte.getId());
			}
		}
	}

	@Override
	public void afficherSoldes() throws Exception {
		for (Client client : clients) {
			System.out.println("Client : " + client.getNom().toUpperCase() + " " + client.getPrenom());
			for (Compte compte : client.getComptes()) {
				System.out.println("  => compte '" + compte.getTitre() + "' : " + compte.getSolde());
			}
		}
	}

	public static Set<Client> getClients() {
		return clients;
	}

	
}
