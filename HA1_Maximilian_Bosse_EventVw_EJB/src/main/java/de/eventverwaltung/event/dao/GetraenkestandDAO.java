package de.eventverwaltung.event.dao;

import de.eventverwaltung.event.entity.Stand.internal.Getraenkestand;
import jakarta.ejb.Stateless;

@Stateless
public class GetraenkestandDAO extends GenericDAO<Getraenkestand> {

	public GetraenkestandDAO() {
		super(Getraenkestand.class);
	}
	
	public void delete(Getraenkestand aStand){
		super.delete(aStand.getStandNr(), Getraenkestand.class);
	}

}
