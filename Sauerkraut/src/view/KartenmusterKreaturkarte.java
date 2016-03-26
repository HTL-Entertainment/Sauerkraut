package view;
import control.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.swing.SwingConstants;

public class KartenmusterKreaturkarte extends JPanel {
	private JPanel panelLEA;
	private JPanel panelText;
	private JLabel lblKarteneffekt;
	private JLabel lblLeben;
	private JLabel lblEnergie;
	private JLabel lblAngriff;
	private JPanel panelBild;
	private JLabel lblBild;
	private String KartenmusterKreaturkarteObjektid;
	

	/**
	 * Create the panel.
	 */
	/*
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.add(new Kartenmuster());
		frame.setVisible(true);
	}
	*/
	public KartenmusterKreaturkarte() {

		initialize();
	}
	private void initialize() {
		
		setLayout(new BorderLayout(0, 0));
		
		
		panelBild = new JPanel();
		add(panelBild, BorderLayout.NORTH);
		panelBild.setVisible(true);
		
		lblBild = new JLabel("Bild");
		panelBild.add(lblBild);
		lblBild.setVisible(true);
		
		panelText = new JPanel();
		add(panelText, BorderLayout.CENTER);
		//panelText.setVisible(false);
		panelText.setVisible(true);
		
		lblKarteneffekt = new JLabel("Karteneffekt");
		panelText.add(lblKarteneffekt);
		lblKarteneffekt.setVisible(true);
		
		panelLEA = new JPanel();
		add(panelLEA, BorderLayout.SOUTH);
		panelLEA.setLayout(new GridLayout(0, 3, 0, 0));
		//panelLEA.setVisible(false);
		panelLEA.setVisible(true);
		
		lblLeben = new JLabel("L");
		lblLeben.setHorizontalAlignment(SwingConstants.CENTER);
		panelLEA.add(lblLeben);
		lblLeben.setVisible(true);
		
		lblEnergie = new JLabel("E");
		lblEnergie.setHorizontalAlignment(SwingConstants.CENTER);
		panelLEA.add(lblEnergie);
		lblEnergie.setVisible(true);
		
		lblAngriff = new JLabel("A");
		lblAngriff.setHorizontalAlignment(SwingConstants.CENTER);
		panelLEA.add(lblAngriff);
		lblAngriff.setVisible(true);
		
	}
	
	public void refreshComponents() {
		panelBild.validate();
		panelBild.repaint();
		
		panelText.validate();
		panelText.repaint();
		
		panelLEA.validate();
		panelLEA.repaint();
		
		this.validate();
		this.repaint();
	}
	
	public static JPanel kartemachen(int _objektid){
		
		//String name = ""+_objektid;
		
		KartenmusterKreaturkarte name = new KartenmusterKreaturkarte();
		
		 name.KartenmusterKreaturkarteObjektid = ""+_objektid;
		 Karten k = Hauptspiel.deck1.get(_objektid);
		 Kreaturkarten kk = (Kreaturkarten)k;
		 name.lblAngriff.setText("" + kk.getAngriff());
		 name.lblEnergie.setText(""+kk.getEnergie());
		 name.lblLeben.setText(""+kk.getLeben());
		 name.lblKarteneffekt.setText(kk.getKartentext() + " Objektid=" + kk.getObjektid());
		 //name.lblBild.setIcon(null);;
		 Hauptspiel.log(kk.toString());
		 //name.setBounds(0, 0, 96, 168);
		 name.setSize(96, 168);
		 name.setVisible(true);
		 name.repaint();
		 name.validate();
		 name.panelLEA.repaint();
		 name.panelLEA.validate();
		 name.lblAngriff.validate();
		 name.lblAngriff.repaint();
		 name.setBackground(Color.red);
		 name.panelLEA.setBackground(Color.GREEN);
		 name.panelBild.setBackground(Color.PINK);
		 name.refreshComponents();

		 
		 return name;
	
	}
}