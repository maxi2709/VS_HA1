package de.eventverwaltung.user.entity.internal;

import de.eventverwaltung.user.entity.UserTO;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity(name = "User")
@Access(AccessType.FIELD)
@Table(name = "HA1_User")
public class User {

	@Id
	@SequenceGenerator(name = "USERNR", sequenceName = "USER_SEQ", allocationSize = 2)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
	private int userNr;
	private String name;
	private String mail;
	private long telefon;

	public User() {

	}

	public User(int userNr, String name, String mail, long telefon) {
		super();
		this.userNr = userNr;
		this.name = name;
		this.mail = mail;
		this.telefon = telefon;
	}

	public int getUserNr() {
		return userNr;
	}

	public void setUserNr(int userNr) {
		this.userNr = userNr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public long getTelefon() {
		return telefon;
	}

	public void setTelefon(long telefon) {
		this.telefon = telefon;
	}

	public UserTO toUserTO(User user) {
		UserTO userTO = new UserTO();
		userTO.setUserNr(user.getUserNr());
		userTO.setName(user.getName());
		userTO.setMail(user.getMail());
		userTO.setTelefon(user.getTelefon());
		return userTO;
	}

}
