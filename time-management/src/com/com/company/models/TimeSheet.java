package com.company.models;

import java.time.LocalDateTime;

public class TimeSheet {

	private String refTemps;
	private LocalDateTime date;
	private String refContrat;
	private Double quantite;
	private String codeHeure;
	private String refPrestation;
	private String refRessource;
	private String titreProjet;

	public TimeSheet(String refTemps, LocalDateTime date, String refContrat, Double quantite, String codeHeure,
			String refPrestation, String refRessource, String titreProjet) {
		super();
		this.refTemps = refTemps;
		this.date = date;
		this.refContrat = refContrat;
		this.quantite = quantite;
		this.codeHeure = codeHeure;
		this.refPrestation = refPrestation;
		this.refRessource = refRessource;
		this.titreProjet = titreProjet;
	}

	@Override
	public String toString() {
		return "TimeSheet [refTemps=" + refTemps + ", date=" + date + ", refContrat=" + refContrat + ", quantite="
				+ quantite + ", codeHeure=" + codeHeure + ", refPrestation=" + refPrestation + ", refRessource="
				+ refRessource + ", titreProjet=" + titreProjet + "]";
	}

	public String getRefTemps() {
		return refTemps;
	}

	public void setRefTemps(String refTemps) {
		this.refTemps = refTemps;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getRefContrat() {
		return refContrat;
	}

	public void setRefContrat(String refContrat) {
		this.refContrat = refContrat;
	}

	public Double getQuantite() {
		return quantite;
	}

	public void setQuantite(Double quantite) {
		this.quantite = quantite;
	}

	public String getCodeHeure() {
		return codeHeure;
	}

	public void setCodeHeure(String codeHeure) {
		this.codeHeure = codeHeure;
	}

	public String getRefPrestation() {
		return refPrestation;
	}

	public void setRefPrestation(String refPrestation) {
		this.refPrestation = refPrestation;
	}

	public String getRefRessource() {
		return refRessource;
	}

	public void setRefRessource(String refRessource) {
		this.refRessource = refRessource;
	}

	public String getTitreProjet() {
		return titreProjet;
	}

	public void setTitreProjet(String titreProjet) {
		this.titreProjet = titreProjet;
	}

}
