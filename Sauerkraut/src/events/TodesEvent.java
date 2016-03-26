package events;

import control.Karten;

/**
 * 
 * @see KartenEvent
 */
public class TodesEvent extends KartenEvent {

	/** Die Karte, die die andere Karte zerstoert hat */ 
	Karten gegnerkarte;
	
	public TodesEvent(Karten _karte, Karten _gegnerkarte) {
		super(_karte);
		gegnerkarte = _gegnerkarte;
	}
}
