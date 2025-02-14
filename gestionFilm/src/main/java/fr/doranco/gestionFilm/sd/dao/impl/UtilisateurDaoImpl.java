package fr.doranco.gestionFilm.sd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.gestionFilm.sd.business.Utilisateur;
import fr.doranco.gestionFilm.sd.dao.ConnexionBdd;
import fr.doranco.gestionFilm.sd.dao.Requete;
import fr.doranco.gestionFilm.sd.dao.UtilisateurDao;

public class UtilisateurDaoImpl implements UtilisateurDao {

	// Déclaration d'un objet Connection pour interagir avec la base de données
	private Connection connection;

	public UtilisateurDaoImpl() {
		try {
			connection = ConnexionBdd.getConnection(); // Récupération de la connexion à la BDD
		} catch (ClassNotFoundException | SQLException e) {
			// Gestion des exceptions en cas d'échec de connexion à la base de données
			e.printStackTrace(); // Affichage de la pile d'erreur
		}
	}

	@Override
	public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) throws SQLException {
		// Préparation de la requête SQL définie dans la classe Requete.
		// Statement.RETURN_GENERATED_KEYS permet de récupérer les clés générées
		// automatiquement (ex: ID AUTO_INCREMENT).
		PreparedStatement ps = connection.prepareStatement(Requete.AJOUT_UTILISATEUR, Statement.RETURN_GENERATED_KEYS);

		// Attribution de la valeur du nom de l'utilisateur au premier paramètre (index
		// 1)
		// de la requête préparée.
		ps.setString(1, utilisateur.getName());
		ps.setString(2, utilisateur.getPrenom());
		ps.setString(3, utilisateur.getTelephone());
		ps.setString(4, utilisateur.getEmail());
		ps.setString(5, utilisateur.getMotDePasse());
		ps.setTimestamp(6, Timestamp.valueOf(utilisateur.getDateHeureInscription()));

		// Exécution de la requête d'insertion (INSERT INTO) dans la base de données.
		ps.executeUpdate();

		// Récupération des clés générées automatiquement par la base de données après
		// l'insertion.
		ResultSet rs = ps.getGeneratedKeys();

		// Vérification si une clé a été générée et récupération de sa valeur.
		if (rs.next()) {
			utilisateur.setIdUtilisateur(rs.getLong(1)); // On attribue l'ID généré à l'objet Utilisateur.
		}

		// Retourne l'objet Utilisateur mis à jour avec son ID généré.
		return utilisateur;
	}

	@Override
	public Utilisateur modifierUtilisateur(Utilisateur utilisateur) throws SQLException {
		// Préparation de la requête SQL de mise à jour définie dans la classe Requete.
		PreparedStatement ps = connection.prepareStatement(Requete.UPDATE_UTILISATEUR);

		// Attribution de la valeur du champ "name" au premier paramètre de la requête.
		ps.setString(1, utilisateur.getName());

		// Attribution de l'identifiant de l'utilisateur au deuxième paramètre de la
		// requête.
		// Cela permet de cibler précisément l'enregistrement à mettre à jour.
		ps.setLong(2, utilisateur.getIdUtilisateur());

		// Exécution de la requête UPDATE pour appliquer les modifications en base de
		// données.
		ps.executeUpdate();

		// Retourne l'objet Aeroport mis à jour.
		return utilisateur;
	}

	@Override
	public boolean supprimerUtilisateur(Long id) throws SQLException {
		// Préparation de la requête SQL de suppression définie dans la classe Requete.
		PreparedStatement ps = connection.prepareStatement(Requete.SUPPRESSION_UTILISATEUR);

		// Attribution de la valeur de l'ID de l'utilisateur au premier paramètre de la
		// requête.
		// Cet ID permet d'identifier la compagnie à supprimer.
		ps.setLong(1, id);

		// Exécution de la requête de suppression qui retourne un booléen si un
		// ResultSet est présent.
		return ps.execute();
	}

	@Override
	public List<Utilisateur> findAllUtilisateurs() throws SQLException {

		// Préparation de la requête SQL pour récupérer tous les utilisateurs.
		PreparedStatement ps = connection.prepareStatement(Requete.TOUS_LES_UTILISATEURS);

		// Création d'une liste pour stocker les utilisateurs récupérés.
		List<Utilisateur> utilisateurs = new ArrayList<>();

		// Exécution de la requête et récupération des résultats.
		ResultSet rs = ps.executeQuery();

		// Parcours des résultats ligne par ligne.
		while (rs.next()) {
			// Création d'un objet Utilisateur pour chaque ligne.
			Utilisateur utilisateur = new Utilisateur();

			// Récupération et assignation des données.
			utilisateur.setIdUtilisateur(rs.getLong("Id_Utilisateur"));
			utilisateur.setName(rs.getString("nom"));

			// Ajout de l'utilisateur à la liste.
			utilisateurs.add(utilisateur);
		}

		// Retourne la liste des utilisateurs récupérés.
		return utilisateurs;
	}

}
