package de.eventverwaltung.event.usecase.impl;

import de.eventverwaltung.event.dao.EventDAO;
import de.eventverwaltung.event.entity.event.EventTO;
import de.eventverwaltung.event.entity.event.internal.Event;
import de.eventverwaltung.event.usecase.IEventAnlegen;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class EventAnlegen implements IEventAnlegen {
	
	@Inject 
	EventDAO eventDAO;
	
	@Override
	public void eventAnlegen (EventTO eventTO) {
	Event event = eventTO.toEvent(eventTO);
	eventDAO.save(event);
	}
	

}
