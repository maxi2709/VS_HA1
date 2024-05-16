package de.eventverwaltung.event.usecase.impl;

import de.eventverwaltung.event.dao.EventDAO;
import de.eventverwaltung.event.dao.StandDAO;
import de.eventverwaltung.event.dao.StandortDAO;
import de.eventverwaltung.event.entity.event.EventTO;
import de.eventverwaltung.event.entity.standort.internal.Standort;
import de.eventverwaltung.event.usecase.IStandortHinzufuegen;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class StandortHinzufuegen implements IStandortHinzufuegen {

	@Inject
	StandortDAO standortDAO;

	@Inject
	EventDAO eventDAO;

	@Inject
	StandDAO standDAO;

	@Override
	public void standortHinzufuegen(EventTO eventTO, String standortName, int anzahlBuehne_frei,
			int anzahlGetraenkestand_frei, int anzahlEssenstand_frei) {

		// Standort anlegen und in der Datenbank anlegen
		Standort standort = new Standort(standortName, eventTO.getEventNr(), anzahlBuehne_frei,
				anzahlGetraenkestand_frei, anzahlEssenstand_frei);
		standortDAO.save(standort);

	}

}
