package de.kurssystem.mb;

import java.util.Date;
import java.util.List;
import java.util.Map;

import de.eventverwaltung.event.entity.EventTO;
import de.eventverwaltung.event.usecase.IEventAnlegen;
import de.eventverwaltung.event.usecase.IEventBearbeiten;
import de.eventverwaltung.event.usecase.IEventLoeschen;
import de.eventverwaltung.event.usecase.IEventlisteErstellen;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("eventMB")
@RequestScoped
public class EventMB {

	@Inject
	IEventAnlegen iEventAnlegen;

	@Inject
	IEventlisteErstellen iEventlisteErstellen;
	
	@Inject 
	IEventBearbeiten iEventBearbeiten;
	
	@Inject
	IEventLoeschen iEventLoeschen;

	private String eventName;
	private Date eventDatum;
	private Date anmeldeStartDatum;
	private Date anmeldeEndeDatum;
	private EventTO eventTO;
	private List<EventTO> eventList;
	private String selectedEventNr;
	private EventTO selectedEventTO;

	public EventMB() {
	}

	@PostConstruct
	public void initBean() {

	}

	public String eventAnlegen() {
		EventTO eventTO = new EventTO(this.eventName, this.eventDatum, this.anmeldeStartDatum, this.anmeldeEndeDatum);
		iEventAnlegen.eventAnlegen(eventTO);
		return "EVENTVW_MENUE";
	}

	public List<EventTO> getEventliste() {
		return iEventlisteErstellen.eventlisteAusgeben();
	}
	
	public String updateEventStart() {
		return "EVENT_BEARBEITEN";
	}
	
	public String updateEventCommit () {
		iEventBearbeiten.eventSpeichern(this.selectedEventTO);
		return "EVENTLISTE_ANZEIGEN";
	}
	public String cancelEventList() {
		return "BACK_TO_HAUPTMENUE";
	}
	
	public String cancelUpdateEvent() {
		return "EVENTLISTE_ANZEIGEN";
	}
	
	public void eventLoeschen() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		this.selectedEventNr = params.get("selectedEventNr");
		sendInfoMessageToUser(this.selectedEventNr);
		try {
			iEventLoeschen.eventLoeschen(Integer.valueOf(this.selectedEventNr));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return "BACK_TO_HAUPTMENUE";
	}
	
	

	public String starteEventAnlegen() {
		// Füge hier die Logik zum Anlegen eines Events hinzu
		// sendInfoMessageToUser("Zu Event Anlegen navigieren.");
		return "EVENT_ANLEGEN";
	}

	public String zeigeEventliste() {
		// Logik für die Anzeige der Eventliste
		return "EVENTLISTE_ANZEIGEN";
	}

	public String eventBuchen() {
		// Füge hier die Logik zum Buchen eines Events ein
		sendInfoMessageToUser("Event erfolgreich gebucht.");
		return "eventGebucht"; // Oder eine andere passende View
	}

	public String userFuerEventAnzeigen() {
		// Logik zum Anzeigen von Usern für ein Event
		return "userAngezeigt"; // Oder eine andere passende View
	}

	public String userLoeschen() {
		// Logik zum Löschen eines Users
		sendInfoMessageToUser("User erfolgreich gelöscht.");
		return "userGeloescht"; // Oder eine andere passende View
	}

	public String zurueckZumMenue() {
		// Methode für die Navigation zurück zum Hauptmenü
		return "BACK_TO_HAUPTMENUE";
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

	public EventTO getEventTO() {
		return eventTO;
	}

	public void setEventTO(EventTO eventTO) {
		this.eventTO = eventTO;
	}

	public List<EventTO> getEventList() {
		return eventList;
	}

	public void setEventList(List<EventTO> eventList) {
		this.eventList = eventList;
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
	
	
	
}