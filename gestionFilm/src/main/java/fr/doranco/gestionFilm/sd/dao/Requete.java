package fr.doranco.gestionFilm.sd.dao;

public class Requete {

	public static final String AJOUT_UTILISATEUR = "INSERT INTO Utilisateur (Id_Utilisateur, nom, prenom, telephone, email, motDePasse, DateHeureInscription) VALUES (?,?,?,?,?,?,?)";
	public static final String TOUS_LES_UTILISATEURS = "SELECT Id_Utilisateur, nom FROM Utilisateur";
	public static final String UPDATE_UTILISATEUR = "UPDATE Utilisateur SET nom = ? WHERE id = ?";
	public static final String SUPPRESSION_UTILISATEUR = "DELETE FROM Utilisateur WHERE id = ?";

	public static final String AJOUT_FILM = "INSERT INTO Film (Id_Film, nom, realisateur, anneeDeSortie) VALUES (?,?,?,?)";
	public static final String TOUS_LES_FILMS = "SELECT Id_Film, nom FROM Film";
	public static final String UPDATE_FILM = "UPDATE Film SET nom = ? WHERE id = ?";
	public static final String SUPPRESSION_FILM = "DELETE FROM Film WHERE id = ?";
	
	public static final String AJOUT_IMAGE = "INSERT INTO Image (Id_Image, url, Id_Film) VALUES (?,?,?)";
	public static final String TOUTES_LES_IMAGES = "SELECT Id_Image, nom FROM Image";
	public static final String UPDATE_IMAGE = "UPDATE Image SET nom = ? WHERE id = ?";
	public static final String SUPPRESSION_IMAGE = "DELETE FROM Image WHERE id = ?";
	
	




}
