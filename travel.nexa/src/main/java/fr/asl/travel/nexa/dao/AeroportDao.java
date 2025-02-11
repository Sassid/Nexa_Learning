package fr.asl.travel.nexa.dao;

import java.sql.SQLException;
import java.util.List;

import fr.asl.travel.nexa.business.Aeroport;

public interface AeroportDao {
	
	Aeroport createAeroport(Aeroport aeroport) throws SQLException;

	Aeroport findOneById(long id) throws SQLException;

	List<Aeroport> findAllAeroports() throws SQLException;

	Aeroport updateAeroport(Aeroport aeroport) throws SQLException;

}
