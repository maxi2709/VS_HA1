package de.eventverwalter.buchung.usecase;

import java.util.List;

import de.eventverwalter.buchung.entity.BuchungTO;
import jakarta.ejb.Local;

@Local
public interface IBuchungenAusgeben {

	List<BuchungTO> buchungenAusgeben();

}
