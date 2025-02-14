package fr.doranco.gestionFilm.sd.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import fr.doranco.gestionFilm.sd.business.Film;
import fr.doranco.gestionFilm.sd.dao.FilmDao;
import fr.doranco.gestionFilm.sd.dao.impl.FilmDaoImpl;
import fr.doranco.gestionFilm.sd.service.FilmService;

public class FilmServiceImpl implements FilmService {

	private FilmDao filmDao = new FilmDaoImpl();

	@Override
	public Film addUser(String nom, String realisateur, int anneeDeSortie) {
		Film film = new Film(nom, realisateur, anneeDeSortie);
		try {
			filmDao.ajouterFilm(film);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public List<Film> collectAllFilms() {
		try {
			filmDao.findAllFilms();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();

	}

	@Override
	public boolean deleteFilm(Long id) {
		try {
			filmDao.supprimerFilm(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Film editFilm(Film film) {
		try {
			filmDao.modifierFilm(film);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

}
