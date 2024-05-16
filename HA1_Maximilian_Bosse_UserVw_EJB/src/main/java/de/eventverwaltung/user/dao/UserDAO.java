package de.eventverwaltung.user.dao;

import de.eventverwaltung.user.entity.internal.User;
import jakarta.ejb.Stateless;

@Stateless
public class UserDAO extends GenericDAO<User> {

	public UserDAO() {
		super(User.class);
	}
	
	public void delete(User aUser){
		super.delete(aUser.getUserNr(), User.class);
	}

}
