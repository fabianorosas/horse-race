package action;

import game.HorseRace;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import app.Button;
import screen.AbstractScreen;
import screen.NewgameScreen;
import screen.ScorePanel;
import screen.StartScreen;

public class BackAction extends AbstractAction {
        
	public BackAction() {
		super("Voltar", null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		HorseRace.getApp().back();
		
		if(HorseRace.getApp().getScreen() instanceof NewgameScreen){
					AbstractScreen screen = new NewgameScreen();
					HorseRace.getApp().setScreen(screen);
					screen.initialize();
					screen.setVisible(true);
		}
		
		if(HorseRace.getApp().getScreen() instanceof StartScreen){
			HorseRace.getApp().getScreen().getPanelButtons().setVisible(true);
			
			for(Component c : HorseRace.getApp().getScreen().getContentPane().getComponents()){
				if(c instanceof ScorePanel || c instanceof Button){
					c.setVisible(false);
				}
			}
		}
	}
}
