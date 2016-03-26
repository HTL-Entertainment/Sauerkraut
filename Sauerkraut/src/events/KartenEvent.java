package events;

import control.Hauptspiel;
import control.Karten;

/**
 * 
 * @see TodesEvent
 *
 */
public class KartenEvent {

	/** Die Karte, die das Event aufgerufen hat*/
	private Karten karte;
	/** Anzahl der Millisekunden vom Programmstart bis zum Auftreten des Events */
	private long zeitpunkt;
	
	public KartenEvent(Karten _karte) {
		
		zeitpunkt = System.currentTimeMillis() - Hauptspiel.getAnfangsmillis(); 
		karte = _karte;
	}
	
	/** Anzahl der Millisekunden vom Programmstart bis zum Auftreten des Events */
	public long getZeitpunkt() {
		return zeitpunkt;
	}
	
	/** Die Karte, die das Event aufgerufen hat*/
	public Karten getKarte() {
		return karte;
	}
}
