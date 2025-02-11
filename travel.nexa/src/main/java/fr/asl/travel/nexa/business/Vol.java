package fr.asl.travel.nexa.business;

import java.time.LocalDateTime;

public class Vol {

	private long id;
	private LocalDateTime dateHeureDepart;
	private LocalDateTime dateHeureArrivee;
	private float prixEnEuro;

	private Aeroport aeroportDepart;
	private Aeroport aeroportArrivee;

	private Compagnie compagnie;

	public Vol() {

	}

	public Vol(LocalDateTime dateHeureDepart, LocalDateTime dateHeureArrivee, float prixEnEuro, Aeroport aeroportDepart,
			Aeroport aeroportArrivee, Compagnie compagnie) {
		this();
		this.dateHeureDepart = dateHeureDepart;
		this.dateHeureArrivee = dateHeureArrivee;
		this.prixEnEuro = prixEnEuro;
		this.aeroportDepart = aeroportDepart;
		this.aeroportArrivee = aeroportArrivee;
		this.compagnie = compagnie;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDateHeureDepart() {
		return dateHeureDepart;
	}

	public void setDateHeureDepart(LocalDateTime dateHeureDepart) {
		this.dateHeureDepart = dateHeureDepart;
	}

	public LocalDateTime getDateHeureArrivee() {
		return dateHeureArrivee;
	}

	public void setDateHeureArrivee(LocalDateTime dateHeureArrivee) {
		this.dateHeureArrivee = dateHeureArrivee;
	}

	public float getPrixEnEuro() {
		return prixEnEuro;
	}

	public void setPrixEnEuro(float prixEnEuro) {
		this.prixEnEuro = prixEnEuro;
	}

	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}

	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}

	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}

	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}

	public Compagnie getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(Compagnie compagnie) {
		this.compagnie = compagnie;
	}

	@Override
	public String toString() {
		return "Vol [id=" + id + ", dateHeureDepart=" + dateHeureDepart + ", dateHeureArrivee=" + dateHeureArrivee
				+ ", prixEnEuro=" + prixEnEuro + ", aeroportDepart=" + aeroportDepart + ", aeroportArrivee="
				+ aeroportArrivee + ", compagnie=" + compagnie + "]";
	}

}
