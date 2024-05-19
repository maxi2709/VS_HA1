package de.eventverwalter.buchung.usecase;

import de.eventverwaltung.event.entity.standort.StandortTO;
import jakarta.ejb.Local;

@Local
public interface IBuchungErstellen {

	void buchungErstellen(int eventNr, int standortNr, String stand, int userNr);

	void gebuchteStandeErhoehen(StandortTO standortTO, String stand);

}
