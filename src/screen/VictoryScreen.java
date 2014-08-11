package screen;

import game.Horse;
import game.HorseRace;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VictoryScreen extends AbstractScreen {
	
	private Horse victoriousHorse;
	private BufferedImage victory;
	private JLabel message;

	public VictoryScreen(Horse horse) {
		screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 182, 300);
		setSize(640, 480);
		contentPane = new JPanel(){
			@Override
			public void paintComponent(Graphics g){	
				super.paintComponent(g);
				g.drawImage(victory,0,0,null);
			}
		};
		setContentPane(contentPane);
		this.victoriousHorse = horse;
		setVisible(true);
	}
	
	@Override
	public void initialize(){
		victory = HorseRace.getApp().getImage("victory.jpg");
		message = new JLabel("Parabéns " + victoriousHorse.getPlayer() + "!!"); 
		message.setFont(new Font("Courier", Font.BOLD, 42));
		message.setForeground(Color.white);
		contentPane.add(message);
		message.setLocation(contentPane.getWidth()/2, contentPane.getHeight()/2);
		contentPane.setSize(screenDim.width,screenDim.height);
        contentPane.setVisible(true);
        pack();
        setVisible(true);
	}
}
