package de.eventverwaltung.user.usecase.impl;

import java.util.ArrayList;
import java.util.List;

import de.eventverwaltung.user.dao.UserDAO;
import de.eventverwaltung.user.entity.UserTO;
import de.eventverwaltung.user.entity.internal.User;
import de.eventverwaltung.user.usecase.IUserListeAusgeben;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class UserListeAusgeben implements IUserListeAusgeben {

	@Inject
	UserDAO userDAO;

	@Override
	public List<UserTO> userListeAusgeben() {
		List<UserTO> retList = new ArrayList<>();
		List<User> userList = userDAO.findAll();
		for (User user : userList) {
			retList.add(user.toUserTO(user));
		}
		return retList;
	}
}
