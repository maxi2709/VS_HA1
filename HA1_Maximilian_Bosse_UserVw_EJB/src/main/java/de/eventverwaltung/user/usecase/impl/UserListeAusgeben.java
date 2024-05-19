package de.eventverwaltung.user.usecase.impl;

import java.util.ArrayList;
import java.util.List;

import de.eventverwalter.buchung.dao.BuchungDAO;
import de.eventverwalter.buchung.entity.internal.Buchung;
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

	@Inject
	BuchungDAO buchungDAO;

	@Override
	public List<UserTO> userListeAusgeben() {
		List<UserTO> retList = new ArrayList<>();
		List<User> userList = userDAO.findAll();
		for (User user : userList) {
			retList.add(user.toUserTO(user));
		}
		return retList;
	}

	
	public List<Integer> getUserListByID (int standortNr) {
		List<Integer> userTOlist = new ArrayList<>();
		for (Buchung buchung : buchungDAO.findAll()) {
			if (buchung.getStandortNr() == standortNr) {
				userTOlist.add(buchung.getUserNr());
			}
		}
		return userTOlist;
	}

	@Override
	public List<UserTO> userProStandort(int standortNr) {
		List<UserTO> userList = new ArrayList<>();
		for (User user : userDAO.findAll()) {
			for (Integer userID : getUserListByID(standortNr)) {
				if (user.getUserNr() == userID) {
					userList.add(user.toUserTO(user));
				}
			}
		}
		return userList;
	}
}
