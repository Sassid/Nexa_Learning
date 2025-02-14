package fr.doranco.gestionFilm.sd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.gestionFilm.sd.business.Film;
import fr.doranco.gestionFilm.sd.dao.ConnexionBdd;
import fr.doranco.gestionFilm.sd.dao.FilmDao;
import fr.doranco.gestionFilm.sd.dao.Requete;

public class FilmDaoImpl implements FilmDao {

	private Connection connection;

	public FilmDaoImpl() {
		try {
			connection = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film ajouterFilm(Film film) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requete.AJOUT_FILM, Statement.RETURN_GENERATED_KEYS);

		ps.setLong(1, film.getIdFilm());
		ps.setString(2, film.getNomFilm());
		ps.setString(3, film.getRealisateur());
		ps.setInt(4, film.getAnneeDeSortie());

		ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			film.setIdFilm(rs.getLong(1));
		}

		return film;
	}

	@Override
	public Film modifierFilm(Film film) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requete.UPDATE_FILM);

		ps.setString(1, film.getNomFilm());
		ps.setLong(2, film.getIdFilm());

		ps.executeUpdate();

		return film;
	}

	@Override
	public boolean supprimerFilm(Long id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requete.SUPPRESSION_FILM);

		ps.setLong(1, id);

		return ps.execute();
	}

	@Override
	public List<Film> findAllFilms() throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requete.TOUS_LES_FILMS);

		List<Film> films = new ArrayList<>();

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Film film = new Film();

			film.setIdFilm(rs.getLong("Id_Film"));
			film.setNomFilm(rs.getString("nom"));
			film.setRealisateur(rs.getString("realisateur"));
			film.setAnneeDeSortie(rs.getInt("anneeDeSortie"));

			films.add(film);
		}

		return films;
	}

}