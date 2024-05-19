package de.eventverwalter.buchung.usecase;

import de.eventverwalter.buchung.entity.BuchungTO;
import de.eventverwaltung.event.entity.event.EventTO;
import de.eventverwaltung.event.entity.standort.StandortTO;
import jakarta.ejb.Local;

@Local
public interface IBuchungStornieren {

	void buchungStornieren(BuchungTO buchungTO);

	void gebuchteStaendeVerringern(StandortTO standortTO, String stand);

	boolean pruefeStornierung(EventTO eventTO);

}
