package action;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import screen.AbstractScreen;

public class QuitAction extends AbstractAction {

	private AbstractScreen screen;
	
	public QuitAction(AbstractScreen screen){
		super("Sair", null);
		this.screen = screen;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		screen.setVisible(false);
		screen.dispose();
		System.exit(0);
	}
}
