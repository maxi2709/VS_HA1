package de.eventverwaltung.event.usecase.impl;

import de.eventverwaltung.event.dao.EventDAO;
import de.eventverwaltung.event.entity.EventTO;
import de.eventverwaltung.event.entity.internal.Event;
import de.eventverwaltung.event.usecase.IEventLoeschen;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class EventLoeschen implements IEventLoeschen {

	@Inject
	EventDAO eventDAO;

	@Override
	public void eventLoeschen(EventTO eventTO) {
		Event event = new Event();
		event = eventTO.toEvent(eventTO);
		eventDAO.delete(event);
	}
	
	@Override
	@SuppressWarnings("unused")
	public boolean eventLoeschen(int nummer) {
		Event aEvent= eventDAO.find(nummer);
		System.out.println("Kunde "+aEvent.getEventName()+" gefunden zum Loeschen");
		if (aEvent == null) { 
			return Boolean.FALSE;
		}
		else {
			eventDAO.delete(aEvent);
			return Boolean.TRUE;
		}
	}



}
