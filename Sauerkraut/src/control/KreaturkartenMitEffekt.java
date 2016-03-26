package control;

import effects.*;

public class KreaturkartenMitEffekt extends Kreaturkarten {

	private IEffektFuerKreaturkarte karteneffekt;
	
	public KreaturkartenMitEffekt(int _kartenid, String _name, int _energie, int _leben, int _angriff, String _bildpfad, IEffektFuerKreaturkarte _karteneffekt) {
		super(_kartenid, _name, _energie, _leben, _angriff, _bildpfad);
		setKarteneffekt(_karteneffekt);
	}
	
	/**
	 * public, weil man Karteneffekt ev im Verlauf der Runde aendern koennte
	 * @param _karteneffekt
	 */
	public void setKarteneffekt(IEffektFuerKreaturkarte _karteneffekt) {
		karteneffekt = _karteneffekt;
	}

	public IEffektFuerKreaturkarte getKarteneffekt() {
		return karteneffekt;
	}
}
