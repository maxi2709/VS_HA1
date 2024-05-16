package de.eventverwaltung.event.usecase.impl;

import java.util.ArrayList;
import java.util.List;

import de.eventverwaltung.event.dao.EventDAO;
import de.eventverwaltung.event.dao.StandortDAO;
import de.eventverwaltung.event.entity.StandortTO;
import de.eventverwaltung.event.entity.internal.Standort;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class StandortelisteErstellen implements IStandortlisteErstellen{

	
	@Inject 
	StandortDAO standortDAO;
	
	@Inject 
	EventDAO eventDAO;
	
	@Override
	public List<StandortTO> standortListeBuchen (int eventNr) {
		List<StandortTO> standorteTO = new ArrayList<>();
		for (Standort standort : standorteProEvent(eventNr)) {
			standorteTO.add(standort.toStandortTO());
		}
		return standorteTO;
	}
	
	public List<Standort> standorteProEvent (int eventNr) {
		List<Standort> standorte = standortDAO.findAll();
		List<Standort> tempList = new ArrayList<>();
		for (Standort standort : standorte) {
			if (standort.getEventNr()==eventNr) {
				tempList.add(standort);
			}
		}
		return tempList;
	}
	
	@Override
	public List<String> staendeProStandort () {
	    List<String> staendeListe = new ArrayList<>();
	    staendeListe.add("Buehne");
	    staendeListe.add("Getraenkestand");
	    staendeListe.add("Essenstand");
	    return staendeListe;
	}
}
