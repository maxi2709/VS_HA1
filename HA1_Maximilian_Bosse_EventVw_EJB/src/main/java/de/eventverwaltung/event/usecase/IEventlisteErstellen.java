package de.eventverwaltung.event.usecase;

import java.util.List;

import de.eventverwaltung.event.entity.event.EventTO;
import jakarta.ejb.Local;

@Local
public interface IEventlisteErstellen {

	List<EventTO> eventlisteAusgeben();

	List<EventTO> eventlisteAusgebenBuchen();

	EventTO getEventByID(int eventNr);

}
