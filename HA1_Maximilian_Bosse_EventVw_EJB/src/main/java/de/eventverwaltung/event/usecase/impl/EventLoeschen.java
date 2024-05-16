package de.eventverwaltung.event.usecase.impl;

import de.eventverwaltung.event.dao.EventDAO;
import de.eventverwaltung.event.entity.event.EventTO;
import de.eventverwaltung.event.entity.event.internal.Event;
import de.eventverwaltung.event.usecase.IEventLoeschen;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class EventLoeschen implements IEventLoeschen {

	@Inject
	EventDAO eventDAO;

	@Override
	public boolean eventLoeschen(EventTO eventTO) {
		Event event = new Event();
		if (!eventTO.getStandorte().isEmpty()) {
			return true;
		} else {
			event = eventTO.toEvent(eventTO);
			eventDAO.delete(event);
			return false;
		}

	}

}
