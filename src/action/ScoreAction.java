package action;

import game.ScoreBoard;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import screen.AbstractScreen;
import screen.StartScreen;
import screen.ScorePanel;

public class ScoreAction extends AbstractAction implements Runnable{
	private AbstractScreen screen;
	private String player;

	public ScoreAction(AbstractScreen screen){
		super("Placar", null);
		this.screen = screen;
	}
	
	public ScoreAction(String player){
		super("Placar", null);
		this.player=player;
		Thread t = new Thread(this);
		t.start();
	}
	
	public void run(){
		new ScoreBoard(player);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(Component c : screen.getContentPane().getComponents()){
			c.setVisible(false);
		}
		screen.add(new ScorePanel(screen));
	}
}
