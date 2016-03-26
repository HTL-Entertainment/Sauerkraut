package control;

import events.KartenEventHandler;
import events.TodesEvent;

/**
 * 
 * @see Karten
 */
public class Kreaturkarten extends Karten {

	// Variabeln
	private int leben;
	private int angriff;
	/** Anzahl der Runden, seit dem sie auf dem Brett ist */
	private int rundenzaehler;
	
	// Konstruktor
	public Kreaturkarten(int _kartenid, String _name, int _energie, int _leben, int _angriff, String _bildpfad) {
		super(_kartenid, _name, _energie, 1, _bildpfad);
		this.setLeben(_leben);
		this.setAngriff(_angriff);
		rundenzaehlerErhoehen();

	}
	
	// Setter und Getter
	public int getLeben() {
		return leben;
	}
	
	public int getAngriff() {
		return angriff;
	}
	
	public int getRundenzaehler() {
		return rundenzaehler;
	}
	
	public void setLeben(int leben) {
		this.leben = leben;
	}
	
	public void setAngriff(int angriff) {
		this.angriff = angriff;
	}
	
	public void rundenzaehlerErhoehen() {
		rundenzaehler++;
	}
	
	
	public void angreifen(Kreaturkarten ziel) {
		
		// Abfragen, welcher Spieler dran ist
		if(this.getSpieler() == Hauptspiel.aktivSpieler) {
			
			if(this.angriff > 0) {
			
				this.setLeben(this.getLeben()-ziel.getAngriff());
				ziel.setLeben(ziel.getLeben()-this.getAngriff());
				Hauptspiel.log("Die Karte " + this.getName() + " (Spieler " + this.getSpieler() + ") hat die Karte " + ziel.getName() + " (Spieler " + ziel.getSpieler() + ") angegriffen");
			}
			if(this.getLeben() <= 0) {
				
				/* Sagt dem EventHandler, dass eine Karte gestorben ist
				 * Um welche Karte es sich handelt (und welche Karte diese Karte getoetet hat) steht im TodesEvent
				 * Der EventHanlder sagt dem Hauptspiel auch, dass die Karte geloescht werden soll 
				*/
				KartenEventHandler.eventTod(new TodesEvent(this, ziel));
				// ALT: Hauptspiel.kreaturkarteZerstoeren(this);
			}
		
			if(ziel.getLeben() <= 0) {
				
				/* Sagt dem EventHandler, dass eine Karte gestorben ist
				 * Um welche Karte es sich handelt (und welche Karte diese Karte getoetet hat) steht im TodesEvent
				 * Der EventHandler sagt dem Hauptspiel auch, dass die Karte geloescht werden soll 
				*/
				KartenEventHandler.eventTod(new TodesEvent(ziel, this));
				// ALT: Hauptspiel.kreaturkarteZerstoeren(ziel);
			}
		}
		else {
			Hauptspiel.log("Die Karte \"" + this + "\" ist eine Karte von Spieler " + this.getSpieler());
		}
	}
	
	/**
	 * Gibt ein neues Kreaturkartenobjekt zurueck, welches die selben Eigenschaften wie dieses hat
	 * @return neues Kreaturkartenobjekt mit selben Eigenschaften
	 */
	public Kreaturkarten klonen() {
		
		return new Kreaturkarten(this.getKartenid(), this.getName(), this.getEnergie(), this.getLeben(), this.getAngriff(), this.getBildpfad());
	}
	
	/**
	 * Gibt einen String mit den wichtigsten Eigenschaften dieser Karte zurueck
	 * Kartenid, Name, Anfangsleben, Energie, Angriff
	 */
	public String toString() {
		return String.format("[%d] %s (%d | %d | %d)", getKartenid(), getName(), getLeben(), getEnergie(), getAngriff());
	}
	
	
	public void Wertegeben(){
		
	}

}