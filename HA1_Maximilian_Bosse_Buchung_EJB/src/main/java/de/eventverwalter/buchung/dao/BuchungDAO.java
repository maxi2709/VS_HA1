package de.eventverwalter.buchung.dao;

import de.eventverwalter.buchung.entity.internal.Buchung;
import jakarta.ejb.Stateless;

@Stateless
public class BuchungDAO extends GenericDAO<Buchung> {

	public BuchungDAO() {
		super(Buchung.class);
	}
	
	public void delete(Buchung aBuchung){
		super.delete(aBuchung.getBuchungNr(), Buchung.class);
	}

}
