package de.eventverwaltung.event.usecase.impl;

import java.util.ArrayList;
import java.util.List;

import de.eventverwaltung.event.dao.EventDAO;
import de.eventverwaltung.event.entity.EventTO;
import de.eventverwaltung.event.entity.internal.Event;
import de.eventverwaltung.event.entity.internal.Standort;
import de.eventverwaltung.event.usecase.IEventlisteErstellen;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class EventlisteErstellen implements IEventlisteErstellen {

	@Inject
	EventDAO eventDAO;

	@Override
	public List<EventTO> eventlisteAusgeben() {
		List<Event> aList = eventDAO.findAll();
		List<EventTO> returnList = new ArrayList<EventTO>();
		for (Event event : aList) {
			returnList.add(event.toEventTO(event));
		}
		return returnList;
	}

	@Override
	public List<EventTO> eventlisteAusgebenBuchen() {
	    List<Event> aList = eventDAO.findAll();
	    List<EventTO> returnList = new ArrayList<>();
	    for (Event event : aList) {
	        for (Standort standortTO : event.getStandorte()) {
	            if (standortTO.getEventNr() == event.getEventNr()) {
	                if (standortTO.getAnzahlBuehne_frei() > 0 || standortTO.getAnzahlGetraenkestand_frei() > 0 || standortTO.getAnzahlEssenstand_frei() > 0) {
	                    returnList.add(event.toEventTO(event));
	                    break; // Beendet den inneren Loop und fährt mit dem nächsten Event fort
	                }
	            }
	        }
	    }
	    return returnList;
	}

}
