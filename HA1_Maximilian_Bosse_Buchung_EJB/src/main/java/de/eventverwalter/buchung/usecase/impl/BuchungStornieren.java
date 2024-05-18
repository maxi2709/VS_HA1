package de.eventverwalter.buchung.usecase.impl;

import de.eventverwalter.buchung.dao.BuchungDAO;
import de.eventverwalter.buchung.entity.BuchungTO;
import de.eventverwalter.buchung.usecase.IBuchungStornieren;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class BuchungStornieren implements IBuchungStornieren{

	@Inject
	BuchungDAO buchungDAO;
	
	@Override
	public void buchungStornieren (BuchungTO buchungTO) {
		buchungDAO.delete(buchungTO.toBuchung(buchungTO));
	}
}
