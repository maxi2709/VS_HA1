package de.eventverwaltung.event.entity;

import de.eventverwaltung.event.entity.internal.Standort;

public class StandortTO {

private int standortNr;
	
	
	private String standortName;
	
	private int anzahlBuehne;
	
	private int anzahlGetraenkestand;
	
	private int anzahlEssenstand;
	
	private EventTO eventTO;
	
	public StandortTO () {
		
	}

	public StandortTO(String standortName, int anzahlBuehne, int anzahlGetraenkestand, int anzahlEssenstand, EventTO eventTO) {
		super();
		this.standortName = standortName;
		this.anzahlBuehne = anzahlBuehne;
		this.anzahlGetraenkestand = anzahlGetraenkestand;
		this.anzahlEssenstand = anzahlEssenstand;
		this.eventTO = eventTO;
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

	public int getAnzahlBuehne() {
		return anzahlBuehne;
	}

	public void setAnzahlBuehne(int anzahlBuehne) {
		this.anzahlBuehne = anzahlBuehne;
	}

	public int getAnzahlGetraenkestand() {
		return anzahlGetraenkestand;
	}

	public void setAnzahlGetraenkestand(int anzahlGetraenkestand) {
		this.anzahlGetraenkestand = anzahlGetraenkestand;
	}

	public int getAnzahlEssenstand() {
		return anzahlEssenstand;
	}

	public void setAnzahlEssenstand(int anzahlEssenstand) {
		this.anzahlEssenstand = anzahlEssenstand;
	}
	
	public EventTO getEventTO() {
		return eventTO;
	}

	public void setEventTO(EventTO eventTO) {
		this.eventTO = eventTO;
	}

	public Standort toStandort (StandortTO standortTO) {
		Standort standort = new Standort();
		standort.setStandortNr(standortTO.getStandortNr());
		standort.setStandortName(standortTO.getStandortName());
		standort.setAnzahlBuehne(standortTO.getAnzahlBuehne());
		standort.setAnzahlGetraenkestand(standortTO.getAnzahlGetraenkestand());
		standort.setAnzahlEssenstand(standortTO.getAnzahlEssenstand());
		return standort;
		
	}
}
