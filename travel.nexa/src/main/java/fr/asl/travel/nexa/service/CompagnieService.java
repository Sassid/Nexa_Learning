package fr.asl.travel.nexa.service;

import java.util.List;

import fr.asl.travel.nexa.business.Compagnie;

public interface CompagnieService {

	Compagnie ajouterCompagnie(String nom);

	Compagnie recupererCompagnieParId(long id);

	List<Compagnie> recupererToutesCompagnies();

	boolean supprimerCompagnie(long id);

}
