package de.eventverwaltung.user.usecase.impl;

import de.eventverwaltung.user.dao.UserDAO;
import de.eventverwaltung.user.entity.UserTO;
import de.eventverwaltung.user.entity.internal.User;
import de.eventverwaltung.user.usecase.IUserAnlegen;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class UserAnlegen implements IUserAnlegen{

	@Inject 
	UserDAO userDAO;
	
	@Override
	public void userAnlegen(UserTO userTO) {
		User user = userTO.toUser(userTO);
		userDAO.save(user);
	}
}
