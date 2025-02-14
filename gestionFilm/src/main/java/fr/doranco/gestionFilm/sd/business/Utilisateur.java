package fr.doranco.gestionFilm.sd.business;

import java.time.LocalDateTime;

public class Utilisateur {

	// Attributs
	private Long idUtilisateur;

	private String name;

	private String prenom;

	private String telephone;

	private String email;

	private String motDePasse;

	private LocalDateTime dateHeureInscription;

	// Constructeur par défaut
	public Utilisateur() {

	}

	// Surchage de constructeur
	public Utilisateur(String name, String prenom, String telephone, String email, String motDePasse,
			LocalDateTime dateHeureInscription) {
		this(); // appelle le constructeur par défaut avant le présent
		this.name = name;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.motDePasse = motDePasse;
		this.dateHeureInscription = dateHeureInscription;
	}

	// Getters and Setters (Accesseurs et Mutateurs)
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public LocalDateTime getDateHeureInscription() {
		return dateHeureInscription;
	}

	public void setDateHeureInscription(LocalDateTime dateHeureInscription) {
		this.dateHeureInscription = dateHeureInscription;
	}

	// Méthode toString()
	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", name=" + name + ", prenom=" + prenom + ", telephone="
				+ telephone + ", email=" + email + ", motDePasse=" + motDePasse + ", dateHeureInscription="
				+ dateHeureInscription + "]";
	}

}
