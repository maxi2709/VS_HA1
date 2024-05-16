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
public class UserMB implements Serializable{
	
	private static final long serialVersionUID = 7324760146148247347L;

	@Inject
	IUserAnlegen iUserAnlegen;
	
	@Inject
	IUserListeAusgeben iUserListeAusgeben;

	private UserTO selectedUserTO;
	private String name;
	private String mail;
	private long telefon;



	public UserMB() {
	}

	@PostConstruct
	public void initBean() {
		
	}

	public String userAnlegenStart() {
		return "USERANLEGEN";
	}

	public String userAnlegen() {
		UserTO userTO = new UserTO(this.name, this.mail, this.telefon, null, null, null);
		iUserAnlegen.userAnlegen(userTO);
		return "USERVWMENU_ANZEIGEN";
	}

	public String zurueckZumMenue() {
		// Methode für die Navigation zurück zum Hauptmenü
		return "BACK_TO_HAUPTMENUE";
	}

	public String cancelUserAnlegen() {
		return "USERVWMENU_ANZEIGEN";
	}

	public List<UserTO> getUserListeAusgeben() {
		return iUserListeAusgeben.userListeAusgeben();
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
	
	

}
