package events;

import java.util.ArrayList;

import control.*;

/**
 *
 */
public class KartenEventHandler {

	/** Liste mit allen Effekten, die ausgefuehrt werden, wenn eine andere Kreaturkarte stirbt
	 * Hier werden nur die Effekte der Kreaturkarten gespeichert, nicht die Kreaturkarte selber **/
	
	public static ArrayList<ITodesEventListener> listeTodesEffekte = new ArrayList<ITodesEventListener>();
	
	/** Liste mit allen Effekten, die ausgefuehrt werden, wenn eine neue Runde beginnt
	 * Hier werden nur die Effekte der Kreaturkarten gespeichert, nicht die Kreaturkarte selber 
	 * **/
	
	public static ArrayList<IRundenEventListener> listeRundenEffekte = new ArrayList<IRundenEventListener>();
	
	/** 
	 * Liste mit allen Effekten, die ausgefuehrt werden, wenn die KArte dieses Effekts stirbt
	 * Hier werden nur die Effekte der Kreaturkarten gespeichert, nicht die Kreaturkarte selber 
	 * */
	public static ArrayList<ISterbenEventListener> listeSterbensEffekte = new ArrayList<ISterbenEventListener>();
	
	/**
	 * Wird ausgefuehrt, wenn eine neue Runde startet
	 * Informationen dazu sind in der Hauptspiel Klasse als statische Variablen (rundenanzahl, aktivspieler, etc)
	 * Es werden alle Rundeneffekte der Karten auf dem Brett ausgefuehrt
	 */
	public static void eventNeueRunde() {
		
		for(IRundenEventListener effektobjekt : listeRundenEffekte) {
			
			effektobjekt.eventNeueRunde();
		}
	}
	
	/**
	 * Wird ausgefuehrt, wenn eine Karte auf dem Brett sirbt
	 * Informationen zu dem Tod der Karte stehen im event
	 * Es werden alle Todeseffekte der Karten auf dem Brett ausgefuehrt
	 * 
	 * @param event Gibt Informationen ueber den Tod einer Karte (welche Karte gestorben ist, wann sie gestorben ist, etc)
	 */
	public static void eventTod(TodesEvent event) {
		
		// TODO: Die Karte, die stirbt, muss aus den EffektenListen entfernt werden
		
		if(listeSterbensEffekte.contains(event.getKarte())) ((ISterbenEventListener) event.getKarte()).eventSterben(event);
		Hauptspiel.kreaturkarteZerstoeren((Kreaturkarten) event.getKarte());
		karteAusListenEntfernen(event.getKarte());
		
		for(ITodesEventListener effektobjekt : listeTodesEffekte) {
			
			effektobjekt.eventTod(event);
		}
	}
	
	/**
	 * Loescht die angegebene Karte aus allen Effekt-Listen, damit zB die Karte nach ihrem Tod 
	 * keine weiteren Events ausloesen kann
	 */
	public static void karteAusListenEntfernen(Karten karte) {
		
		String listen = "";
		if(listeTodesEffekte.remove(karte)) listen += " TodesEffekte; ";
		if(listeRundenEffekte.remove(karte)) listen += " RundenEffekte; ";
		if(listeSterbensEffekte.remove(karte)) listen += " SterbensEffekte ";
		// TODO: Weitere Listen mit diesem Schema hinzufuegen
		
		Hauptspiel.log("Die Karte \"" + karte + "\" wurde von folgenden Effektlisten entfernt: \n" + listen, "#c600ff");
	}
	
}