package de.eventverwaltung.event.usecase.impl;

import java.util.ArrayList;
import java.util.List;

import de.eventverwaltung.event.dao.EventDAO;
import de.eventverwaltung.event.entity.EventTO;
import de.eventverwaltung.event.entity.internal.Event;
import de.eventverwaltung.event.usecase.IEventlisteErstellen;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class EventlisteErstellen implements IEventlisteErstellen {

	@Inject
	EventDAO eventDAO;
	
	@Override
	public List<EventTO> eventlisteAusgeben () {
		List<Event> aList = eventDAO.findAll();
		List<EventTO> returnList = new ArrayList<EventTO>();
		for (Event event : aList) {
			returnList.add(event.toEventTO(event));
		}
		return returnList;
	}

}
