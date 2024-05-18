package de.eventverwalter.buchung.usecase.impl;

import java.util.ArrayList;
import java.util.List;

import de.eventverwalter.buchung.dao.BuchungDAO;
import de.eventverwalter.buchung.entity.BuchungTO;
import de.eventverwalter.buchung.entity.internal.Buchung;
import de.eventverwalter.buchung.usecase.IBuchungenAusgeben;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class BuchungenAusgeben implements IBuchungenAusgeben{

	@Inject
	BuchungDAO buchungDAO;

	@Override
	public List<BuchungTO> buchungenAusgeben() {
		List<BuchungTO> retList = new ArrayList<>();
		List<Buchung> buchngen = buchungDAO.findAll();
		for (Buchung buchung : buchngen) {
			retList.add(buchung.toBuchungTO(buchung));
		}
		return retList;
	}

}
