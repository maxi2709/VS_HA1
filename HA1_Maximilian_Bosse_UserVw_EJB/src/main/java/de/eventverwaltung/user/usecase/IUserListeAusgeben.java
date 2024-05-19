package de.eventverwaltung.user.usecase;

import java.util.List;

import de.eventverwaltung.user.entity.UserTO;
import jakarta.ejb.Local;

@Local
public interface IUserListeAusgeben {

	List<UserTO> userListeAusgeben();

	List<UserTO> userProStandort(int standortNr);
	

}
