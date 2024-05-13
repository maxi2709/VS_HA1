package de.eventverwaltung.event.dao;

import de.eventverwaltung.event.entity.internal.Standort;
import jakarta.ejb.Stateless;

@Stateless
public class StandortDAO extends GenericDAO<Standort> {

	public StandortDAO() {
		super(Standort.class);
	}
	
	public void delete(Standort aStandort){
		super.delete(aStandort.getStandortNr(), Standort.class);
	}

}
