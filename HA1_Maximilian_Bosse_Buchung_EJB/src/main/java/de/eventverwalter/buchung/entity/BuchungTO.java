package de.eventverwalter.buchung.entity;

import de.eventverwalter.buchung.entity.internal.Buchung;

public class BuchungTO {

	private int buchungNr;

	private int userNr;
	private int eventNr;
	private int standortNr;
	private String stand;

	public BuchungTO() {

	}

	public BuchungTO(int eventNr, int standortNr, String stand, int userNr) {
		super();
		this.userNr = userNr;
		this.eventNr = eventNr;
		this.standortNr = standortNr;
		this.stand = stand;
	}

	public int getBuchungNr() {
		return buchungNr;
	}

	public void setBuchungNr(int buchungNr) {
		this.buchungNr = buchungNr;
	}

	public int getUserNr() {
		return userNr;
	}

	public void setUserNr(int userNr) {
		this.userNr = userNr;
	}

	public int getEventNr() {
		return eventNr;
	}

	public void setEventNr(int eventNr) {
		this.eventNr = eventNr;
	}

	public int getStandortNr() {
		return standortNr;
	}

	public void setStandortNr(int standortNr) {
		this.standortNr = standortNr;
	}

	public String getStand() {
		return stand;
	}

	public void setStand(String stand) {
		this.stand = stand;
	}

	public Buchung toBuchung(BuchungTO buchungTO) {
		Buchung buchung = new Buchung();
		buchung.setBuchungNr(buchungTO.getBuchungNr());
		buchung.setEventNr(buchungTO.getEventNr());
		buchung.setStandortNr(buchungTO.getStandortNr());
		buchung.setStand(buchungTO.getStand());
		buchung.setUserNr(buchungTO.getUserNr());
		return buchung;
	}

}
