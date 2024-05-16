package de.eventverwaltung.event.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.eventverwaltung.event.entity.internal.Event;
import de.eventverwaltung.event.entity.internal.Standort;

public class EventTO implements Serializable{
	
	private static final long serialVersionUID = 1905444945740712821L;

	private int eventNr;
	private String eventName;
	private Date eventDatum;
	private Date anmeldeStartDatum;
	private Date anmeldeEndeDatum;
	List<Standort> standorte; 

	public EventTO() {

	}

	public EventTO (String bezeichnung, Date datum, Date anmeldungStart, Date anmeldungEnde) {
		this.eventName = bezeichnung;
		this.eventDatum = datum;
		this.anmeldeStartDatum = anmeldungStart;
		this.anmeldeEndeDatum = anmeldungEnde;
		this.standorte = new ArrayList<>();
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

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventDatum() {
		return eventDatum;
	}

	public void setEventDatum(Date eventDate) {
		this.eventDatum = eventDate;
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

	public Event toEvent(EventTO eventTO) {
		 Event event = new Event();
	        event.setEventNr(eventTO.getEventNr());
	        event.setEventName(eventTO.getEventName());
	        event.setEventDatum(eventTO.getEventDatum());
	        event.setAnmeldungStartDatum(eventTO.getAnmeldeStartDatum());
	        event.setAnmeldungEndeDatum(eventTO.getAnmeldeEndeDatum());
	        event.setStandorte(eventTO.getStandorte());
	        return event;
	    }
	
}
