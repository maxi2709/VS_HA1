package de.eventverwaltung.event.entity.internal;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.eventverwaltung.event.entity.EventTO;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="eventNr")
	List<Standort> standorte; 
	
	
	public Event() {
		this.standorte = new ArrayList<>();
	}
	
	public Event (String bezeichnung, Date datum, Date anmeldungStart, Date anmeldungEnde) {
		this.eventName = bezeichnung;
		this.eventDatum = datum;
		this.anmeldeStartDatum = anmeldungStart;
		this.anmeldeEndeDatum = anmeldungEnde;
		this.standorte = new ArrayList<>();
	}
	
	public EventTO toEventTO (Event event) {
		EventTO eventTO = new EventTO();
		eventTO.setEventNr(event.getEventNr());
		eventTO.setEventName(event.getEventName());
		eventTO.setEventDatum(event.getEventDatum());
		eventTO.setAnmeldeStartDatum(event.getAnmeldungStartDatum());
		eventTO.setAnmeldeEndeDatum(event.getAnmeldungEndeDatum());
		eventTO.setStandorte(event.getStandorte());
		return eventTO;
		
	}

	public int getEventNr() {
		return eventNr;
	}

	public void setEventNr(int eventNr) {
		this.eventNr = eventNr;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String bezeichnung) {
		this.eventName = bezeichnung;
	}

	public Date getEventDatum() {
		return eventDatum;
	}

	public void setEventDatum(Date datum) {
		this.eventDatum = datum;
	}

	public Date getAnmeldungStartDatum() {
		return anmeldeStartDatum;
	}

	public void setAnmeldungStartDatum(Date anmeldungStart) {
		this.anmeldeStartDatum = anmeldungStart;
	}

	public Date getAnmeldungEndeDatum() {
		return anmeldeEndeDatum;
	}

	public void setAnmeldungEndeDatum(Date anmeldungEnde) {
		this.anmeldeEndeDatum = anmeldungEnde;
	}

	public Date getAnmeldeStartDatum() {
		return anmeldeStartDatum;
	}

	public void setAnmeldeStartDatum(Date anmeldeStartDatum) {
		this.anmeldeStartDatum = anmeldeStartDatum;
	}

	public Date getAnmeldeEndeDatum() {
		return anmeldeEndeDatum;
	}

	public void setAnmeldeEndeDatum(Date anmeldeEndeDatum) {
		this.anmeldeEndeDatum = anmeldeEndeDatum;
	}

	public List<Standort> getStandorte() {
		return standorte;
	}

	public void setStandorte(List<Standort> standorte) {
		this.standorte = standorte;
	}
	
	public void addStandort (Standort standort) {
		this.standorte.add(standort);
	}

}