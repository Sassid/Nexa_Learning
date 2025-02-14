package fr.asl.travel.nexa.service;

import java.util.List;

import fr.asl.travel.nexa.business.Aeroport;

public interface AeroportService {

	Aeroport ajouterAeroport(String nom);

	Aeroport recupererAeroportParId(long id);

	List<Aeroport> recupererTousLesAeroports();

	Aeroport modifierAeroport(Aeroport aeroport);

}
