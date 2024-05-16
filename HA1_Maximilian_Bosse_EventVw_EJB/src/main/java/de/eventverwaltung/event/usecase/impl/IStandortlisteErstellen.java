package de.eventverwaltung.event.usecase.impl;

import java.util.List;

import de.eventverwaltung.event.entity.StandortTO;
import jakarta.ejb.Local;

@Local
public interface IStandortlisteErstellen {

	List<StandortTO> standortListeBuchen(int eventNr);

	List<String> staendeProStandort();

}
