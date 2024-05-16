package de.eventverwaltung.event.usecase;

import de.eventverwaltung.event.entity.event.EventTO;
import jakarta.ejb.Local;

@Local
public interface IEventLoeschen {

	boolean eventLoeschen(EventTO eventTO);
	
}
