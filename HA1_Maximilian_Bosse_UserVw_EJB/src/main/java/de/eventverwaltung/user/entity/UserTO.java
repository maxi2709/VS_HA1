package de.eventverwaltung.user.entity;

import java.io.Serializable;
import java.util.List;

import de.eventverwaltung.user.entity.internal.User;

public class UserTO implements Serializable{

	private static final long serialVersionUID = -2084017943145521358L;
	
	private int userNr;
	private String name;
	private String mail;
	private long telefon;
	
	private List<Integer> events;
	private List<Integer> standorte;
	private List<String> staende;
	
	public UserTO() {
		
	}

	public UserTO(String name, String mail, long telefon, List<Integer> events, List<Integer> standorte,
			List<String> staende) {
		super();
		this.name = name;
		this.mail = mail;
		this.telefon = telefon;
		this.events = events;
		this.standorte = standorte;
		this.staende = staende;
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

	public List<Integer> getEvents() {
		return events;
	}

	public void setEvents(List<Integer> events) {
		this.events = events;
	}

	public List<Integer> getStandorte() {
		return standorte;
	}

	public void setStandorte(List<Integer> standorte) {
		this.standorte = standorte;
	}

	public List<String> getStaende() {
		return staende;
	}

	public void setStaende(List<String> staende) {
		this.staende = staende;
	}

	public User toUser(UserTO userTO) {
		User user = new User();
		user.setUserNr(userTO.getUserNr());
		user.setName(userTO.getName());
		user.setMail(userTO.getMail());
		user.setTelefon(userTO.getTelefon());
		
		return user;
	}
}
