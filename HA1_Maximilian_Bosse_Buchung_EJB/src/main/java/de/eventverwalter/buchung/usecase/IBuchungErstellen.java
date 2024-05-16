package de.eventverwalter.buchung.usecase;

import jakarta.ejb.Local;

@Local
public interface IBuchungErstellen {

	void buchungErstellen(int eventNr, int standortNr, String stand, int userNr);

}
