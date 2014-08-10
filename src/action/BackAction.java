package action;

import game.HorseRace;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class BackAction extends AbstractAction {
        
	public BackAction() {
		super("Voltar", null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		HorseRace.getApp().back();
	}
}
