package de.eventverwaltung.event.entity.Stand.internal;

import de.eventverwaltung.event.entity.standort.internal.Standort;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Access(AccessType.FIELD)
@Table(name = "HA1_Getraenkestand")
public class Getraenkestand extends Stand{

	@Id
	@SequenceGenerator(name = "STAND_G_NR", sequenceName = "STAND_G_SEQ", allocationSize = 2)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STAND_G_SEQ")
	private int standNr;

	@Column
	private String standName;

	@Column
	private int anzahlGetraenkestand_frei;

	@Column
	private int anzahlGetraenkestand_gebucht;

	private int standortNr;

	public Getraenkestand() {

	}

	public Getraenkestand(int standort, int anzahlGetraenkestand_frei) {
		super();
		this.standortNr = standort;
		this.anzahlGetraenkestand_frei = anzahlGetraenkestand_frei;
		this.standName = "Getraenkestand";
	}

	@Override
    public boolean istVerfuegbar() {
		if (this.anzahlGetraenkestand_frei > 0) {
			return true;
		} else {
			return false;
		}
    }
	
	public int getStandNr() {
		return standNr;
	}

	public void setStandNr(int standNr) {
		this.standNr = standNr;
	}

	public Standort getStandort() {
		return standort;
	}

	public void setStandort(Standort standort) {
		this.standort = standort;
	}

	public int getAnzahlGetraenkestand_frei() {
		return anzahlGetraenkestand_frei;
	}

	public void setAnzahlGetraenkestand_frei(int anzahlGetraenkestand_frei) {
		this.anzahlGetraenkestand_frei = anzahlGetraenkestand_frei;
	}

	public int getAnzahlGetraenkestand_gebucht() {
		return anzahlGetraenkestand_gebucht;
	}

	public void setAnzahlGetraenkestand_gebucht(int anzahlGetraenkestand_gebucht) {
		this.anzahlGetraenkestand_gebucht = anzahlGetraenkestand_gebucht;
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
