package game;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import javax.imageio.ImageIO;
import screen.AbstractScreen;
import screen.VictoryScreen;
import action.ScoreAction;
import app.App;
import app.DiceRoller;
import app.GameInProgressException;

public class HorseRace extends App implements Runnable{

	private static final int MAX_NUM_HORSES = 6;
	
	private static HorseRace app;
	private GameMechanics engine;
	private Board board;
	private LinkedList<Horse> horses;
	private DiceRoller diceRoller;
	private static int valueRolled;
	private static CountDownLatch latch;

	public HorseRace() {
		super();
		HorseRace.valueRolled = 0;
	}

	public void writeScoreboard(Horse horse){
		new ScoreAction(horse.getPlayer());
	}
	
	public BufferedImage getImage(String imageName){
		try {
			URL url = getClass().getResource("/resources/" + imageName); //$NON-NLS-1$
        	BufferedImage image = ImageIO.read(url);
        	return image;
		} catch (IOException ex) {
        	return null;
        }
	}	
	
	public void startRace() {
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run(){
		engine = new GameMechanics(board);
		engine.setInitialPosition(horses);
		int field = 0;
		Horse winningHorse = null;
		
		while(true){
			for(Horse horse : horses){
				try {
					setLatch(new CountDownLatch(1));
					diceRoller = new DiceRoller(horse.getPlayer());
					getLatch().await();
					Thread.sleep(2000);
					field = engine.forwardBoard(horse, valueRolled);
				} catch (InterruptedException e) {
					break;
				} finally{
					valueRolled = 0;
					diceRoller.setVisible(false);
					diceRoller.dispose();
				}

				if(field == 80){
					winningHorse = horse;
					break;
				}
			}
			if(field == 80){
				break;
			}
		}
		AbstractScreen victory = new VictoryScreen(winningHorse);
		victory.initialize();
		try {
			app.switchScreen(victory);
		} catch (GameInProgressException e) {
			e.printStackTrace();
		}
		writeScoreboard(winningHorse);
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
					getApp().initialize();
					getApp().getScreen().setVisible(true);
					
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

	public static int getMaxNumHorses() {
		return MAX_NUM_HORSES;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public LinkedList<Horse> getHorses() {
		return horses;
	}

	public void setHorses(LinkedList<Horse> horses) {
		this.horses = horses;
	}

	public static int getValueRolled() {
		return valueRolled;
	}

	public static void setValueRolled(int valueRolled) {
		HorseRace.valueRolled = valueRolled;
	}

	public static CountDownLatch getLatch() {
		return latch;
	}

	public static void setLatch(CountDownLatch latch) {
		HorseRace.latch = latch;
	}
}
