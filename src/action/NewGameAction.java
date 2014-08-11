package action;

import game.HorseRace;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import app.GameInProgressException;
import screen.AbstractScreen;
import screen.NewgameScreen;
import screen.StartScreen;

public class NewGameAction extends AbstractAction {
	private StartScreen startScreen;
	
	public NewGameAction(StartScreen startScreen){
		super("Novo jogo", null);
		this.startScreen = startScreen; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AbstractScreen screen = new NewgameScreen();
		startScreen.setNewGameScreen(screen);
		screen.initialize();
		screen.setVisible(true);
		try {
			HorseRace.getApp().switchScreen(screen);
		} catch (GameInProgressException e1) {
			e1.printStackTrace();
		}
	}
}
