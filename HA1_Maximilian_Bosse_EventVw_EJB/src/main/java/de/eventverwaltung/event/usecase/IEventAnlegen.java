package de.eventverwaltung.event.usecase;

import de.eventverwaltung.event.entity.EventTO;
import jakarta.ejb.Local;

@Local
public interface IEventAnlegen {

	void eventAnlegen(EventTO eventTO);
	
	

}
