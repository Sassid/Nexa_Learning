package fr.doranco.gestionFilm.sd.service.impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import fr.doranco.gestionFilm.sd.business.Utilisateur;
import fr.doranco.gestionFilm.sd.dao.UtilisateurDao;
import fr.doranco.gestionFilm.sd.dao.impl.UtilisateurDaoImpl;
import fr.doranco.gestionFilm.sd.service.UtilisateurService;

public class UtilisateurServiceImpl implements UtilisateurService {

	private UtilisateurDao utilisateurDao = new UtilisateurDaoImpl();

	@Override
	public Utilisateur addUser(String name, String prenom, String telephone, String email, String motDePasse,
			LocalDateTime dateHeureInscription) {
		Utilisateur utilisateur = new Utilisateur(name, prenom, telephone, email, motDePasse, dateHeureInscription);

		try {
			utilisateurDao.ajouterUtilisateur(utilisateur);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return utilisateur;

	}

	@Override
	public List<Utilisateur> collectAllUsers() {
		try {
			utilisateurDao.findAllUtilisateurs();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@Override
	public boolean deleteUser(Long id) {
		try {
			utilisateurDao.supprimerUtilisateur(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Utilisateur editUser(Utilisateur utilisateur) {
		try {
			utilisateurDao.modifierUtilisateur(utilisateur);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return utilisateur;
	}

}
