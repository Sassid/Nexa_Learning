package fr.doranco.gestionFilm.sd.dao;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.gestionFilm.sd.business.Utilisateur;

public interface UtilisateurDao {

	Utilisateur ajouterUtilisateur(Utilisateur utilisateur) throws SQLException;

	Utilisateur modifierUtilisateur(Utilisateur utilisateur) throws SQLException;

	boolean supprimerUtilisateur(Long id) throws SQLException;

	List<Utilisateur> findAllUtilisateurs() throws SQLException;

}
