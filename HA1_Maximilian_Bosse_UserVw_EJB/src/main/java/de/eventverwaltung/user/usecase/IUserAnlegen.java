package de.eventverwaltung.user.usecase;

import de.eventverwaltung.user.entity.UserTO;
import jakarta.ejb.Local;

@Local
public interface IUserAnlegen {

	void userAnlegen(UserTO userTO);

}
