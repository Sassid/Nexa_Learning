package fr.asl.travel.nexa.dao;

import java.sql.SQLException;
import java.util.List;

import fr.asl.travel.nexa.business.Compagnie;

public interface CompagnieDao {

	Compagnie createCompagnie(Compagnie compagnie) throws SQLException;

	Compagnie findOneCompagnieById(long id) throws SQLException;

	List<Compagnie> findAllCompagnies() throws SQLException;
	
	boolean deleteCompagnie(long id) throws SQLException;

}
