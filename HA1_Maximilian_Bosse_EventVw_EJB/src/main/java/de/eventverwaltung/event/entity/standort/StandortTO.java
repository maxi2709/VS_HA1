package de.eventverwaltung.event.entity.standort;

import java.io.Serializable;

import de.eventverwaltung.event.entity.standort.internal.Standort;

public class StandortTO implements Serializable {

	private static final long serialVersionUID = 7149460250521152834L;

	private int standortNr;

	private String standortName;

	private int anzahlBuehne_gebucht;

	private int anzahlGetraenkestand_gebucht;

	private int anzahlEssenstand_gebucht;

	private int anzahlBuehne_frei;

	private int anzahlGetraenkestand_frei;

	private int anzahlEssenstand_frei;

	private int eventNr;

	public StandortTO() {

	}

	public StandortTO(String standortName, int anzahlBuehne_gebucht, int anzahlGetraenkestand_gebucht,
			int anzahlEssenstand_gebucht, int anzahlBuehne_frei, int anzahlGetraenkestand_frei,
			int anzahlEssenstand_frei, int eventNr) {
		super();
		this.standortName = standortName;
		this.anzahlBuehne_gebucht = anzahlBuehne_gebucht;
		this.anzahlGetraenkestand_gebucht = anzahlGetraenkestand_gebucht;
		this.anzahlEssenstand_gebucht = anzahlEssenstand_gebucht;
		this.anzahlBuehne_frei = anzahlBuehne_frei;
		this.anzahlGetraenkestand_frei = anzahlGetraenkestand_frei;
		this.anzahlEssenstand_frei = anzahlEssenstand_frei;
		this.eventNr = eventNr;
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

	public int getAnzahlBuehne_gebucht() {
		return anzahlBuehne_gebucht;
	}

	public void setAnzahlBuehne_gebucht(int anzahlBuehne_gebucht) {
		this.anzahlBuehne_gebucht = anzahlBuehne_gebucht;
	}

	public int getAnzahlGetraenkestand_gebucht() {
		return anzahlGetraenkestand_gebucht;
	}

	public void setAnzahlGetraenkestand_gebucht(int anzahlGetraenkestand_gebucht) {
		this.anzahlGetraenkestand_gebucht = anzahlGetraenkestand_gebucht;
	}

	public int getAnzahlEssenstand_gebucht() {
		return anzahlEssenstand_gebucht;
	}

	public void setAnzahlEssenstand_gebucht(int anzahlEssenstand_gebucht) {
		this.anzahlEssenstand_gebucht = anzahlEssenstand_gebucht;
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

	public int getAnzahlEssenstand_frei() {
		return anzahlEssenstand_frei;
	}

	public void setAnzahlEssenstand_frei(int anzahlEssenstand_frei) {
		this.anzahlEssenstand_frei = anzahlEssenstand_frei;
	}

	public int getEventNr() {
		return eventNr;
	}

	public void setEventNr(int eventNr) {
		this.eventNr = eventNr;
	}

	public Standort toStandort(StandortTO standortTO) {
		Standort standort = new Standort();
		standort.setStandortNr(standortTO.getStandortNr());
		standort.setStandortName(standortTO.getStandortName());
		standort.setAnzahlBuehne_frei(standortTO.getAnzahlBuehne_frei());
		standort.setAnzahlBuehne_gebucht(standortTO.getAnzahlBuehne_gebucht());
		standort.setAnzahlEssenstand_frei(standortTO.getAnzahlEssenstand_frei());
		standort.setAnzahlEssenstand_gebucht(standortTO.getAnzahlEssenstand_gebucht());
		standort.setAnzahlGetraenkestand_frei(standortTO.getAnzahlGetraenkestand_frei());
		standort.setAnzahlGetraenkestand_gebucht(standortTO.getAnzahlGetraenkestand_gebucht());
		standort.setEventNr(standortTO.getEventNr());
		return standort;

	}
}
