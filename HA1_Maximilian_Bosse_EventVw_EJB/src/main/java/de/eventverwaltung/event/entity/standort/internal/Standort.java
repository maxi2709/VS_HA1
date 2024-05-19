package de.eventverwaltung.event.entity.standort.internal;

import de.eventverwaltung.event.entity.standort.StandortTO;
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
@Table(name = "HA1_Standort")
public class Standort {

	@Id
	@SequenceGenerator(name = "STANDORTNR", sequenceName = "STANDORT_SEQ", allocationSize = 2)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STANDORT_SEQ")
	private int standortNr;

	@Column
	private String standortName;
	@Column
	private int eventNr;

	@Column
	private int anzahlBuehne_frei;
	@Column
	private int anzahlBuehne_gebucht;
	@Column
	private int anzahlGetraenkestand_frei;
	@Column
	private int anzahlGetraenkestand_gebucht;
	@Column
	private int anzahlEssenstand_frei;
	@Column
	private int anzahlEssenstand_gebucht;

	public Standort() {

	}

	public Standort(String standortName, int eventNr, int anzahlBuehne_frei, int anzahlBuehne_gebucht,
			int anzahlGetraenkestand_frei, int anzahlGetraenkestand_gebucht, int anzahlEssenstand_frei,
			int anzahlEssenstand_gebucht) {
		super();
		this.standortName = standortName;
		this.eventNr = eventNr;
		this.anzahlBuehne_frei = anzahlBuehne_frei;
		this.anzahlBuehne_gebucht = anzahlBuehne_gebucht;
		this.anzahlGetraenkestand_frei = anzahlGetraenkestand_frei;
		this.anzahlGetraenkestand_gebucht = anzahlGetraenkestand_gebucht;
		this.anzahlEssenstand_frei = anzahlEssenstand_frei;
		this.anzahlEssenstand_gebucht = anzahlEssenstand_gebucht;
	}



	public int getStandortNr() {
		return standortNr;
	}

	public void setStandortNr(int standortNr) {
		this.standortNr = standortNr;
	}

	public String getStandortName() {
		return standortName;
	}

	public void setStandortName(String standortName) {
		this.standortName = standortName;
	}

	public int getEventNr() {
		return eventNr;
	}

	public void setEventNr(int eventNr) {
		this.eventNr = eventNr;
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

	public StandortTO toStandortTO() {
		StandortTO standortTO = new StandortTO();
		standortTO.setStandortNr(this.getStandortNr());
		standortTO.setStandortName(this.getStandortName());
		standortTO.setAnzahlBuehne_frei(this.getAnzahlBuehne_frei());
		standortTO.setAnzahlBuehne_gebucht(this.getAnzahlBuehne_gebucht());
		standortTO.setAnzahlEssenstand_frei(this.getAnzahlEssenstand_frei());
		standortTO.setAnzahlEssenstand_gebucht(this.getAnzahlEssenstand_gebucht());
		standortTO.setAnzahlGetraenkestand_frei(this.getAnzahlGetraenkestand_frei());
		standortTO.setAnzahlGetraenkestand_gebucht(this.getAnzahlGetraenkestand_gebucht());
		standortTO.setEventNr(this.getEventNr());
		return standortTO;
	}

}
