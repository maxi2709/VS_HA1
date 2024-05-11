package de.eventverwaltung.event.usecase;

import jakarta.ejb.Local;

@Local
public interface IEventLoeschen {

	void eventLoeschen(int evnetNr);
	
}
