package events;

/**
 * Falls diese Karte stirbt
 *
 */
public interface ISterbenEventListener {

	/** 
	 * Wird ausgefuehrt, wenn diese Karte stirbt
	 * @param event Gibt Informationen ueber den Tod der Karte weiter 
	 */
	public void eventSterben(TodesEvent event);
	
}
