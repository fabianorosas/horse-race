package app;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class Score extends JPanel {
	private JLabel player;
	private JLabel score;
	
	public Score(String player, String score, int i){
		this.setPlayer(new JLabel(player));
		this.setScore(new JLabel(score));
				
		this.setSize(640, 60);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
		this.setLocation(0, 140 + (i-1)*70);

		getPlayer().setFont(new Font("Courier", Font.BOLD, 42)); 
		getScore().setFont(new Font("Courier", Font.BOLD, 42)); 
		
		this.add(getPlayer());
		this.add(getScore());
		
		this.setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(new Color(238, 233, 233));
		g2d.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 20, 20);
	}

	public JLabel getPlayer() {
		return player;
	}

	public void setPlayer(JLabel player) {
		this.player = player;
	}
	
	private void setScore(JLabel score){
		this.score = score;
	}
	
	private JLabel getScore(){
		return score;
	}
}
