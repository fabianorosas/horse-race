package action;

import game.HorseRace;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import app.GameInProgressException;
import app.GameScreen;
import app.Screen;
import app.StartScreen;

public class PlayAction extends AbstractAction {
	private StartScreen startScreen;
	
	public PlayAction(StartScreen startScreen){
		super("Jogar", null);
		this.startScreen = startScreen; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Screen screen = new GameScreen();
		while (true) {
			try {
				startScreen.setGameScreen(screen);
				screen.initialize();
				screen.setVisible(true);
				HorseRace.getApp().switchScreen(screen);
				break;
			} catch (GameInProgressException e1) {
				int answer = JOptionPane.showConfirmDialog(null, "Se prosseguir, o jogo em andamento será perdido.", "Jogo em andamento!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(answer == JOptionPane.YES_OPTION){
					startScreen.getGameScreen().dispose();
				} else{
					screen.dispose();
					break;
				}
			}
		}
	}
}
