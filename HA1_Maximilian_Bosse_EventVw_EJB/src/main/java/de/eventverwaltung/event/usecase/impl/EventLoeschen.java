package de.eventverwaltung.event.usecase.impl;

import de.eventverwaltung.event.dao.EventDAO;
import de.eventverwaltung.event.entity.internal.Event;
import de.eventverwaltung.event.usecase.IEventLoeschen;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class EventLoeschen implements IEventLoeschen {

	@Inject
	EventDAO eventDAO;

	@Override
	public void eventLoeschen(int evnetNr) {
		Event event = eventDAO.find(evnetNr);
		eventDAO.delete(event);
	}

}
