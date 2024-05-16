package de.kurssystem.mb;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import de.eventverwalter.buchung.usecase.IBuchungErstellen;
import de.eventverwaltung.event.entity.Stand.StandTO;
import de.eventverwaltung.event.entity.event.EventTO;
import de.eventverwaltung.event.entity.standort.StandortTO;
import de.eventverwaltung.event.usecase.IEventAnlegen;
import de.eventverwaltung.event.usecase.IEventBearbeiten;
import de.eventverwaltung.event.usecase.IEventLoeschen;
import de.eventverwaltung.event.usecase.IEventlisteErstellen;
import de.eventverwaltung.event.usecase.IStandlisteErstellen;
import de.eventverwaltung.event.usecase.IStandortHinzufuegen;
import de.eventverwaltung.event.usecase.IStandortlisteErstellen;
import de.eventverwaltung.user.entity.UserTO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("eventMB")
@SessionScoped
public class EventMB implements Serializable {

	private static final long serialVersionUID = 8047058534306877698L;

	@Inject
	IEventAnlegen iEventAnlegen;

	@Inject
	IEventlisteErstellen iEventlisteErstellen;

	@Inject
	IEventBearbeiten iEventBearbeiten;

	@Inject
	IEventLoeschen iEventLoeschen;
	@Inject
	IStandortHinzufuegen iStandortHinzufuegen;

	@Inject
	IStandortlisteErstellen iStandortlisteErstellen;

	@Inject
	IBuchungErstellen iBuchungErstellen;

	@Inject
	IStandlisteErstellen iStandlisteErstellen;

	// Variablen events
	private String eventName;
	private Date eventDatum;
	private Date anmeldeStartDatum;
	private Date anmeldeEndeDatum;
	private String selectedEventNr;
	private EventTO selectedEventTO;

	// Variablen Standort
	private StandortTO selectedStandortTO;
	private String standortName;
	private int anzahlBuehne;
	private int anzahlGetraenkestand;
	private int anzahlEssenstand;
	private String selectedStand;

	// Variablen User
	private UserTO selectedUser;

	public EventMB() {
	}

	@PostConstruct
	public void initBean() {
		selectedEventTO = new EventTO();
		selectedStandortTO = new StandortTO();
		selectedUser = new UserTO();
		this.standortName = "";
		this.eventName = "";
		this.eventDatum = null;
		this.anmeldeStartDatum = null;
		this.anmeldeEndeDatum = null;
		this.anzahlBuehne = 0;
		this.anzahlGetraenkestand = 0;
		this.anzahlEssenstand = 0;

	}

	// Zurück zum Hauptmenu
	public String zurueckZumMenue() {
		// Methode für die Navigation zurück zum Hauptmenü
		return "BACK_TO_HAUPTMENUE";
	}

	// Event anlegen starten
	public String starteEventAnlegen() {
		return "EVENT_ANLEGEN";
	}

	// Event anlegen
	public String eventAnlegen() {
		EventTO eventTO = new EventTO(this.eventName, this.eventDatum, this.anmeldeStartDatum, this.anmeldeEndeDatum);
		iEventAnlegen.eventAnlegen(eventTO);
		this.initBean();
		return "EVENTVW_MENUE";
	}

	// Eventliste anzeigen start
	public String zeigeEventliste() {
		return "EVENTLISTE_ANZEIGEN";
	}

	// Eventliste ausgeben
	public List<EventTO> getEventliste() {
		return iEventlisteErstellen.eventlisteAusgeben();
	}

	// Event Standort hinzufügen start
	public String standortHinzufuegenStart() {
		return "STANDORT_HINZUFUEGEN";
	}

	// Event Standort hinzufügen
	public String standortHinzufuegenCommit() {
		iStandortHinzufuegen.standortHinzufuegen(this.selectedEventTO, standortName, anzahlBuehne, anzahlGetraenkestand,
				anzahlEssenstand);
		this.initBean();
		return "EVENTLISTE_ANZEIGEN";
	}

	// Zurück Standort hinzufügen
	public String cancelStandortHinzufuegen() {
		return "EVENTLISTE_ANZEIGEN";
	}

	// Event bearbeiten start
	public String updateEventStart() {
		return "EVENT_BEARBEITEN";
	}

	// Standort ändern
	public String updateEventCommit() {
		iEventBearbeiten.eventSpeichern(this.selectedEventTO);
		this.initBean();
		return "EVENTLISTE_ANZEIGEN";
	}

	// Zurück Event ändern
	public String cancelUpdateEvent() {
		return "EVENTLISTE_ANZEIGEN";
	}

	// Event löschen start
	public String eventLoeschenStart() {
		return "EVENT_LOESCHEN";
	}

	// Event löschen
	public String eventLoeschen() {
		if (iEventLoeschen.eventLoeschen(selectedEventTO) == true) {
			sendErrorMessageToUser("Das Event " + this.selectedEventTO.getEventName()
					+ " kann nicht gelöscht werden, da es einem Standort zugeordnet ist");
		}
		return "EVENTLISTE_ANZEIGEN";
	}

