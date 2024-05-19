package de.eventverwalter.buchung.usecase.impl;

import de.eventverwalter.buchung.dao.BuchungDAO;
import de.eventverwalter.buchung.entity.internal.Buchung;
import de.eventverwalter.buchung.usecase.IBuchungErstellen;
import de.eventverwaltung.event.dao.EventDAO;
import de.eventverwaltung.event.entity.standort.StandortTO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class BuchungErstellen implements IBuchungErstellen {

	@Inject
	BuchungDAO buchungDAO;
	
	@Inject
	EventDAO eventDAO;
	
	@Override
	public void buchungErstellen(int eventNr, int standortNr, String stand, int userNr) {
		Buchung buchung = new Buchung(eventNr, standortNr, stand, userNr);
		buchungDAO.save(buchung);
	}
	
	@Override
	public void gebuchteStandeErhoehen (StandortTO standortTO, String stand) {
		if (stand.equals("Buehne")) {
			standortTO.setAnzahlBuehne_frei(-1);
			standortTO.setAnzahlBuehne_gebucht(+1);
		}
		if (stand.equals("Getraenkestand")) {
			standortTO.setAnzahlGetraenkestand_frei(-1);
			standortTO.setAnzahlGetraenkestand_gebucht(+1);
		}
		
		if (stand.equals("Essenstand")) {
			standortTO.setAnzahlEssenstand_frei(-1);
			standortTO.setAnzahlEssenstand_gebucht(+1);
		}
	}
}
