package de.eventverwaltung.event.dao;


import de.eventverwaltung.event.entity.Stand.internal.Stand;
import jakarta.ejb.Stateless;

@Stateless
public class StandDAO extends GenericDAO<Stand> {

	public StandDAO() {
		super(Stand.class);
	}
	
	public void delete(Stand aStand){
		super.delete(aStand.getStandNr(), Stand.class);
	}

}
