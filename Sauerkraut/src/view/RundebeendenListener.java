package view;
import control.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RundebeendenListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Hauptspiel.naechsteRunde();

	}

}
