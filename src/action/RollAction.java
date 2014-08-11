package action;

import game.HorseRace;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import app.DiceRoller;

public class RollAction extends AbstractAction {
	private DiceRoller diceRoller;

	public RollAction(DiceRoller diceRoller) {
		super("roll", null);
		this.diceRoller = diceRoller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		HorseRace.setValueRolled(diceRoller.roll());
		HorseRace.getLatch().countDown();	
	}
}
