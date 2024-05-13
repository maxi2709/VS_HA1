package de.eventverwaltung.event.usecase;

import de.eventverwaltung.event.entity.EventTO;
import jakarta.ejb.Local;

@Local
public interface IStandortHinzufuegen {

	void standortHinzufuegen(EventTO eventTO, String standortName, int anzahlBuehne, int anzahlGetraenkestand,
			int anzahlEssenstand);

}
