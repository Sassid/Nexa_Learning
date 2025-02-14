package fr.doranco.gestionFilm.sd.service;

import java.util.List;

import fr.doranco.gestionFilm.sd.business.Image;

public interface ImageService {

	Image addUser(String nom);

	List<Image> collectAllImages();

	boolean deleteImage(Long id);

	Image editImage(Image image);
}
