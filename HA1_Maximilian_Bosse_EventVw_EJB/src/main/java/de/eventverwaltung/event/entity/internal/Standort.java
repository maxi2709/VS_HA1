package de.eventverwaltung.event.entity.internal;

import de.eventverwaltung.event.entity.StandortTO;
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
@Table(name="Standort")
public class Standort {

	@Id
	@SequenceGenerator(name="STANDORTNR", sequenceName="STANDORT_SEQ", allocationSize=2)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STANDORT_SEQ")
	private int standortNr;
	
	@Column
	private String standortName;
	@Column
	private int anzahlBuehne;
	@Column
	private int anzahlGetraenkestand;
	@Column
	private int anzahlEssenstand;
		
	private int eventNr;
	
	public Standort () {
		
	}

	public Standort(String standortName, int anzahlBuehne, int anzahlGetraenkestand, int anzahlEssenstand, int eventNr) {
		super();
		this.standortName = standortName;
		this.anzahlBuehne = anzahlBuehne;
		this.anzahlGetraenkestand = anzahlGetraenkestand;
		this.anzahlEssenstand = anzahlEssenstand;
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

	public int getEventNr() {
		return eventNr;
	}

	public void setEventNr(int eventNr) {
		this.eventNr = eventNr;
	}

	public StandortTO toStandortTO() {
	    StandortTO standortTO = new StandortTO();
	    standortTO.setStandortNr(this.getStandortNr());
	    standortTO.setStandortName(this.getStandortName());
	    standortTO.setAnzahlBuehne(this.getAnzahlBuehne());
	    standortTO.setAnzahlGetraenkestand(this.getAnzahlGetraenkestand());
	    standortTO.setAnzahlEssenstand(this.getAnzahlEssenstand());
	    
	    return standortTO;
	}
	
	
}
