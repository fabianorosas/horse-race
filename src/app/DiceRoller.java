package app;

import game.HorseRace;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import action.RollAction;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DiceRoller extends JFrame{

	private JPanel contentPane;
	private Die[] dice = new Die[2];
	private BufferedImage[] diceImgs = new BufferedImage[7];
	private Button buttonRoll;
	private JLabel lblPlayer;
	private String player;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiceRoller frame = new DiceRoller("Fulano");
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
	public DiceRoller(String player) {
		this.player = player;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 250, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));

		lblPlayer = new JLabel(player + ", role os dados!");
		lblPlayer.setFont(new Font("Courier", Font.BOLD, 22));
		add(lblPlayer);
				
		initDiceImgs();
		initDice();
		
		buttonRoll = new Button("start", this);
		buttonRoll.addActionListener(new RollAction(this));

		contentPane.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "enter");
		contentPane.getActionMap().put("enter", new RollAction(this));
		
		setVisible(true);
	}
	
	public int roll() {
		buttonRoll.setEnabled(false);
		int sum = 0;
		for(int i=0; i < dice.length; i++){
			int value = new Random().nextInt((6 - 1) + 1) + 1;
			dice[i].setImg(diceImgs[value]);
			sum += value;
		}
		return sum;
	}
	
	private void initDice(){
		for(int i=0; i < dice.length; i++){
			dice[i] = new Die(diceImgs[0]);
			contentPane.add(dice[i]);
		}
	}
	
	private void initDiceImgs(){
		for(int i=0; i < diceImgs.length; i++){
			diceImgs[i] = HorseRace.getApp().getImage("die" + i + ".jpg");
		}
	}
}
