package de.eventverwalter.buchung.usecase;

import de.eventverwalter.buchung.entity.BuchungTO;
import jakarta.ejb.Local;

@Local
public interface IBuchungStornieren {

	void buchungStornieren(BuchungTO buchungTO);

}
