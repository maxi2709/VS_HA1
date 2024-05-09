package de.eventverwaltung.event.entity;

import java.util.Date;

import de.eventverwaltung.event.entity.internal.Event;

public class EventTO {

	private int eventNr;
	private String eventName;
	private Date eventDatum;
	private Date anmeldeStartDatum;
	private Date anmeldeEndeDatum;

	public EventTO() {

	}

	public EventTO(String bezeichnung, Date datum, Date anmeldungStart, Date anmeldungEnde) {
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

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventDate() {
		return eventDatum;
	}

	public void setEventDate(Date eventDate) {
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
	
	 public Event toEvent(EventTO eventTO) {
		 Event event = new Event();
	        event.setEventNr(eventTO.getEventNr());
	        event.setBezeichnung(eventTO.getEventName());
	        event.setDatum(eventTO.getEventDate());
	        event.setAnmeldungStart(eventTO.getAnmeldeStartDatum());
	        event.setAnmeldungEnde(eventTO.getAnmeldeEndeDatum());
	        return event;
	    }
	
}
