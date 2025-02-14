package fr.doranco.gestionFilm.sd.dao;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.gestionFilm.sd.business.Image;

public interface ImageDao {

	Image ajouterImage(Image image) throws SQLException;

	Image modifierImage(Image image) throws SQLException;

	boolean supprimerImage(Long id) throws SQLException;

	List<Image> findAllImages() throws SQLException;

}
