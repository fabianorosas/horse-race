package screen;

import game.HorseRace;

import java.awt.Color;
import java.awt.FocusTraversalPolicy;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import action.PlayAction;
import app.App;
import app.Button;
import app.ChoicePanel;
import app.GameInProgressException;

public class NewgameScreen extends AbstractScreen {
	
	private Button playButton;
	private JPanel playerChoices;

	public NewgameScreen() {
		super();
		setVisible(true);
	}
	
	@SuppressWarnings("nls")
	@Override
	public void initialize(){
		super.initialize();
		playerChoices = new JPanel();
		playerChoices.setLayout(null);
		playerChoices.setBackground(Color.white);
		playerChoices.setSize(640,getHeight());
		playerChoices.setLocation((screenDim.width - playerChoices.getWidth())/2, 0);
                
        for(int i=1; i <= HorseRace.getMaxNumHorses(); i++){
        	playerChoices.add(new ChoicePanel(i));
        }
        
        playButton = new Button("start", contentPane);
        playButton.setLocation(contentPane.getWidth() + 450, contentPane.getHeight()+250);
        contentPane.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "enter");
        playButton.addActionListener(new PlayAction(playerChoices.getComponents()));
        contentPane.getActionMap().put("enter", new PlayAction(playerChoices.getComponents()));
        
        playerChoices.setVisible(true);
        contentPane.add(playerChoices);
        App.setBackAction(contentPane);
        pack();
        setVisible(true);
	}
}
