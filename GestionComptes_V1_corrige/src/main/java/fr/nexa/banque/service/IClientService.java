package fr.nexa.banque.service;

public interface IClientService {

	void bouclerComptes() throws Exception;
	void afficherSoldes() throws Exception;
	void getClientsAyantSoldesDebiteurs() throws Exception;
	void getClientsSansCompteEpargne() throws Exception;
}
