package fr.asl.travel.nexa.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import fr.asl.travel.nexa.business.Aeroport;
import fr.asl.travel.nexa.dao.AeroportDao;
import fr.asl.travel.nexa.dao.impl.AeroportDaoImpl;
import fr.asl.travel.nexa.service.AeroportService;

public class AeroportServiceImpl implements AeroportService {

	private AeroportDao aeroportDao = new AeroportDaoImpl();

	@Override
	public Aeroport ajouterAeroport(String nom) {

		Aeroport aeroport = new Aeroport(nom);

		try {
			aeroportDao.createAeroport(aeroport);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return aeroport;
	}

	@Override
	public Aeroport recupererAeroportParId(long id) {
		try {
			return aeroportDao.findOneById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Aeroport> recupererTousLesAeroports() {
		try {
			return aeroportDao.findAllAeroports();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@Override
	public Aeroport modifierAeroport(Aeroport aeroport) {
		try {
			return aeroportDao.updateAeroport(aeroport);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aeroport;
	}

}