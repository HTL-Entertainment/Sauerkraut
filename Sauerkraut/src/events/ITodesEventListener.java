package events;

/**
 * Fuer alle Effekte, die ausgefuehrt werden, wenn eine andere Karte stirbt
 *
 */
public interface ITodesEventListener {

	/** 
	 * Wird ausgefuehrt, wenn eine andere Karte stirbt
	 * @param event Gibt Informationen ueber den Tod der Karte weiter 
	 */
	public void eventTod(TodesEvent event);
	
}