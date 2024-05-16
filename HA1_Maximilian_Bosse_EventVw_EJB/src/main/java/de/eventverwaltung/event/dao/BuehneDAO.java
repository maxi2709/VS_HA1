package de.eventverwaltung.event.dao;

import de.eventverwaltung.event.entity.Stand.internal.BuehneStand;
import jakarta.ejb.Stateless;

@Stateless
public class BuehneDAO extends GenericDAO<BuehneStand> {

	public BuehneDAO() {
		super(BuehneStand.class);
	}
	
	public void delete(BuehneStand aStand){
		super.delete(aStand.getStandNr(), BuehneStand.class);
	}

}
