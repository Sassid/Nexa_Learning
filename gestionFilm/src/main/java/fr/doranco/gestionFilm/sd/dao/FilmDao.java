package fr.doranco.gestionFilm.sd.dao;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.gestionFilm.sd.business.Film;

public interface FilmDao {

	Film ajouterFilm(Film film) throws SQLException;

	Film modifierFilm(Film film) throws SQLException;

	boolean supprimerFilm(Long id) throws SQLException;

	List<Film> findAllFilms() throws SQLException;

}
