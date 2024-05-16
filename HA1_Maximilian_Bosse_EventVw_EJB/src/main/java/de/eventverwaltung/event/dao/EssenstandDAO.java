package de.eventverwaltung.event.dao;

import de.eventverwaltung.event.entity.Stand.internal.Essenstand;
import jakarta.ejb.Stateless;

@Stateless
public class EssenstandDAO extends GenericDAO<Essenstand> {

	public EssenstandDAO() {
		super(Essenstand.class);
	}
	
	public void delete(Essenstand aStand){
		super.delete(aStand.getStandNr(), Essenstand.class);
	}

}
