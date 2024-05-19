package de.eventverwalter.buchung.usecase.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import de.eventverwalter.buchung.dao.BuchungDAO;
import de.eventverwalter.buchung.entity.BuchungTO;
import de.eventverwalter.buchung.usecase.IBuchungStornieren;
import de.eventverwaltung.event.dao.EventDAO;
import de.eventverwaltung.event.dao.StandortDAO;
import de.eventverwaltung.event.entity.event.internal.Event;
import de.eventverwaltung.event.entity.standort.internal.Standort;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class BuchungStornieren implements IBuchungStornieren {

	@Inject
	BuchungDAO buchungDAO;

	@Inject
	EventDAO eventDAO;
	
	@Inject
	StandortDAO standortDAO;

	@Override
	public void buchungStornieren(BuchungTO buchungTO) {
		buchungDAO.delete(buchungTO.toBuchung(buchungTO));
	}

	@Override
	public void gebuchteStaendeVerringern(int standortNr, String stand) {
		Standort standort = standortDAO.find(standortNr);
		if (stand.equals("Buehne")) {
			standort.setAnzahlBuehne_frei(standort.getAnzahlBuehne_frei()+1);
			standort.setAnzahlBuehne_gebucht(standort.getAnzahlBuehne_gebucht()-1);
			standortDAO.update(standort);
		}
		if (stand.equals("Getraenkestand")) {
			standort.setAnzahlGetraenkestand_frei(standort.getAnzahlGetraenkestand_frei()+1);
			standort.setAnzahlGetraenkestand_gebucht(standort.getAnzahlGetraenkestand_gebucht()-1);
			standortDAO.update(standort);
		}

		if (stand.equals("Essenstand")) {
			standort.setAnzahlEssenstand_frei(standort.getAnzahlEssenstand_frei()+1);
			standort.setAnzahlEssenstand_gebucht(standort.getAnzahlEssenstand_gebucht()-1);
			standortDAO.update(standort);
		}
	}

	@Override
	public boolean pruefeStornierung(int eventNr) {
		Event event = eventDAO.find(eventNr);
		LocalDate heute = LocalDate.now();
		Date dateHeute = (Date) Date.from(heute.atStartOfDay(ZoneId.systemDefault()).toInstant());
		if (event.getAnmeldeEndeDatum().after(dateHeute)) {
			return true;
		} else {
			return false;
		}
	}
}
