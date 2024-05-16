package de.eventverwaltung.event.usecase;

import java.util.List;

import de.eventverwaltung.event.entity.standort.StandortTO;
import jakarta.ejb.Local;

@Local
public interface IStandortlisteErstellen {

	List<StandortTO> standortListeBuchen(int eventNr);

}
