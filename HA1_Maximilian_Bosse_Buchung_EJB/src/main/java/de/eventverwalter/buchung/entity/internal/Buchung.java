package de.eventverwalter.buchung.entity.internal;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity(name="Buchung")
@Access(AccessType.FIELD)
@Table(name="HA1_Buchung")
public class Buchung {
	
	@Id
	@SequenceGenerator(name="BUCHUNGNR", sequenceName="BUCHUNG_SEQ", allocationSize=2)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BUCHUNG_SEQ")
	private int buchungNr;
	
	private int userNr;
	private int eventNr;
	private int standortNr;
	private String stand;
	
	public Buchung () {
		
	}

	public Buchung(int eventNr, int standortNr, String stand, int userNr) {
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

	


	
	

}
