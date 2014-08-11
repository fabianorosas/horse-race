package app;

import javax.swing.JComponent;
import javax.swing.KeyStroke;

import action.BackAction;

public class App {

	private Screen screen;
	private Screen oldScreen;

	/**
	 * Create the application.
	 */
	public App() {
		setScreen(new StartScreen());
	}

	public void initialize(){
		((StartScreen) getScreen()).initialize();
	}
	
	public void switchScreen(AbstractScreen newScreen) throws GameInProgressException{
		if(HorseRace.getApp().getOldScreen() instanceof GameScreen){
			throw new GameInProgressException();
		}
		setOldScreen(getScreen());
		getOldScreen().setVisible(false);
		setScreen(newScreen);
	}
	
	public void back(){
		if(getOldScreen() != null){
			AbstractScreen newScreen;
			newScreen = getOldScreen();
			getScreen().setVisible(false);
			setOldScreen(getScreen());
			setScreen(newScreen);
			newScreen.setVisible(true);
		}
	}

	public AbstractScreen getScreen() {
		return screen;
	}

	public void setScreen(AbstractScreen frame) {
		this.screen = frame;
	}
	
	@SuppressWarnings("nls")
	public static void setBackAction(JComponent component){
		component.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"), "goBack");
		component.getActionMap().put("goBack", new BackAction());
	}
	
	public AbstractScreen getOldScreen() {
		return oldScreen;
	}

	public void setOldScreen(AbstractScreen oldScreen) {
		this.oldScreen = oldScreen;
	}		
}
