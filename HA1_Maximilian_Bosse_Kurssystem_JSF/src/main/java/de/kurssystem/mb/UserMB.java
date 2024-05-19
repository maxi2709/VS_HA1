package de.kurssystem.mb;

import java.io.Serializable;
import java.util.List;

import de.eventverwaltung.user.entity.UserTO;
import de.eventverwaltung.user.usecase.IUserAnlegen;
import de.eventverwaltung.user.usecase.IUserListeAusgeben;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("userMB")
@SessionScoped
public class UserMB implements Serializable {

	private static final long serialVersionUID = 7324760146148247347L;

	@Inject
	IUserAnlegen iUserAnlegen;

	@Inject
	IUserListeAusgeben iUserListeAusgeben;

	private UserTO selectedUserTO;
	private String name;
	private String mail;
	private long telefon;

	// Counter Seitenwechsel
	private int pageCounter = 0;

	public UserMB() {
	}

	@PostConstruct
	public void initBean() {
		this.name = "";
		this.mail = "";
		this.telefon = 0;
	}

	public String userAnlegenStart() {
		counterErhoehen();
		return "USERANLEGEN";
	}
	
	public List<UserTO> getUserListeAusgeben () {
		return iUserListeAusgeben.userListeAusgeben();
	}

	public String userAnlegen() {
		UserTO userTO = new UserTO(this.name, this.mail, this.telefon);
		iUserAnlegen.userAnlegen(userTO);
		counterErhoehen();
		initBean();
		return "USERVWMENU_ANZEIGEN";
	}

	public String zurueckZumMenue() {
		// Methode für die Navigation zurück zum Hauptmenü
		counterErhoehen();
		return "BACK_TO_HAUPTMENUE";
	}

	public String cancelUserAnlegen() {
		counterErhoehen();
		return "USERVWMENU_ANZEIGEN";
	}

	public UserTO getSelectedUserTO() {
		return selectedUserTO;
	}

	public void setSelectedUserTO(UserTO selectedUserTO) {
		this.selectedUserTO = selectedUserTO;
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

	public int getPageCounter() {
		return pageCounter;
	}

	public void setPageCounter(int pageCounter) {
		this.pageCounter = pageCounter;
	}

	public void counterErhoehen() {
		this.pageCounter = this.pageCounter + 1;
	}

}
