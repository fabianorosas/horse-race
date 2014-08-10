package app;

import game.HorseRace;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import action.LoadAction;
import action.PlayAction;
import action.QuitAction;

public class StartScreen extends Screen {
	
	private Button startButton;
	private Button loadButton;
	private Button quitButton;
	
	private Screen gameScreen;

	public StartScreen() {
		super();
		setVisible(true);
	}
	
	@Override
	public void initialize(){
		panelButtons = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(Color.gray);
				g2d.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 20, 20);
			}
		};
		panelButtons.setLayout(null);
		panelButtons.setSize(640,480);
		panelButtons.setLocation((screenDim.width - panelButtons.getWidth())/2, (screenDim.height - panelButtons.getHeight())/2);
        
        startButton = new Button("start", panelButtons);
        startButton.setPosition(2, 6, true);
        startButton.addActionListener(new PlayAction(this));
        
        loadButton = new Button("back", panelButtons);
        loadButton.setPosition(2, 2, true);
        loadButton.addActionListener(new LoadAction());

        quitButton = new Button("help", panelButtons);
        quitButton.setPosition(2, 6, false);
        quitButton.addActionListener(new QuitAction());
        
        panelButtons.setVisible(true);
        contentPane.add(panelButtons);
        pack();
        setVisible(true);
	}

	public Screen getGameScreen() {
		return gameScreen;
	}

	public void setGameScreen(Screen gameScreen) throws GameInProgressException {
		if(HorseRace.getApp().getOldScreen() instanceof GameScreen){
			throw new GameInProgressException();
		}
		this.gameScreen = gameScreen;
	}
}

