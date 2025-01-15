package fr.nexa.banque.entity;

public class Compte {

	private Integer id;
	private String titre;
	private Float solde;
	private Float taux;

	public Compte(String titre, float solde, float taux) {
		super();
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

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}

}
