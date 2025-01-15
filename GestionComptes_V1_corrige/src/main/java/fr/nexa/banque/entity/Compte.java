package fr.nexa.banque.entity;

public class Compte {

	private Integer id;
	private String titre;
	private Float solde;
	private Float taux;

	public Compte() {
	}

	public Compte(String titre, Float solde, Float taux) {
		this.titre = titre;
		this.solde = solde;
		this.taux = taux;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Float getSolde() {
		return solde;
	}

	public void setSolde(Float solde) {
		this.solde = solde;
	}

	public Float getTaux() {
		return taux;
	}

	public void setTaux(Float taux) {
		this.taux = taux;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", titre=" + titre + ", solde=" + solde + ", taux=" + taux + "]";
	}

}
