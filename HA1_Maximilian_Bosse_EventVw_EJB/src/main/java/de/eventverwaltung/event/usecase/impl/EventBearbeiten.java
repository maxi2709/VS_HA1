package de.eventverwaltung.event.usecase.impl;

import de.eventverwaltung.event.dao.EventDAO;
import de.eventverwaltung.event.entity.EventTO;
import de.eventverwaltung.event.entity.internal.Event;
import de.eventverwaltung.event.usecase.IEventBearbeiten;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class EventBearbeiten implements IEventBearbeiten {

	@Inject
	EventDAO eventDAO;
	
	@Override
	public void eventSpeichern (EventTO eventTO) {
		Event event = eventDAO.find(eventTO.getEventNr());
		event.setEventName(eventTO.getEventName());
		event.setEventDatum(eventTO.getEventDatum());
		event.setAnmeldungStartDatum(eventTO.getAnmeldeStartDatum());
		event.setAnmeldungEndeDatum(eventTO.getAnmeldeEndeDatum());
		eventDAO.update(event);
		
	}
}
