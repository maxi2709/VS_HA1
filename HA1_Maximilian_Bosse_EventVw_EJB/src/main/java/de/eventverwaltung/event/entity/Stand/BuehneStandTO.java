package de.eventverwaltung.event.entity.Stand;

import de.eventverwaltung.event.entity.standort.internal.Standort;

public class BuehneStandTO {

	private Standort standort;
	

	private int anzahlBuehne_gebucht;

	private int anzahlGetraenkestand_gebucht;

	private int anzahlEssenstand_gebucht;

	private int anzahlBuehne_frei;

	private int anzahlGetraenkestand_frei;

	private int anzahlEssenstand_frei;

	
	private final String buehne = "Buehne";
	private final String getraenkestand = "Getraenkestand";
	private final String essenstand = "Essenstand";
	
	public BuehneStandTO () {
		
	}

	public BuehneStandTO (Standort standort, int anzahlBuehne_frei, int anzahlGetraenkestand_frei, int anzahlEssenstand_frei) {
		super();
		this.standort = standort;
		this.anzahlBuehne_frei = anzahlBuehne_frei;
		this.anzahlGetraenkestand_frei = anzahlGetraenkestand_frei;
		this.anzahlEssenstand_frei = anzahlEssenstand_frei;
	}

	public Standort getStandort() {
		return standort;
	}

	public void setStandort(Standort standort) {
		this.standort = standort;
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

	public String getBuehne() {
		return buehne;
	}

	public String getGetraenkestand() {
		return getraenkestand;
	}

	public String getEssenstand() {
		return essenstand;
	}
	

}
