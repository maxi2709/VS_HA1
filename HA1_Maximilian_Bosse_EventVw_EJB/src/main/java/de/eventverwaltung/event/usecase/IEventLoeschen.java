package de.eventverwaltung.event.usecase;

import de.eventverwaltung.event.entity.EventTO;
import jakarta.ejb.Local;

@Local
public interface IEventLoeschen {

	void eventLoeschen(EventTO eventTO);

	boolean eventLoeschen(int nummer);
	
}
