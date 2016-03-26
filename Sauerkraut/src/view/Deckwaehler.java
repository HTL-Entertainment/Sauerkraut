package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Hauptspiel;

import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Deckwaehler extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application. War mal die main Methode
	 */
	public static void los() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deckwaehler frame = new Deckwaehler();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Deckwaehler() {
		initiate();
	}
	private void initiate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JCheckBox sp1d1 = new JCheckBox("Spieler1_Deck1");
		buttonGroup.add(sp1d1);
		sp1d1.addMouseListener(new Sp1d1MouseListener());
		panel.add(sp1d1);
		
		JCheckBox sp2d1 = new JCheckBox("Spieler2_Deck1");
		buttonGroup.add(sp2d1);
		sp2d1.addMouseListener(new Sp2d1MouseListener());
		panel.add(sp2d1);
		
		lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnTestKonsoleOeffnen = new JButton("Test: Konsole oeffnen");
		btnTestKonsoleOeffnen.addActionListener(new BtnTestKonsoleOeffnenActionListener());
		panel_1.add(btnTestKonsoleOeffnen);
	}

	private class Sp1d1MouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			lblNewLabel.setText("Spieler 1 hat Deck 1 ausgewaehlt.");
			Hauptspiel.deckspieler1 = 1;
		}
	}
	private class Sp2d1MouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			lblNewLabel.setText("Spieler 2 hat Deck 1 ausgewaehlt.");
			Hauptspiel.deckspieler2 = 1;
		}
	}
	private class BtnTestKonsoleOeffnenActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Konsole.los();
		}
	}
}
