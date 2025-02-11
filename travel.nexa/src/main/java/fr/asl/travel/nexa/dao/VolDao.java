package fr.asl.travel.nexa.dao;

import java.sql.SQLException;
import java.util.List;

import fr.asl.travel.nexa.business.Vol;

public interface VolDao {
	
	Vol createFlight(Vol vol) throws SQLException;
	
	Vol findFlightById(long id) throws SQLException;
	
	List<Vol> findAllFlightsOrderByPrice() throws SQLException;
	

}
