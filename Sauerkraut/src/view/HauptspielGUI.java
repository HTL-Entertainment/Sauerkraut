package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Hand1Listener;
import control.Hauptspiel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class HauptspielGUI extends JFrame {

	private JPanel contentPane;
	public static JPanelMitBild panelHand1;
	private JPanel panelVerticalTrennung;
	private JPanel panelHand2;
	private JPanel panelBrett1;
	private JPanel panelBrett2;
	private JPanel panelHorizontalTrennung;
	
	public static JPanel panelHand1Karte1;
	private JPanel panelHand1Karte2;
	private JPanel panelHand1Karte3;
	private JPanel panelHand1Karte4;
	
	private JPanel panelHand2Karte1;
	private JPanel panelHand2Karte2;
	private JPanel panelHand2Karte3;
	private JPanel panelHand2Karte4;
	
	private JPanel panelBrett1Karte1;
	private JPanel panelBrett1Karte2;
	private JPanel panelBrett1Karte3;
	private JPanel panelBrett1Karte4;
	private JPanel panelBrett1Karte5;
	private JPanel panelBrett1Karte6;
	private JPanel panelSpieler1;
	
	private JPanel panelBrett2Karte1;
	private JPanel panelBrett2Karte2;
	private JPanel panelBrett2Karte3;
	private JPanel panelBrett2Karte4;
	private JPanel panelBrett2Karte5;
	private JPanel panelBrett2Karte6;
	private JPanel panelSpieler2;
	
	private JLabel label_1;
	private JLabel lblDerEisdracheLebt;
	private JPanel panel_8;
	private JLabel label;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel lblNewLabel;
	private JLabel lblSpieler;
	private JLabel label_2;
	private JPanel panel_9;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel lblNewLabel_1;
	private JButton button;
	private JButton btnNewButton;
	
	/** Alle JPanels in der Hand von Spieler 1 */
	ArrayList<JPanel> hand1Panels = new ArrayList<JPanel>();
	/** Alle JPanels in der Hand von Spieler 2 */
	ArrayList<JPanel> hand2Panels = new ArrayList<JPanel>();
	/** Alle JPanels auf dem Brett von Spieler 1 */
	ArrayList<JPanel> brett1Panels = new ArrayList<JPanel>();
	/** Alle JPanels auf dem Brett von Spieler 2 */
	ArrayList<JPanel> brett2Panels = new ArrayList<JPanel>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HauptspielGUI() {
		initialize();
	}
	private void initialize() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 570);
		this.getContentPane().setSize(960, 540);
		this.setResizable(false);
		this.setTitle("Sauerkraut");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelVerticalTrennung = new JPanel();
		panelVerticalTrennung.setBackground(Color.GREEN);
		panelVerticalTrennung.setBounds(475, 0, 10, 540);
		contentPane.add(panelVerticalTrennung);
		
		panelHorizontalTrennung = new JPanel();
		panelHorizontalTrennung.setBackground(Color.GREEN);
		panelHorizontalTrennung.setBounds(0, 350, 960, 10);
		contentPane.add(panelHorizontalTrennung);
		
		// ==== HAND 1 GENERELL ==== 
		panelHand1 = new JPanelMitBild();
		panelHand1.setBild("pictures/holz.png");
		panelHand1.setBackground(Color.DARK_GRAY);
		panelHand1.setBounds(0, 360, 475, 180);
		contentPane.add(panelHand1);
		panelHand1.setLayout(null);
		
		// ==== HAND 1 KARTEN ===
		panelHand1Karte1 = new JPanel();
		panelHand1Karte1.setBounds(15, 5, 96, 168);
		panelHand1.add(panelHand1Karte1);
		panelHand1Karte1.setLayout(new GridLayout(0, 1, 0, 0));
		
		// --- Karte 2 ( + Testinhalt) ---
		panelHand1Karte2 = new JPanel();
		panelHand1Karte2.setBounds(126, 5, 96, 168);
		panelHand1.add(panelHand1Karte2);
		panelHand1Karte2.setLayout(new BorderLayout(0, 0));
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(HauptspielGUI.class.getResource("/pictures/Eisdrache_klein.png")));
		panelHand1Karte2.add(label_1, BorderLayout.NORTH);
		
		lblDerEisdracheLebt = new JLabel("<html><body align=\"center\">Der Eisdrache lebt seit 1000000 Jahren in einer Eish\u00F6hle</body></html>");
		lblDerEisdracheLebt.setHorizontalAlignment(SwingConstants.CENTER);
		panelHand1Karte2.add(lblDerEisdracheLebt, BorderLayout.CENTER);
		
		panel_8 = new JPanel();
		panelHand1Karte2.add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new GridLayout(0, 3, 0, 0));
		
		label = new JLabel("6");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(label);
		
		label_3 = new JLabel("2");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(label_3);
		
		label_4 = new JLabel("5");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(label_4);
		// ---
		
		panelHand1Karte3 = new JPanel();
		panelHand1Karte3.setBounds(237, 5, 96, 168);
		panelHand1.add(panelHand1Karte3);
		
		panelHand1Karte4 = new JPanel();
		panelHand1Karte4.setBounds(348, 5, 96, 168);
		panelHand1.add(panelHand1Karte4);
		
		// ==== HAND 2 GENERELL ==== 
		panelHand2 = new JPanel();
		panelHand2.setBackground(Color.DARK_GRAY);
		panelHand2.setBounds(485, 360, 475, 180);
		contentPane.add(panelHand2);
		panelHand2.setLayout(null);
		
		// ==== HAND 2 KARTEN  ====
		// --- Karte 1 (+ Testinhalt) ---
		panelHand2Karte1 = new JPanel();
		panelHand2Karte1.setBounds(15, 5, 96, 168);
		panelHand2.add(panelHand2Karte1);
		panelHand2Karte1.setLayout(new BorderLayout(0, 0));
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(HauptspielGUI.class.getResource("/pictures/Roter_Drache_klein.png")));
		panelHand2Karte1.add(label_2, BorderLayout.NORTH);
		
		panel_9 = new JPanel();
		panelHand2Karte1.add(panel_9, BorderLayout.SOUTH);
		panel_9.setLayout(new GridLayout(0, 3, 0, 0));
		
		label_5 = new JLabel("5");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(label_5);
		
		label_6 = new JLabel("1");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(label_6);
		
		label_7 = new JLabel("5");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(label_7);
		
		lblNewLabel_1 = new JLabel("<html><body align=\"center\">Er ist der &auml;lteste seiner uralten Rasse </body></html>");
		panelHand2Karte1.add(lblNewLabel_1, BorderLayout.CENTER);
		// ---
		
		panelHand2Karte2 = new JPanel();
		panelHand2Karte2.setBounds(126, 5, 96, 168);
		panelHand2.add(panelHand2Karte2);
		
		panelHand2Karte3 = new JPanel();
		panelHand2Karte3.setBounds(237, 5, 96, 168);
		panelHand2.add(panelHand2Karte3);
		
		panelHand2Karte4 = new JPanel();
		panelHand2Karte4.setBounds(348, 5, 96, 168);
		panelHand2.add(panelHand2Karte4);
		// ====
		
		// ==== BRETT 1 GENERELL ==== 
		panelBrett1 = new JPanel();
		panelBrett1.setBackground(Color.GRAY);
		panelBrett1.setBounds(0, 0, 475, 350);
		contentPane.add(panelBrett1);
		panelBrett1.setLayout(null);
		
		// ==== BRETT 1 KARTEN ==== 
		
		// --- Spieler 1 --- 
		panelSpieler1 = new JPanel();
		panelSpieler1.setBounds(10, 96, 96, 168);
		panelBrett1.add(panelSpieler1);
		panelSpieler1.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("Spieler 1");
		panelSpieler1.add(lblNewLabel);
		// ---
		
		panelBrett1Karte1 = new JPanel();
		panelBrett1Karte1.setBounds(126, 3, 96, 168);
		panelBrett1.add(panelBrett1Karte1);
		
		panelBrett1Karte2 = new JPanel();
		panelBrett1Karte2.setBounds(237, 3, 96, 168);
		panelBrett1.add(panelBrett1Karte2);
		
		panelBrett1Karte3 = new JPanel();
		panelBrett1Karte3.setBounds(348, 3, 96, 168);
		panelBrett1.add(panelBrett1Karte3);
		
		panelBrett1Karte4 = new JPanel();
		panelBrett1Karte4.setBounds(126, 179, 96, 168);
		panelBrett1.add(panelBrett1Karte4);
		
		panelBrett1Karte5 = new JPanel();
		panelBrett1Karte5.setBounds(237, 179, 96, 168);
		panelBrett1.add(panelBrett1Karte5);
		
		panelBrett1Karte6 = new JPanel();
		panelBrett1Karte6.setBounds(348, 179, 96, 168);
		panelBrett1.add(panelBrett1Karte6);
		
		// --- Runde beenden Button ---
		btnNewButton = new JButton("<html><h2>Runde beenden</h2></html>");
		btnNewButton.setBounds(10, 275, 100, 65);
		panelBrett1.add(btnNewButton);
		btnNewButton.addActionListener(new RundebeendenListener());
		
		// ==== BRETT 2 GENERELL ====
		panelBrett2 = new JPanel();
		panelBrett2.setBackground(Color.GRAY);
		panelBrett2.setBounds(485, 0, 475, 350);
		contentPane.add(panelBrett2);
		panelBrett2.setLayout(null);
		
		// ==== BRETT 2 KARTEN ==== 
		panelBrett2Karte1 = new JPanel();
		panelBrett2Karte1.setBounds(15, 3, 96, 168);
		panelBrett2.add(panelBrett2Karte1);
		
		panelBrett2Karte2 = new JPanel();
		panelBrett2Karte2.setBounds(126, 3, 96, 168);
		panelBrett2.add(panelBrett2Karte2);
		
		panelBrett2Karte3 = new JPanel();
		panelBrett2Karte3.setBounds(237, 3, 96, 168);
		panelBrett2.add(panelBrett2Karte3);
		
		panelBrett2Karte4 = new JPanel();
		panelBrett2Karte4.setBounds(15, 179, 96, 168);
		panelBrett2.add(panelBrett2Karte4);
		
		panelBrett2Karte5 = new JPanel();
		panelBrett2Karte5.setBounds(126, 179, 96, 168);
		panelBrett2.add(panelBrett2Karte5);
		
		panelBrett2Karte6 = new JPanel();
		panelBrett2Karte6.setBounds(237, 179, 96, 168);
		panelBrett2.add(panelBrett2Karte6);
		
		// --- Spieler 2 ---
		panelSpieler2 = new JPanel();
		panelSpieler2.setBounds(348, 96, 96, 168);
		panelBrett2.add(panelSpieler2);
		panelSpieler2.setLayout(new BorderLayout(0, 0));
		
		lblSpieler = new JLabel("Spieler 2");
		panelSpieler2.add(lblSpieler, BorderLayout.CENTER);
		// ---
		
		// --- Runde beenden Button ---
		button = new JButton("<html><h2>Runde beenden</h2></html>");
		button.setBounds(343, 275, 100, 65);
		panelBrett2.add(button);
		button.addActionListener(new RundebeendenListener());
		// ====
		
		
		// TODO: Listener hinzufuegne
		panelHand1Karte1.addMouseListener(new Hand1Listener());
		
		// Panels den Listen hinzufuegen
		hand1Panels.add(panelHand1Karte1);
		hand1Panels.add(panelHand1Karte2);
		hand1Panels.add(panelHand1Karte3);
		hand1Panels.add(panelHand1Karte4);
		
		hand2Panels.add(panelHand2Karte1);
		hand2Panels.add(panelHand2Karte2);
		hand2Panels.add(panelHand2Karte3);
		hand2Panels.add(panelHand2Karte4);
		
		brett1Panels.add(panelBrett1Karte1);
		brett1Panels.add(panelBrett1Karte2);
		brett1Panels.add(panelBrett1Karte3);
		brett1Panels.add(panelBrett1Karte4);
		brett1Panels.add(panelBrett1Karte5);
		brett1Panels.add(panelBrett1Karte6);
		
		brett2Panels.add(panelBrett2Karte1);
		brett2Panels.add(panelBrett2Karte2);
		brett2Panels.add(panelBrett2Karte3);
		brett2Panels.add(panelBrett2Karte4);
		brett2Panels.add(panelBrett2Karte5);
		brett2Panels.add(panelBrett2Karte6);

		panelHand1.repaint();
		panelHand1.validate();
	}
	
	public void hand1Refresh() {
		
		for(int i = 0; i < Hauptspiel.hand1.size(); i++) {
			panelHand1Karte1.removeAll();
			panelHand1Karte1.add(KartenmusterKreaturkarte.kartemachen(Hauptspiel.hand1.get(i).getObjektid()));
		}

	}
}