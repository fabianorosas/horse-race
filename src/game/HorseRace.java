package game;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import app.App;

public class HorseRace extends App {
	private Race race;
	private static HorseRace app;

	public HorseRace() {
		super();
	}

	public void newGame(){
		//race = new Race();
		//race.start();
	}
	
	public void loadGame(){
		//
	}
	
	public void showScoreboard(){
		//
	}
	
	public void quit(){
		//
	}
	
	public BufferedImage getImage(String imageName){
		try {
			URL url = getClass().getResource("/resources/" + imageName);
        	BufferedImage image = ImageIO.read(url);
        	return image;
		}
        catch (IOException ex) {
        	return null;
        }
	}	
	
	/**
	 * Launch the application.
	 * @param args Main arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					setApp(new HorseRace());
					getApp().getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static HorseRace getApp() {
		return app;
	}

	public static void setApp(HorseRace app) {
		HorseRace.app = app;
	}
}
