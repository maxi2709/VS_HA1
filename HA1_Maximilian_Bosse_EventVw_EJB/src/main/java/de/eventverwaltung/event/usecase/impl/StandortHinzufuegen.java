package de.eventverwaltung.event.usecase.impl;

import de.eventverwaltung.event.dao.StandortDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class StandortHinzufuegen {

	@Inject
	StandortDAO standortDAO;
	
	
}
