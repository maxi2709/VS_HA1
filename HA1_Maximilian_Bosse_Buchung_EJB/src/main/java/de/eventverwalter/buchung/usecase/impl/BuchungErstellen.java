package de.eventverwalter.buchung.usecase.impl;

import de.eventverwalter.buchung.dao.BuchungDAO;
import de.eventverwalter.buchung.entity.internal.Buchung;
import de.eventverwalter.buchung.usecase.IBuchungErstellen;
import de.eventverwaltung.event.dao.EventDAO;
import de.eventverwaltung.event.dao.StandortDAO;
import de.eventverwaltung.event.entity.standort.StandortTO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class BuchungErstellen implements IBuchungErstellen {

	@Inject
	BuchungDAO buchungDAO;

	@Inject
	EventDAO eventDAO;
	
	@Inject
	StandortDAO standortDAO;

	@Override
	public void buchungErstellen(int eventNr, int standortNr, String stand, int userNr) {
		Buchung buchung = new Buchung(eventNr, standortNr, stand, userNr);
		buchungDAO.save(buchung);
	}

	@Override
	public void gebuchteStandeErhoehen(StandortTO standortTO, String stand) {
		if (stand.equals("Buehne")) {
			standortTO.setAnzahlBuehne_frei(standortTO.getAnzahlBuehne_frei()-1);
			standortTO.setAnzahlBuehne_gebucht(standortTO.getAnzahlBuehne_gebucht()+1);
			standortDAO.update(standortTO.toStandort(standortTO));
		}
		if (stand.equals("Getraenkestand")) {
			standortTO.setAnzahlGetraenkestand_frei(standortTO.getAnzahlGetraenkestand_frei()-1);
			standortTO.setAnzahlGetraenkestand_gebucht(standortTO.getAnzahlGetraenkestand_gebucht()+1);
			standortDAO.update(standortTO.toStandort(standortTO));
		}

		if (stand.equals("Essenstand")) {
			standortTO.setAnzahlEssenstand_frei(standortTO.getAnzahlEssenstand_frei()-1);
			standortTO.setAnzahlEssenstand_gebucht(standortTO.getAnzahlEssenstand_gebucht()+1);
			standortDAO.update(standortTO.toStandort(standortTO));
		}
	}

	@Override
	public boolean pruefeFreieStaende(StandortTO standortTO, String stand) {
	    if (stand.equals("Buehne")) {
	        return standortTO.getAnzahlBuehne_frei() > 0;
	    } else if (stand.equals("Getraenkestand")) {
	        return standortTO.getAnzahlGetraenkestand_frei() > 0;
	    } else if (stand.equals("Essenstand")) {
	        return standortTO.getAnzahlEssenstand_frei() > 0;
	    }
	    return false;
	}


}
