package fr.doranco.gestionFilm.sd.service;

import java.util.List;

import fr.doranco.gestionFilm.sd.business.Film;

public interface FilmService {

	Film addUser(String nom, String realisateur, int anneeDeSortie);

	List<Film> collectAllFilms();

	boolean deleteFilm(Long id);

	Film editFilm(Film film);

}
