package fr.asl.travel.nexa.business;

import java.util.ArrayList;
import java.util.List;

public class Compagnie {
	private long id;
	private String nom;
	private List<Vol> vols;
	
	//constructeur par défaut (ce que fait l'application sans intervention des utilisateurs)
	public Compagnie() {
		vols = new ArrayList<>();
	}

	//surcharge du constructeur (paramètres attendus auprès de l'utilisateur pour que l'objet soit créé)
	public Compagnie(String nom) {
		this();
		this.nom = nom;
	}

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

	public List<Vol> getVols() {
		return vols;
	}

	public void setVols(List<Vol> vols) {
		this.vols = vols;
	}

	@Override
	public String toString() {
		return "Compagnie [id=" + id + ", nom=" + nom + ", vols=" + vols + "]";
	}
	
	
}
