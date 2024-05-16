package de.eventverwaltung.event.entity.Stand;

import de.eventverwaltung.event.entity.standort.internal.Standort;

public class StandTO {

	private int standNr;
	private String standName;
	private Standort standort;


	public StandTO() {
	}


	public int getStandNr() {
		return standNr;
	}

	public void setStandNr(int standNr) {
		this.standNr = standNr;
	}

	public String getStandName() {
		return standName;
	}

	public void setStandName(String standName) {
		this.standName = standName;
	}

	public Standort getStandort() {
		return standort;
	}

	public void setStandort(Standort standort) {
		this.standort = standort;
	}
}
