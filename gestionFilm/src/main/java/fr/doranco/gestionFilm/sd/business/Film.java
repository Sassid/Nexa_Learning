package fr.doranco.gestionFilm.sd.business;

public class Film {

	// Attributs
	private Long idFilm;

	private String nomFilm;

	private String realisateur;

	private int anneeDeSortie;

	// Constructeur (par défaut)
	public Film() {

	}

	// Surchage de constructeur
	public Film(String nomFilm, String realisateur, int anneeDeSortie) {
		this();
		this.nomFilm = nomFilm;
		this.realisateur = realisateur;
		this.anneeDeSortie = anneeDeSortie;
	}

	// Getters and Setters (Accesseurs et Mutateurs)
	public String getNomFilm() {
		return nomFilm;
	}

	public void setNomFilm(String nomFilm) {
		this.nomFilm = nomFilm;
	}

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	public int getAnneeDeSortie() {
		return anneeDeSortie;
	}

	public void setAnneeDeSortie(int anneeDeSortie) {
		this.anneeDeSortie = anneeDeSortie;
	}

	public Long getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(Long idFilm) {
		this.idFilm = idFilm;
	}

	// Méthode toString()
	@Override
	public String toString() {
		return "Film [idFilm=" + idFilm + ", nomFilm=" + nomFilm + ", realisateur=" + realisateur + ", anneeDeSortie="
				+ anneeDeSortie + "]";
	}

}
