package de.eventverwaltung.event.usecase.impl;

import java.util.ArrayList;
import java.util.List;

import de.eventverwaltung.event.dao.BuehneDAO;
import de.eventverwaltung.event.dao.EssenstandDAO;
import de.eventverwaltung.event.dao.GetraenkestandDAO;
import de.eventverwaltung.event.dao.StandDAO;
import de.eventverwaltung.event.entity.Stand.StandTO;
import de.eventverwaltung.event.entity.Stand.internal.BuehneStand;
import de.eventverwaltung.event.entity.Stand.internal.Essenstand;
import de.eventverwaltung.event.entity.Stand.internal.Getraenkestand;
import de.eventverwaltung.event.entity.Stand.internal.Stand;
import de.eventverwaltung.event.entity.standort.StandortTO;
import de.eventverwaltung.event.usecase.IStandlisteErstellen;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class StandlisteErstellen implements IStandlisteErstellen {

	@Inject
	StandDAO standDAO;

	@Inject
	BuehneDAO buehneDAO;

	@Inject
	GetraenkestandDAO getraenkestandDAO;

	@Inject
	EssenstandDAO essenstandDAO;

	@Override
	public List<StandTO> buchbareStaendeAusgeben(StandortTO standortTO) {
		List<StandTO> retList = new ArrayList<>();
		List<Stand> staende = getAlleStaende();
		for (Stand stand : staende) {
			if (stand.getStandort().getStandortNr() == standortTO.getStandortNr()) {
				retList.add(stand.toStandTO(stand));
			}
		}
		return retList;

	}

	public List<Stand> getAlleStaende() {
		List<BuehneStand> buehnen = buehneDAO.findAll();
		List<Getraenkestand> getraenkestaende = getraenkestandDAO.findAll();
		List<Essenstand> essenstaende = essenstandDAO.findAll();
		List<Stand> returnList = new ArrayList<>();
		returnList.addAll(buehnen);
		returnList.addAll(getraenkestaende);
		returnList.addAll(essenstaende);
		return returnList;
	}

}
