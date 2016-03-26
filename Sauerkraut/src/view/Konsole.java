package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Hauptspiel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Konsole extends JFrame {

	// kapseln?
	public JPanel contentPane;
	public JPanel panelKonsole;
	public JPanel panelMenue;
	public JButton btnReset;
	
	public static String konsolentext = "";
	private JScrollPane scrollPane;
	public JLabel labelKonsole;

	/**
	 * Neuer Frame erstellen (war mal eine Main Methode)
	 */
	public static void los() {
		
		try {
			Konsole frame = new Konsole();
			frame.setVisible(true);
			// falls 2 Konsolenfenster vorhanden sind, bekommt nur der aktuelleste die neuen logs
			// Jedoch wird beim Reset der Text fuer alle Konsolen geschlossen
			// Mit setter Methode fuer konsolenframe keonnte man die alte Konsole loeschen und damit mehrere zugleich geoeffnete Konsolenfenster verhindern
			Hauptspiel.konsolenframe = frame;;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				// hier wurde eig der Teil ab 'try { ...' hinkommen, aber da dieser Frame fuer Konsolenausgabe benoetigt wird, geht das nicht
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Konsole() {
		initialize();
	}
	private void initialize() {
		
		this.setTitle("Sauerkraut Konsole");
		
		// Die Applikation darf nicht geschlossen werden, wenn die Konsole geschlossen wird
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelKonsole = new JPanel();
		contentPane.add(panelKonsole, BorderLayout.CENTER);
		panelKonsole.setLayout(new BoxLayout(panelKonsole, BoxLayout.X_AXIS));
		
		panelMenue = new JPanel();
		contentPane.add(panelMenue, BorderLayout.SOUTH);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new BtnResetActionListener());
		panelMenue.add(btnReset);
		
		konsolentext = "<html><body>";
		
		labelKonsole = new JLabel("");
		labelKonsole.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelKonsole.setVerticalAlignment(SwingConstants.TOP);
		panelKonsole.add(labelKonsole);
		
		scrollPane = new JScrollPane(labelKonsole);
		panelKonsole.add(scrollPane);
		
	}
	
	private class BtnResetActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			konsolentext = "";
			labelKonsole.setText(konsolentext);
		}
	}
}
