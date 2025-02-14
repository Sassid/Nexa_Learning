package fr.asl.travel.nexa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.asl.travel.nexa.business.Aeroport;
import fr.asl.travel.nexa.dao.AeroportDao;
import fr.asl.travel.nexa.dao.ConnexionBdd;
import fr.asl.travel.nexa.dao.Requete;

public class AeroportDaoImpl implements AeroportDao {

	private Connection connection;

	public AeroportDaoImpl() {
		try {
			connection = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Aeroport createAeroport(Aeroport aeroport) throws SQLException {

		PreparedStatement ps = connection.prepareStatement(Requete.AJOUT_AEROPORT, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, aeroport.getNom());
		ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			aeroport.setId(rs.getLong(1));
		}

		return aeroport;
	}

	@Override
	public Aeroport findOneById(long id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requete.AEROPORT_PAR_ID);
		ps.setLong(1, id);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Aeroport aeroport = new Aeroport();
			aeroport.setId(rs.getLong("id"));
			aeroport.setNom(rs.getString("nom"));
			return aeroport;
		}

		return null;
	}

	@Override
	public List<Aeroport> findAllAeroports() throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requete.TOUS_LES_AEROPORTS);
		List<Aeroport> aeroports = new ArrayList<>();

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Aeroport aeroport = new Aeroport();
			aeroport.setId(rs.getLong("id"));
			aeroport.setNom(rs.getString("nom"));
			aeroports.add(aeroport);
		}
		return aeroports;
	}

	@Override
	public Aeroport updateAeroport(Aeroport aeroport) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requete.UPDATE_AEROPORT);
		ps.setLong(2, aeroport.getId());
		ps.setString(1, aeroport.getNom());
		ps.executeUpdate();

		return aeroport;
	}

}
