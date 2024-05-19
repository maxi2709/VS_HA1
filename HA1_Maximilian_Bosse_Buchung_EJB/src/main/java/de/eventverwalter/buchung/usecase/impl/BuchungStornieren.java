package de.eventverwalter.buchung.usecase.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import de.eventverwalter.buchung.dao.BuchungDAO;
import de.eventverwalter.buchung.entity.BuchungTO;
import de.eventverwalter.buchung.usecase.IBuchungStornieren;
import de.eventverwaltung.event.dao.EventDAO;
import de.eventverwaltung.event.entity.event.EventTO;
import de.eventverwaltung.event.entity.standort.StandortTO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class BuchungStornieren implements IBuchungStornieren {

	@Inject
	BuchungDAO buchungDAO;

	@Inject
	EventDAO eventDAO;

	@Override
	public void buchungStornieren(BuchungTO buchungTO) {
		buchungDAO.delete(buchungTO.toBuchung(buchungTO));
	}

	@Override
	public void gebuchteStaendeVerringern(StandortTO standortTO, String stand) {
		if (stand.equals("Buehne")) {
			standortTO.setAnzahlBuehne_frei(+1);
			standortTO.setAnzahlBuehne_gebucht(-1);
		}
		if (stand.equals("Getraenkestand")) {
			standortTO.setAnzahlGetraenkestand_frei(+1);
			standortTO.setAnzahlGetraenkestand_gebucht(-1);
		}

		if (stand.equals("Essenstand")) {
			standortTO.setAnzahlEssenstand_frei(+1);
			standortTO.setAnzahlEssenstand_gebucht(-1);
		}
	}

	@Override
	public boolean pruefeStornierung(EventTO eventTO) {
		LocalDate heute = LocalDate.now();
		Date dateHeute = (Date) Date.from(heute.atStartOfDay(ZoneId.systemDefault()).toInstant());
		if (eventTO.getAnmeldeEndeDatum().before(dateHeute)) {
			return true;
		} else {
			return false;
		}
	}
}
