package de.eventverwalter.buchung.usecase.impl;

import de.eventverwalter.buchung.dao.BuchungDAO;
import de.eventverwalter.buchung.entity.internal.Buchung;
import de.eventverwalter.buchung.usecase.IBuchungErstellen;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class BuchungErstellen implements IBuchungErstellen {

	@Inject
	BuchungDAO buchungDAO;

	@Override
	public void buchungErstellen(int eventNr, int standortNr, String stand, int userNr) {
		Buchung buchung = new Buchung(eventNr, standortNr, stand, userNr);
		buchungDAO.save(buchung);
	}
}
