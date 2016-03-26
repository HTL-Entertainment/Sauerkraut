package control;

import effects.IEffektFuerKreaturkarte;

/**
 * 
 * @see Hauptspiel
 */
public class Creator {
	
	// Konstruktor von Kreaturkarten: int _kartenid, String _name, int _energie, int _leben, int _angriff
	public static void createKreaturkarten() {
		
		Hauptspiel.log("Kreaturkarten werden erstellt", "#00a83f");
		
		Hauptspiel.allekarten.add(new Kreaturkarten(0, "Roter Drache", 1, 5, 5, "pictures\\bild1.png"));
		Hauptspiel.allekarten.add(new Kreaturkarten(1, "Eisdrache", 2, 6, 5, "pictures\\bild2.png"));
		// TODO weitere Kreaturkarten erstellen
		
		Hauptspiel.log("Kreaturkarten wurden erstellt", "#00a83f");
		Hauptspiel.log("Kreaturkarten mit Effekt werden erstellt", "#00a83f");
		
		createKreaturkartenMitEffekt();
		
		Hauptspiel.log("Kreaturkarten mit Effekt wurden erstellt", "#00a83f");
	}
	
	// Konstruktor von Kreaturkarten mit Effekt: int _kartenid, String _name, int _energie, int _leben, int _angriff, String _bildpfad, IEffektFuerKreaturkarte _karteneffekt)
	public static void createKreaturkartenMitEffekt() {
		// TODO Kreaturkarten mit Effekt erstellen
	}
	
	public static void createDecks() {
		
		Hauptspiel.decks[0][0] = 0;
		Hauptspiel.decks[1][0] = 1;
	}
	
	public static void createZauberkarten() {
		// TODO
	}
	
	public static void createBrettkarten() {
		// TODO
	}
	
}