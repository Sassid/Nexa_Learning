package fr.asl.travel.nexa.business;

public class Aeroport {

	// Attributes
	private long id;
	private String nom;

	// Constructor
	public Aeroport() {
	}

	// Surchage de constructeur
	public Aeroport(String nom) {
		this();
		this.nom = nom;
	}

	// Getters & Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// toString()
	@Override
	public String toString() {
		return "Aeroport [id=" + id + ", nom=" + nom + "]";
	}

}
