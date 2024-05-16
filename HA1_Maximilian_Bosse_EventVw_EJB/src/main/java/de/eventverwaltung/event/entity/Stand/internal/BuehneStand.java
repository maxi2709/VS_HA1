package de.eventverwaltung.event.entity.Stand.internal;

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
@Table(name = "HA1_BuehneStand")
public class BuehneStand extends Stand {

	@Id
	@SequenceGenerator(name = "STAND_B_NR", sequenceName = "STAND_B_SEQ", allocationSize = 2)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STAND_B_SEQ")
	private int standNr;

	@Column
	private String standName;

	@Column
	private int anzahlBuehne_gebucht;

	@Column
	private int anzahlBuehne_frei;

	@Column
	private int standortNr;

	public BuehneStand() {
		super();
	}

	public BuehneStand(int standort, int anzahlBuehne_frei) {
		this.standortNr = standort;
		this.anzahlBuehne_frei = anzahlBuehne_frei;
		this.standName = "Buehne";
	}

	@Override
	public boolean istVerfuegbar() {
		if (this.anzahlBuehne_frei > 0) {
			return true;
		}
		return false;
	}

	public int getStandortNr() {
		return standortNr;
	}

	public void setStandortNr(int standortNr) {
		this.standortNr = standortNr;
	}

	public int getAnzahlBuehne_gebucht() {
		return anzahlBuehne_gebucht;
	}

	public void setAnzahlBuehne_gebucht(int anzahlBuehne_gebucht) {
		this.anzahlBuehne_gebucht = anzahlBuehne_gebucht;
	}

	public int getAnzahlBuehne_frei() {
		return anzahlBuehne_frei;
	}

	public void setAnzahlBuehne_frei(int anzahlBuehne_frei) {
		this.anzahlBuehne_frei = anzahlBuehne_frei;
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

}
