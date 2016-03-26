package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JPanelMitBild extends JPanel {

	BufferedImage bild;
	URL bildURL;
	
	// Konstruktoren (alt)
	/**
	 * mit Bild URL (zBsp: "pictures/holz.png")
	 * @param bildPfad
	 *//*
	public JPanelMitBild(String bildPfad) {
		setBild(bildPfad);
	}
	
	public JPanelMitBild(BufferedImage _bild) {
		setBild(_bild);
	}*/
	
	// Setter
	public void setBild(BufferedImage _bild) {
		bild = _bild;
	}
	
	/**
	 * mit Bild URL (zBsp: "pictures/holz.png")
	 * @param bildURL
	 */
	public void setBild(String bildPfad) {

		
		bildURL = this.getClass().getClassLoader().getResource(bildPfad);
		//ALT: background = Toolkit.getDefaultToolkit().createImage("holz.png");
		
		try {
			
			bild = ImageIO.read(bildURL);
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		setBild(bild);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			
			g.drawImage(bild, 0, 0, null);
			
		}
		catch(NullPointerException ex) {
			ex.printStackTrace();
		}
	}
	
}