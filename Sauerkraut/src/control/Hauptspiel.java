package control;
import view.*;
import java.util.ArrayList;
import java.util.Random;

import events.*;
import view.HauptspielGUI;
import view.Konsole;

/**
 * 
 * @see Creator
 * @see Karten
 */
public class Hauptspiel {

	/**
	 * Liste mit allen vorhandenen orginalen Karten (hieraus werden die Karten geklont)
	 */
	public static ArrayList<Karten> allekarten = new ArrayList<Karten>();
	/**
	 * Derzeitige Karten im Deck von Spieler 1
	 */
	public static ArrayList<Karten> deck1 = new ArrayList<Karten>();
	/**
	 * Derzeitige Karten im Deck von Spieler 2
	 */
	public static ArrayList<Karten> deck2 = new ArrayList<Karten>();
	/**
	 * Derzeitige Karten in der Hand von Spieler 1
	 */
	public static ArrayList<Karten> hand1 = new ArrayList<Karten>();
	/**
	 * Derzeitige Karten in der Hand von Spieler 2
	 */
	public static ArrayList<Karten> hand2 = new ArrayList<Karten>();
	/**
	 * Alle Karten auf dem Brett von Spieler 1
	 */
	public static ArrayList<Karten> brett1 = new ArrayList<Karten>();
	
	/** Alle Karten auf dem Brett von Spieler 2 */
	public static ArrayList<Karten> brett2 = new ArrayList<Karten>();
	
	public static Random zufall = new Random();
	/**
	 * 2 int Dimensionen: 
	 * 1: Nummer von den vorgefertigten Decks
	 * 2: Nummer von jeder Karte in dem Deck
	 */
	static int[][] decks = new int[2][1];
	
	/**
	 * Die Nummer von dem Deck, das Spieler 1 ausgewaehlt hat
	 */
	public static int deckspieler1 = 0;
	/**
	 * Die Nummer von dem Deck, das Spieler 2 ausgewaehlt hat
	 */
	public static int deckspieler2 = 1;
	
	/**
	 * Der Spieler. der zurzeit dran ist (1 = Spieler 1; 2 = Spieler 2)
	 */
	public static int aktivSpieler = 1;
	/**
	 * Die aktuelle Rundenanzahl, wobei 1. Runde = 0 ist
	 */
	private static int rundenzaehler = 0;
	
	/**
	 * Der maximale Energiewert fuer diese Runde
	 */
	private static int maxenergie;
	/**
	 * Die derzeitig noch verfuegbare Energieanzahl in dieser Runde
	 */
	private static int spielerbareenergie;
	
	public static Konsole konsolenframe;
	
	/**
	 * Die Zeit vom 1.1.1970 bis zum Programmstart in Millisekunden
	 */
	private static long anfangsmillis;
	
	/**
	 * GUI
	 */
	public static HauptspielGUI frame;
	
	/**
	 * ka was des is
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		anfangsmillis = System.currentTimeMillis();
		/* Test: */// Deckwaehler.los();
		/* Test: */ Konsole.los();
		
		frame = new HauptspielGUI();
		frame.setVisible(true);
		
		Creator.createKreaturkarten();
		Creator.createDecks();
		deck1Erstellen();
		deck2Erstellen();
		
