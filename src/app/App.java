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
	
	public void switchScreen(Screen newScreen){
		setOldScreen(getScreen());
		getOldScreen().setVisible(false);
		setScreen(newScreen);
	}
	
	public void back(){
		System.out.println(getOldScreen());
		if(getOldScreen() != null){
			Screen newScreen = getOldScreen();
			getScreen().setVisible(false);
			setOldScreen(getScreen());
			setScreen(newScreen);
			newScreen.setVisible(true);
		}
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen frame) {
		this.screen = frame;
	}
	
	public static void setBackAction(JComponent component){
		component.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"), "goBack");
		component.getActionMap().put("goBack", new BackAction());
	}

	public Screen getOldScreen() {
		return oldScreen;
	}

	public void setOldScreen(Screen oldScreen) {
		this.oldScreen = oldScreen;
	}		
}
