package action;

import game.Horse;
import game.HorseRace;
import app.ChoicePanel;
import app.GameInProgressException;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import screen.GameScreen;
import screen.AbstractScreen;


public class PlayAction extends AbstractAction {
	
	private Component[] choices;
	private LinkedList<Horse> horses;
	
	public PlayAction(Component[] choices) {
		super("Jogar", null);
		this.choices = choices;
		this.horses = new LinkedList<>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(Component comp : choices){
			if(comp instanceof ChoicePanel){
				Horse horse = ((ChoicePanel) comp).getHorse();
				if(horse.getPlayer() != null && !horse.getPlayer().equals("")){
					try {
						JTextField tfPlayer = ((ChoicePanel) comp).getTfPlayer();
						((ChoicePanel) comp).remove(tfPlayer);
						((ChoicePanel) comp).add((Component) horse.clone());
						((ChoicePanel) comp).add(tfPlayer);
					} catch (CloneNotSupportedException e1) {
						e1.printStackTrace();
					}
					horses.add(horse);
				}
			}
		}
		while(true){
			try {
				AbstractScreen screen = new GameScreen(horses);
				screen.initialize();
				screen.setVisible(true);
				HorseRace.getApp().switchScreen(screen);
				HorseRace.getApp().startRace();
			} catch (GameInProgressException e1) {
				int answer = JOptionPane.showConfirmDialog(null, "Se prosseguir o jogo em andamento será perdido.", "Jogo em andamento!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
				if(answer == JOptionPane.YES_OPTION){
					HorseRace.getApp().setOldScreen(null);
					continue;
				}
			}
			break;
		}
	}
}
