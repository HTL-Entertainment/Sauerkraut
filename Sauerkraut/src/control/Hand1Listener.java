package control;
import view.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Hand1Listener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		if(Hauptspiel.aktivSpieler == 1) {
			
			//HauptspielGUI.panelHand1Karte1.add(KartenmusterKreaturkarte.kartemachen(0));
			HauptspielGUI.panelHand1Karte1.add(KartenmusterKreaturkarte.kartemachen(0));

			HauptspielGUI.panelHand1.repaint();
			HauptspielGUI.panelHand1.validate();
			HauptspielGUI.panelHand1Karte1.repaint();
			HauptspielGUI.panelHand1Karte1.validate();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
