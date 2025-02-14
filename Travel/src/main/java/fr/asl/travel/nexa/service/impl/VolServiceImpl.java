package fr.asl.travel.nexa.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import fr.asl.travel.nexa.business.Aeroport;
import fr.asl.travel.nexa.business.Compagnie;
import fr.asl.travel.nexa.business.Vol;
import fr.asl.travel.nexa.dao.VolDao;
import fr.asl.travel.nexa.dao.impl.VolDaoImpl;
import fr.asl.travel.nexa.service.AeroportService;
import fr.asl.travel.nexa.service.CompagnieService;
import fr.asl.travel.nexa.service.VolService;

public class VolServiceImpl implements VolService {

	private VolDao volDao = new VolDaoImpl();

	private AeroportService aeroportService = new AeroportServiceImpl();
	private CompagnieService compagnieService = new CompagnieServiceImpl();

	@Override
	public Vol ajouterVol(LocalDateTime dateHeureDepart, LocalDateTime dateHeureArrivee, float prixEnEuro,
			Aeroport aeroportDepart, Aeroport aeroportArrivee, Compagnie compagnie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vol recupererVolParId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vol> recupererVolsTrieParPrix() {
		// TODO Auto-generated method stub
		return null;
	}

}