	// Zurück Event löschen
	public String cancelDeleteEvent() {
		return "EVENTLISTE_ANZEIGEN";
	}

	// Events buchen starten
	public String buchbareEvents() {
		return "EVENTS_BUCHBAR";
	}

	// Liste aller buchbarer Events
	public List<EventTO> getEventlisteBuchen() {
		return iEventlisteErstellen.eventlisteAusgebenBuchen();
	}

	// Zurück Event buchen
	public String cancelEventBuchen() {
		return "EVENTVW_MENUE";
	}

	// Standorte pro Event starten
	public String standortProEvent() {
		return "STANDORT_PRO_EVENT";
	}

	// Standorte pro Event ausgeben
	public List<StandortTO> getStandorteProEvent() {
		return iStandortlisteErstellen.standortListeBuchen(this.selectedEventTO.getEventNr());
	}

	//Zurück Standorte pro Event
	public String cancelStandortListeBuchen() {
		return "BUCHBARE_EVENTS";
	}
	
	//Starte buchbare Staende
	public String startBuchbareStaende () {
		return "BUCHBARE_STAENDE";
	}

	//Liste Stande pro Standort
	public List<StandTO> getBuchbareStaendeList() {
		return iStandlisteErstellen.buchbareStaendeAusgeben(selectedStandortTO);
	}
	
	//Staende auswaehlen zurück
	public String cancelStandAuswaehlen () {
		return "STANDORT_LIST_PRO_EVENT";
	}

	// User auswaehlen für Buchung
	public String userAuswaehlenBuchen() {
		return "USER_AUSWAEHLEN_BUCHUNG";
	}

	// Buchung erstellen start und commit
	public String buchungErstellen() {
		iBuchungErstellen.buchungErstellen(this.selectedEventTO.getEventNr(), this.selectedStandortTO.getStandortNr(),
				this.selectedStand, this.selectedUser.getUserNr());
		sendInfoMessageToUser(this.selectedEventTO.getEventNr() + " + " + this.selectedStandortTO.getStandortNr()
				+ " + " + this.selectedStand + " + " + this.selectedUser.getUserNr());
		this.initBean();
		return "EVENTVW_MENU";
	}

	// User hinzufügen zurück
	public String cancelUserHinzufuegen() {
		return "STANDORT_PRO_EVENT";
	}

	private void sendInfoMessageToUser(String message) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
	}

	private void sendErrorMessageToUser(String message) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getAnmeldeStartDatum() {
		return anmeldeStartDatum;
	}

	public void setAnmeldeStartDatum(Date anmeldeStartDatum) {
		this.anmeldeStartDatum = anmeldeStartDatum;
	}

	public Date getAnmeldeEndeDatum() {
		return anmeldeEndeDatum;
	}

	public void setAnmeldeEndeDatum(Date anmeldeEndeDatum) {
		this.anmeldeEndeDatum = anmeldeEndeDatum;
	}

	public Date getEventDatum() {
		return eventDatum;
	}

	public void setEventDatum(Date eventDatum) {
		this.eventDatum = eventDatum;
	}

	public String getSelectedEventNr() {
		return selectedEventNr;
	}

	public void setSelectedEventNr(String selectedEventNr) {
		this.selectedEventNr = selectedEventNr;
	}

	public EventTO getSelectedEventTO() {
		return selectedEventTO;
	}

	public void setSelectedEventTO(EventTO selectedEventTO) {
		this.selectedEventTO = selectedEventTO;
	}

	public String getStandortName() {
		return standortName;
	}

	public void setStandortName(String standortName) {
		this.standortName = standortName;
	}

	public int getAnzahlBuehne() {
		return anzahlBuehne;
	}

	public void setAnzahlBuehne(int anzahlBuehne) {
		this.anzahlBuehne = anzahlBuehne;
	}

	public int getAnzahlGetraenkestand() {
		return anzahlGetraenkestand;
	}

	public void setAnzahlGetraenkestand(int anzahlGetraenkestand) {
		this.anzahlGetraenkestand = anzahlGetraenkestand;
	}

	public int getAnzahlEssenstand() {
		return anzahlEssenstand;
	}

	public void setAnzahlEssenstand(int anzahlEssenstand) {
		this.anzahlEssenstand = anzahlEssenstand;
	}

	public StandortTO getSelectedStandortTO() {
		return selectedStandortTO;
	}

	public void setSelectedStandortTO(StandortTO selectedStandortTO) {
		this.selectedStandortTO = selectedStandortTO;
	}

	public String getSelectedStand() {
		return selectedStand;
	}

	public void setSelectedStand(String selectedStand) {
		this.selectedStand = selectedStand;
	}

	public UserTO getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserTO selectedUser) {
		this.selectedUser = selectedUser;
	}

	

}