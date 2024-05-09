package de.eventverwaltung.event.dao;

import de.eventverwaltung.event.entity.internal.Event;
import jakarta.ejb.Stateless;

@Stateless
public class EventDAO extends GenericDAO<Event> {

	public EventDAO() {
		super(Event.class);
	}

}
