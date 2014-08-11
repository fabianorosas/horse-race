package screen;

import game.HorseRace;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.KeyStroke;

import action.BackAction;
import action.ScoreAction;
import action.NewGameAction;
import action.PlayAction;
import action.QuitAction;
import app.App;
import app.Button;
import app.GameInProgressException;

public class StartScreen extends AbstractScreen {
	
	private Button startButton;
	private Button scoreButton;
	private Button quitButton;
	private Button backButton;
	
	private AbstractScreen gameScreen;
	private AbstractScreen newGameScreen;

	public StartScreen() {
		super();
		setVisible(true);
	}
	
	@SuppressWarnings("nls")
	@Override
	public void initialize(){
		super.initialize();
		setPanelButtons(new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(243, 229, 171));
				g2d.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 20, 20);
			}
		});
		getPanelButtons().setLayout(null);
		getPanelButtons().setSize(640,480);
		getPanelButtons().setLocation((screenDim.width - getPanelButtons().getWidth())/2, (screenDim.height - getPanelButtons().getHeight())/2);
                
        startButton = new Button("newgame", getPanelButtons());
        startButton.setPosition(2, 6, true);
        startButton.addActionListener(new NewGameAction(this));
        
        scoreButton = new Button("score", getPanelButtons());
        scoreButton.setPosition(2, 2, true);
        scoreButton.addActionListener(new ScoreAction(this));

        quitButton = new Button("quit", getPanelButtons());
        quitButton.setPosition(2, 6, false);
        quitButton.addActionListener(new QuitAction(this));
        
        
        setBackButton(new Button("back", contentPane));
        getBackButton().setLocation(contentPane.getWidth() + 450, contentPane.getHeight()+250);
        contentPane.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "enter");
        getBackButton().addActionListener(new BackAction());
        contentPane.getActionMap().put("enter", new BackAction());
        getBackButton().setVisible(false);
        
        getPanelButtons().setVisible(true);
        contentPane.add(getPanelButtons());
        pack();
        setVisible(true);
        
        contentPane.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "enter");
		contentPane.getActionMap().put("enter", new NewGameAction(this));
		
		App.setBackAction(contentPane);
	}

	public AbstractScreen getGameScreen() {
		return gameScreen;
	}

	public void setNewGameScreen(AbstractScreen newGameScreen) {
		this.newGameScreen = newGameScreen;
	}

	public AbstractScreen getNewGameScreen() {
		return newGameScreen;
	}

	public void setGameScreen(AbstractScreen gameScreen) {
		this.gameScreen = gameScreen;
	}

	public Button getBackButton() {
		return backButton;
	}

	public void setBackButton(Button backButton) {
		this.backButton = backButton;
	}
}

