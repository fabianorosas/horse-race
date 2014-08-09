package app;

import game.HorseRace;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class StartScreen extends Screen {
	
	private Button startButton;
	private Button loadButton;
	private Button quitButton;
	private JPanel panelButtons;

	public StartScreen() {
		super();
		panelButtons = new JPanel();
		panelButtons.setBorder(null);
		panelButtons.setLayout(null);
		panelButtons.setSize(640,480);
		panelButtons.setLocation((screenDim.width - panelButtons.getWidth())/2, (screenDim.height - panelButtons.getHeight())/2);
		panelButtons.setBackground(new Color(12, 12, 12));
        
        startButton = new Button("start", panelButtons);
        startButton.setPosition(2, 4);
        startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                new GameScreen();
			}
        });
        
        loadButton = new Button("load", panelButtons);
        loadButton.setPosition(2, 3);
        loadButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		new LoadScreen();
            }
        });

        quitButton = new Button("quit", panelButtons);
        quitButton.setPosition(2, 3);
        quitButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		HorseRace.getApp().quit();
            }
        });

        
        panelButtons.setVisible(true);
        contentPane.add(panelButtons);
        pack();
        setVisible(true);
	}
}

