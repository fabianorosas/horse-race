package app;

import javax.swing.JPanel;
import game.Board;

public class GameScreen extends Screen {
	private Board board;
	private Button backButton;
	
	public GameScreen() {
		super();
	}

	@Override
	public void initialize() {
		board = new Board();
		board.setSize(screenDim);
		board.setLayout(null);
		add(board);

		initHorses();
	}
	
	private void initHorses(){
		
	}
}
