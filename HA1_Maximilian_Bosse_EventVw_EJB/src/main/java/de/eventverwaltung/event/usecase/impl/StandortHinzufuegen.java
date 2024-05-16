package de.eventverwaltung.event.usecase.impl;

import de.eventverwaltung.event.dao.EventDAO;
import de.eventverwaltung.event.dao.StandortDAO;
import de.eventverwaltung.event.entity.EventTO;
import de.eventverwaltung.event.entity.internal.Event;
import de.eventverwaltung.event.entity.internal.Standort;
import de.eventverwaltung.event.usecase.IStandortHinzufuegen;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class StandortHinzufuegen implements IStandortHinzufuegen {

	@Inject
	StandortDAO standortDAO;

	@Inject
	EventDAO eventDAO;

	@Override
	public void standortHinzufuegen(EventTO eventTO, String standortName, int anzahlBuehne, int anzahlGetraenkestand,
			int anzahlEssenstand) {

		// Event finden

		Event event = eventDAO.find(eventTO.getEventNr());
		if (event != null) {
			// Standort anlegen
			Standort standort = new Standort(standortName, anzahlBuehne, anzahlGetraenkestand, anzahlEssenstand,
					eventTO.getEventNr());
			standortDAO.save(standort);

			event.addStandort(standort);
			eventDAO.update(event);

		}

	}

}
