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
@Table(name="Event")
public class Standort {

	@Id
	@SequenceGenerator(name="EVENTNR", sequenceName="EVENT_SEQ", allocationSize=2)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENT_SEQ")
	private int standortNr;
	
	@Column
	private String standortName;
	@Column
	private int anzahlBuehne;
	@Column
	private int anzahlGetraenkestand;
	@Column
	private int anzahlEssenstand;
	
	public Standort () {
		
	}

	public Standort(String standortName, int anzahlBuehne, int anzahlGetraenkestand, int anzahlEssenstand) {
		super();
		this.standortName = standortName;
		this.anzahlBuehne = anzahlBuehne;
		this.anzahlGetraenkestand = anzahlGetraenkestand;
		this.anzahlEssenstand = anzahlEssenstand;
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
	
	public StandortTO toStandortTO (Standort standort) {
		StandortTO standortTO = new StandortTO();
		standortTO.setStandortNr(standort.getStandortNr());
		standortTO.setStandortName(standortTO.getStandortName());
		standortTO.setAnzahlBuehne(standortTO.getAnzahlBuehne());
		standortTO.setAnzahlGetraenkestand(standortTO.getAnzahlGetraenkestand());
		standortTO.setAnzahlEssenstand(standort.getAnzahlEssenstand());
		return standortTO;
	}
	
	
}
