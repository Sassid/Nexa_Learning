package fr.doranco.gestionFilm.sd.business;

public class Image {

	// Attributs
	private Long idImage;

	private String url;

	// Constructeur (par défaut)
	public Image() {
		super();
	}

	// Surchage de constructeur
	public Image(String url) {
		this();
		this.url = url;
	}

	// Getters and Setters (Accesseurs et Mutateurs)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getIdImage() {
		return idImage;
	}

	public void setIdImage(Long idImage) {
		this.idImage = idImage;
	}

	// Méthode toString()
	@Override
	public String toString() {
		return "Image [idImage=" + idImage + ", url=" + url + "]";
	}

}
