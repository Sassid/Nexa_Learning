package fr.doranco.gestionFilm.sd.service;

import java.time.LocalDateTime;
import java.util.List;

import fr.doranco.gestionFilm.sd.business.Utilisateur;

public interface UtilisateurService {

	Utilisateur addUser(String name, String prenom, String telephone, String email, String motDePasse,
			LocalDateTime dateHeureInscription);

	List<Utilisateur> collectAllUsers();

	boolean deleteUser(Long id);

	Utilisateur editUser(Utilisateur utilisateur);

}
