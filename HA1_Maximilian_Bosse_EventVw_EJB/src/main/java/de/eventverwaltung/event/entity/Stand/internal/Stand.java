package de.eventverwaltung.event.entity.Stand.internal;

import de.eventverwaltung.event.entity.Stand.StandTO;
import de.eventverwaltung.event.entity.standort.internal.Standort;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
@Access(AccessType.FIELD)
public abstract class Stand {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	protected int standNr;

	@Column
	protected String standName;

	@ManyToOne
	protected Standort standort;

	// Allgemeiner Konstruktor und Methoden
	public Stand() {
	}

	public abstract boolean istVerfuegbar();


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
	
	public StandTO toStandTO (Stand stand) {
		StandTO standTO = new StandTO();
		standTO.setStandName(stand.getStandName());
		standTO.setStandNr(stand.getStandNr());
		standTO.setStandort(stand.getStandort());
		return standTO;
		
	}

}
