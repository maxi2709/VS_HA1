package de.eventverwaltung.event.usecase;

import java.util.List;

import de.eventverwaltung.event.entity.EventTO;
import jakarta.ejb.Local;

@Local
public interface IEventlisteErstellen {

	List<EventTO> eventlisteAusgeben();

	List<EventTO> eventlisteAusgebenBuchen();

}
