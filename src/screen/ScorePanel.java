package screen;

import game.ScoreBoard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Map;

import javax.swing.JPanel;

import app.App;
import app.Score;

public class ScorePanel extends JPanel {

	public ScorePanel(AbstractScreen parent) {
		setLayout(null);
		setSize(640,parent.screenDim.height);
		setBackground(Color.white);
		setLocation((parent.screenDim.width - this.getWidth())/2, 0);
		//setLocation(0, 0);
		setVisible(true);
		App.setBackAction(this);
		((StartScreen) parent).getBackButton().setVisible(true);
		showScore();
	}

	private void showScore(){
		ScoreBoard scoreBoard = new ScoreBoard();
		Map<String, String> score = scoreBoard.getMapScore();
		
		if(score.isEmpty()){
			return;
		}
		
		int i = 0;
		for(String name : score.keySet()){
			this.add(new Score(name, score.get(name), i));
			i++;
		}
	}
	
	/*
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		//g2d.setColor(new Color(243, 229, 171));
		g2d.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 20, 20);
	}
	*/
}
