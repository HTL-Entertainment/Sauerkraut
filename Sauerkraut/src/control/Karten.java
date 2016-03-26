package control;

/**
 * 
 * @see Kreaturkarten
 */
public abstract class Karten {

	
	private static int objektanzahl = 0;
	
	/**
	 * Erste Karte hat die ID 0
	 */
	private int kartenid;
	private int objektid;
	private String name;
	private int energie;
	private String kartentext;
	/**
	 * Der Spieler, der die Karte besitzt (Team)
	 */
	private int spieler;
	/**
	 * 1: Kreaturkarte // 2: Zauberkarte // 3: Brettkarte
	 */
	private int kartentyp;
	
	private String bildpfad;
		public Karten(int kartenid, String _name, int _energie, int _kartentyp, String _bildpfad) {
			this.setKartenid(kartenid);
			this.setName(_name);
			this.setEnergie(_energie);
			this.setObjektid(objektanzahl);
			Karten.objektanzahl++;
			this.setKartentyp(_kartentyp);
			this.setBildpfad(_bildpfad);
		}
	
	// Getter und Setter Methoden
	public int getKartenid() {
		return kartenid;
	}
	
	public int getObjektid() {
		return objektid;
	}
	
	public String getName() {
		return name;
	} 
	
	public int getEnergie() {
		return energie;
	}
	
	public int getSpieler() {
		return spieler;
	}
	
	public String getKartentext(){
		return kartentext;
	}
	
	/**
	 * 1: Kreaturkarte // 2: Zauberkarte // 3: Brettkarte
	 */
	public int getKartentyp() {
		return kartentyp;
	}
	
	public String getBildpfad() {
		return bildpfad;
	}
	
	// Setter von Name und ID sind privat damit sie nur der Konstruktor ändern kann.
	// (Setter von Energie ist public damit diese durch Zauberkarten geändert werden kann.)
	private void setKartenid(int kartenid) {
		this.kartenid = kartenid;
	}
	
	private void setObjektid(int objektid) {
		this.objektid = objektid;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	private void setEnergie(int energie) {
		this.energie = energie;
	}
	
	public void setSpieler(int spieler) {
		this.spieler = spieler;
	}
	
	private void setBildpfad(String bildpfad) {
		this.bildpfad = bildpfad;
	}	
	
	/**
	 * 1: Kreaturkarte // 2: Zauberkarte // 3: Brettkarte
	 */
	private void setKartentyp(int kartentyp) {
		this.kartentyp = kartentyp;
	}
	
	public abstract Karten klonen();
	
	public abstract String toString(); 
	
	
}