package fr.asl.travel.nexa.service;

import java.time.LocalDateTime;
import java.util.List;

import fr.asl.travel.nexa.business.Aeroport;
import fr.asl.travel.nexa.business.Compagnie;
import fr.asl.travel.nexa.business.Vol;

public interface VolService {

	Vol ajouterVol(LocalDateTime dateHeureDepart, LocalDateTime dateHeureArrivee, float prixEnEuro,
			Aeroport aeroportDepart, Aeroport aeroportArrivee, Compagnie compagnie);

	Vol recupererVolParId(long id);

	List<Vol> recupererVolsTrieParPrix();

}
