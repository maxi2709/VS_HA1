package de.eventverwaltung.event.usecase.impl;

import java.util.ArrayList;
import java.util.List;

import de.eventverwaltung.event.dao.StandDAO;
import de.eventverwaltung.event.entity.Stand.StandTO;
import de.eventverwaltung.event.entity.Stand.internal.Stand;
import de.eventverwaltung.event.entity.standort.StandortTO;
import de.eventverwaltung.event.usecase.IStandlisteErstellen;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class StandlisteErstellen implements IStandlisteErstellen {

	@Inject
	StandDAO standDAO;

	@Override
	public List<StandTO> buchbareStaendeAusgeben(StandortTO standortTO) {
		List<StandTO> retList = new ArrayList<>();
		List<Stand> staende = standDAO.findAll();
		for (Stand stand : staende) {
			if (stand.getStandort().getStandortNr() == standortTO.getStandortNr()) {
				retList.add(stand.toStandTO(stand));
			}
		}
		return retList;

	}

}
