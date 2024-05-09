package de.eventverwaltung.event.entity.internal;


import java.util.Date;

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
public class Event {

	@Id
	@SequenceGenerator(name="EVENTNR", sequenceName="EVENT_SEQ", allocationSize=2)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENT_SEQ")
	private int eventNr;
	
	@Column
	private String eventName;
	@Column
	private Date eventDatum;
	@Column
	private Date anmeldeStartDatum;
	@Column
	private Date anmeldeEndeDatum;
	
	public Event() {	
	}
	
	public Event (String bezeichnung, Date datum, Date anmeldungStart, Date anmeldungEnde) {
		this.eventName = bezeichnung;
		this.eventDatum = datum;
		this.anmeldeStartDatum = anmeldungStart;
		this.anmeldeEndeDatum = anmeldungEnde;
	}

	public int getEventNr() {
		return eventNr;
	}

	public void setEventNr(int eventNr) {
		this.eventNr = eventNr;
	}

	public String getBezeichnung() {
		return eventName;
	}

	public void setBezeichnung(String bezeichnung) {
		this.eventName = bezeichnung;
	}

	public Date getDatum() {
		return eventDatum;
	}

	public void setDatum(Date datum) {
		this.eventDatum = datum;
	}

	public Date getAnmeldungStart() {
		return anmeldeStartDatum;
	}

	public void setAnmeldungStart(Date anmeldungStart) {
		this.anmeldeStartDatum = anmeldungStart;
	}

	public Date getAnmeldungEnde() {
		return anmeldeEndeDatum;
	}

	public void setAnmeldungEnde(Date anmeldungEnde) {
		this.anmeldeEndeDatum = anmeldungEnde;
	}

}