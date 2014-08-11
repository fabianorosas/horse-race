package screen;


import java.util.LinkedList;

import javax.swing.JOptionPane;

import app.App;
import app.Button;
import app.GameInProgressException;
import game.Board;
import game.Horse;
import game.HorseRace;
public class GameScreen extends AbstractScreen {
	private Board board;
	private LinkedList<Horse> horses;
	
	public GameScreen(LinkedList<Horse> horses) {
		super();
		this.horses = horses;
		App.setBackAction(contentPane);
	}

	@Override
	public void initialize() {
		super.initialize();
		board = new Board(horses);
		board.setSize(screenDim);
		board.setLayout(null);
		add(board);
	}
}
