package de.eventverwaltung.user.entity.internal;

import java.util.List;

import de.eventverwaltung.user.entity.UserTO;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity(name="User")
@Access(AccessType.FIELD)
@Table(name="HA1_User")
public class User {

	@Id
	@SequenceGenerator(name="USERNR", sequenceName="USER_SEQ", allocationSize=2)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQ")
	private int userNr;
	private String name;
	private String mail;
	private long telefon;
	
	private List<Integer> events;
	private List<Integer> standorte;
	private List<String> staende;
	
	public User () {
		
	}

	public User(int userNr, String name, String mail, long telefon, List<Integer> events, List<Integer> standorte,
			List<String> staende) {
		super();
		this.userNr = userNr;
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
	
	public UserTO toUserTO (User user) {
		UserTO userTO = new UserTO();
		userTO.setUserNr(user.getUserNr());
		userTO.setName(user.getName());
		userTO.setMail(user.getMail());
		userTO.setTelefon(user.getTelefon());
		return userTO;
	}
	
	
}
