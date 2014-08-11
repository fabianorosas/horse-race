package app;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import game.Horse;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChoicePanel extends JPanel {

	private Horse horse;
	private JTextField tfPlayer;
	
	@SuppressWarnings("nls")
	public ChoicePanel(int i){
		this.setHorse(new Horse("horse" + i + ".png", this));
		setTextField(i);
				
		this.setSize(640, 110);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
		this.setLocation(0, 30 + (i-1)*120);
		App.setBackAction(this);
		
		this.add(getHorse());
		this.add(getTfPlayer());
	}
	
	@SuppressWarnings("nls")
	private void setTextField(int i){
		setTfPlayer(new JTextField("Jogador " + i));
		getTfPlayer().setFont(new Font("Courier", Font.BOLD, 26));
		getTfPlayer().setForeground(Color.LIGHT_GRAY);
		getTfPlayer().setColumns(12);
		getTfPlayer().addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent e){
				getTfPlayer().setText("");
				getTfPlayer().setForeground(Color.black);
			}

			@Override
			public void focusLost(FocusEvent e) {
				getHorse().setPlayer(getTfPlayer().getText());
			}
		});
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(new Color(238, 233, 233));
		g2d.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 20, 20);
	}

	public Horse getHorse() {
		return horse;
	}

	public void setHorse(Horse horse) {
		this.horse = horse;
	}

	public JTextField getTfPlayer() {
		return tfPlayer;
	}

	public void setTfPlayer(JTextField tfPlayer) {
		this.tfPlayer = tfPlayer;
	}
}
