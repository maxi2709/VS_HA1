package de.eventverwaltung.event.usecase;

import java.util.List;

import de.eventverwaltung.event.entity.Stand.StandTO;
import de.eventverwaltung.event.entity.standort.StandortTO;
import jakarta.ejb.Local;

@Local
public interface IStandlisteErstellen {

	List<StandTO> buchbareStaendeAusgeben(StandortTO standortTO);

}