		setMaxenergie(1);
		setSpielerbareenergie(getMaxenergie());
		rundenzaehler = 0;
		/*
		karteZiehen();
		karteSpielen(2);
		naechsteRunde();
		karteZiehen();
		karteZiehen();
		naechsteRunde();
		naechsteRunde();
		karteSpielen(3);
		naechsteRunde();
		((Kreaturkarten) brett.get(1)).angreifen(((Kreaturkarten) brett.get(0)));
		*/
	}
	
	// SETTER UND GETTER
	/**
	 * Die aktuelle Rundenanzahl, wobei 1. Runde = 0 ist
	 */
	public static int getRundenzaehler() {
		return rundenzaehler;
	}
	
	/**
	 * Die Zeit vom 1.1.1970 bis zum Programmstart in Millisekunden
	 */
	public static long getAnfangsmillis() {
		return anfangsmillis;
	}
	
	/**
	 * Die derzeitig noch verfuegbare Energieanzahl in dieser Runde
	 */
	public static int getSpielerbareenergie() {
		return spielerbareenergie;
	}
	
	/**
	 * Der maximale Energiewert fuer diese Runde
	 */
	public static int getMaxenergie() {
		return maxenergie;
	}
	
	/**
	 * Die derzeitig noch verfuegbare Energieanzahl in dieser Runde
	 */
	public static void setSpielerbareenergie(int spielerbareenergie) {
		Hauptspiel.spielerbareenergie = spielerbareenergie;
	}
	
	/**
	 * Der maximale Energiewert fuer diese Runde
	 */
	public static void setMaxenergie(int maxenergie) {
		Hauptspiel.maxenergie = maxenergie;
	}
	
	
	/**
	 * Gibt einen Text in der Konsole mit der vergangenen Zeit seit Programmstart
	 * in Stunden, Minuten, Sekunden und Millisekunden in einer bestimmten Farbe aus
	 * 
	 * --- Empfohlene Farben ---
	 * Normaler Spielverlauf: #3a3a3a (Dunkelrau)
	 * Error: #FF0000 (Rot)
	 * Effekte/Events: #c600ff (Violett)
	 * Creator: #00a83f (Dunkelgruen)
	 * Neue Runde: #a49302 (Dunkelgelb / Ocker)
	 * 
	 * @param text Text, den man in der Konsole ausgeben will
	 * @param farbe Hexerdezimalcode der gewollten Farbe (zBsp: #FF0000)
	 */
	public static void log(String text, String farbe) {
		
		long zeit = System.currentTimeMillis() - Hauptspiel.anfangsmillis;
		// Text fuer das Konsolenfenster
		String formattext = String.format("<p color=\"%s\">[%d:%d:%d:%d]: %s <br></p>", farbe, ((zeit/1000)/60)/60, (zeit/1000)/60, zeit/1000, zeit, text);
		// Text fuer die eingebaute JAVA Konsole CHANGEBUILD: in Build Version entfernen
		String systemkonsolentext = String.format("[%d:%d:%d:%d]: %s \n", ((zeit/1000)/60)/60, (zeit/1000)/60, zeit/1000, zeit, text);
		System.out.print(systemkonsolentext);
		Konsole.konsolentext = Konsole.konsolentext + formattext;
		//try {
		konsolenframe.labelKonsole.setText(Konsole.konsolentext);
		//}
		//catch(NullPointerException e) {}
	}
	
	/**
	 * Gibt einen Text in der Konsole mit der vergangenen Zeit seit Programmstart
	 * in Stunden, Minuten, Sekunden und Millisekunden in der Defaultfarbe (dunkelgrau) aus
	 * 
	 * @param text Text, den man in der Konsole ausgeben will
	 */
	public static void log(String text) {
		
		log(text, "#3a3a3a");
	}
	
	public static void karteZiehen() {
		
		int zufallszahl = zufall.nextInt(1);
		
		if(aktivSpieler == 1) {
			
			if(hand1.size() < 5 && deck1.size() > 0) {
				hand1.add(deck1.get(zufallszahl));
				deck1.remove(zufallszahl);
				log("Spieler 1 hat eine Karte gezogen. Spieler 1 hat nun " + hand1.size() + " Karten auf der Hand und " + deck1.size() + " Karten im Deck");
			}
			else {
				log("Spieler 1 konnte keine Karte ziehen, da er schon " + hand1.size() + " Karten auf der Hand hat oder weil keine Karten im Deck mehr uebrig sind");
			}
		}
		else {
			if(hand2.size() < 5 && deck2.size() > 0) {
				hand2.add(deck2.get(zufallszahl));
				deck2.remove(zufallszahl);
				log("Spieler 2 hat eine Karte gezogen. Spieler 2 hat nun " + hand2.size() + " Karten auf der Hand und " + deck2.size() + " Karten im Deck");
			}
			else {
				log("Spieler 2 konnte keine Karte ziehen, da er schon " + hand2.size() + " Karten auf der Hand hat oder weil keine Karten im Deck mehr uebrig sind");
			}
		}
	}
	
	public static void karteSpielen(int objektid) {
		
		// TODO: Die Karte in die EventHandlerListe schreiben (nur bei Kreaturkarte mit Effekt)
		
		boolean karteGespielt = false;
			
		if(aktivSpieler == 1) {
			
			for(int i = 0; i < hand1.size(); i++) {

				if(hand1.get(i).getObjektid() == objektid) {
					
					if(hand1.get(i).getEnergie() > getSpielerbareenergie()) {
						log("Karte ist zu teuer (Spieler 1)");
						karteGespielt = true;
						break;
					}
					else {
						setSpielerbareenergie(getSpielerbareenergie() - hand1.get(i).getEnergie());
						log("Spieler 1 hat die Karte \"" + hand1.get(i) + "\" gespielt und hat jetzt noch " + getSpielerbareenergie() + " Energie");
						brett1.add(hand1.get(i));
						hand1.remove(i);
						log("Spieler 1 hat " + hand1.size() + " Karten auf der Hand und es sind jetzt " + brett1.size() + " Karten auf dem Brett von Spieler 1");
						// TODO: hier GUI
						karteGespielt = true;
						break;
					}
				}
			}
			if(!karteGespielt) {
				log("ERROR: Spieler 1 wollte eine Karte spielen, die nicht auf seiner Hand war", "#FF0000");
			}
			karteGespielt = false;
		}
		else {
			
			for(int i = 0; i < hand2.size(); i++) {
				
				if(hand2.get(i).getObjektid() == objektid) {
					
					if(hand2.get(i).getEnergie() > getSpielerbareenergie()) {
						log("Karte ist zu teuer (Spieler 2)");
						karteGespielt = true;
						break;
					}
					else {
						setSpielerbareenergie(getSpielerbareenergie() - hand2.get(i).getEnergie());
						log("Spieler 2 hat die Karte \"" + hand2.get(i) + "\" gespielt und hat jetzt noch " + getSpielerbareenergie() + " Energie");
						brett2.add(hand2.get(i));
						hand2.remove(i);
						log("Spieler 2 hat " + hand2.size() + " Karten auf der Hand und es sind jetzt " + brett2.size() + " Karten auf dem Brett von Spieler 2");
						// hier GUI
						karteGespielt = true;
						break;
					}
				}
			}
			if(!karteGespielt) {
				log("ERROR: Spieler 2 wollte eine Karte spielen, die nicht auf seiner Hand war", "#FF0000");
			}
			karteGespielt = false;
		}
		
	}
	
	public static void naechsteRunde() {
		
		if(aktivSpieler == 1) aktivSpieler = 2;
		else aktivSpieler = 1;
		rundenzaehler++;
		if(rundenzaehler % 2 == 0) {
			setMaxenergie(getMaxenergie() + 1);
		}
		setSpielerbareenergie(getMaxenergie());
		log("Die " + (getRundenzaehler() + 1) + ". Runde wurde nun gestartet und die Energie fuer diese Runde ist " + getMaxenergie(), "#a49302");
		log("Spieler " + aktivSpieler + " ist am Zug", "#a49302");
	}
	
	public static void kreaturkarteZerstoeren(Kreaturkarten ziel) {
		
		if(ziel.getSpieler() == 1) {
			
			brett1.remove(ziel);
			log("Die Karte " + ziel + " von Spieler " + ziel.getSpieler() + " wurde zerstoert");
			log("Es sind jetzt " + brett1.size() + " Karten auf dem Brett von Spieler 1");
		}
		else {
			
			brett2.remove(ziel);
			log("Die Karte " + ziel + " von Spieler " + ziel.getSpieler() + " wurde zerstoert");
			log("Es sind jetzt " + brett2.size() + " Karten auf dem Brett von Spieler 2");
		}
		
		// TODO: Hier Karte im GUI loeschen
	}
	
	
	// Decks fuellen
	public static void deck1Erstellen() {
		
		log("Deck 1 wird gefuellt", "#00a83f");
		
		for(int i = 0; i < 1; i++) {
			/*
			 * Typ 1: Kreaturkarte
			 * Typ 2: Zauberkarte
			 * Typ 3: Brettkarte
			 * 
			 * Konstruktor von Kreaturkarten: int _kartenid, String _name, int _energie, int _leben, int _angriff
			 */
			switch(allekarten.get(i).getKartentyp()) {
				case 1: deck1.add( ((Kreaturkarten) allekarten.get(decks[deckspieler1][i])).klonen() ); break;
				case 2: break;
				case 3: break;
			}
			log("Die Karte \"" + deck1.get(i) + "\" wurde dem Deck 1 hinzugefuegt", "#00a83f");
		}
		
		for(int i = 0; i < deck1.size(); i++) {
			
			deck1.get(i).setSpieler(1);
		}
		
		log("Deck 1 wurde gefuellt", "#00a83f");
	}
	
	public static void deck2Erstellen() {
		
		log("Deck 2 wird gefuellt", "#00a83f");
		
		for(int i = 0; i < 1; i++) {
			
			// Konstruktor von Kreaturkarten: int _kartenid, String _name, int _energie, int _leben, int _angriff
			switch(allekarten.get(i).getKartentyp()) {
				case 1: deck2.add( ((Kreaturkarten) allekarten.get(decks[deckspieler2][i])).klonen() ); break;
				case 2: break;
				case 3: break;
			}
			log("Die Karte \"" + deck2.get(i) + "\" wurde dem Deck 2 hinzugefuegt", "#00a83f");
		}
		
		for(int i = 0; i < deck2.size(); i++) {
			
			deck2.get(i).setSpieler(2);
		}
		
		log("Deck 2 wurde gefuellt", "#00a83f");
	}
}