package de.eventverwaltung.event.dao;

import de.eventverwaltung.event.entity.event.internal.Event;
import jakarta.ejb.Stateless;

@Stateless
public class EventDAO extends GenericDAO<Event> {

	public EventDAO() {
		super(Event.class);
	}
	
	public void delete(Event aEvent){
		super.delete(aEvent.getEventNr(), Event.class);
	}

}
