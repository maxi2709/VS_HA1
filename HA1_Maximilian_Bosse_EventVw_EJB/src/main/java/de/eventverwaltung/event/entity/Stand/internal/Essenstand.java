package de.eventverwaltung.event.entity.Stand.internal;

import de.eventverwaltung.event.entity.standort.internal.Standort;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Access(AccessType.FIELD)
@Table(name = "HA1_Essenstand")
public class Essenstand extends Stand {

	@Id
	@SequenceGenerator(name = "STAND_E_NR", sequenceName = "STAND_E_SEQ", allocationSize = 2)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STAND_E_SEQ")
	private int standNr;

	@Column
	private String standName;

	@Column
	private int anzahlEssenstand_frei;

	@Column
	private int anzahlEssenstand_gebucht;

	private int standortNr;

	public Essenstand() {
		super();
	}

	public Essenstand(int standort, int anzahlEssenstand_frei) {
		super();
		this.standName = "Essenstand";
		this.anzahlEssenstand_frei = anzahlEssenstand_frei;
		this.standortNr = standort;
	}

	@Override
	public boolean istVerfuegbar() {
		if (this.anzahlEssenstand_frei > 0) {
			return true;
		}
		return false;
	}

	public int getStandNr() {
		return standNr;
	}

	public void setStandNr(int standNr) {
		this.standNr = standNr;
	}

	public int getAnzahlEssenstand_frei() {
		return anzahlEssenstand_frei;
	}

	public void setAnzahlEssenstand_frei(int anzahlEssenstand_frei) {
		this.anzahlEssenstand_frei = anzahlEssenstand_frei;
	}

	public int getAnzahlEssenstand_gebucht() {
		return anzahlEssenstand_gebucht;
	}

	public void setAnzahlEssenstand_gebucht(int anzahlEssenstand_gebucht) {
		this.anzahlEssenstand_gebucht = anzahlEssenstand_gebucht;
	}

	public String getStandName() {
		return standName;
	}

	public void setStandName(String standName) {
		this.standName = standName;
	}

	public int getStandortNr() {
		return standortNr;
	}

	public void setStandortNr(int standortNr) {
		this.standortNr = standortNr;
	}
	
	

}
