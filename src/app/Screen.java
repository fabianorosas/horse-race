package app;

import game.HorseRace;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public abstract class Screen extends JFrame {
	
	protected JPanel contentPane;
	protected JPanel panelButtons;
	protected Dimension screenDim;

	public Screen() {
		screenDim = Toolkit.getDefaultToolkit().getScreenSize();
    	
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 182, 300);
		setSize(640, 480);
		contentPane = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				BufferedImage jockey = HorseRace.getApp().getImage("jockey.png"); 
				BufferedImage jockeyMirror = HorseRace.getApp().getImage("jockey_mirror.png"); 
				g.drawImage(jockey,0,this.getHeight()/2,null);
				g.drawImage(jockeyMirror,this.getWidth()/2 + jockeyMirror.getWidth() - 20,this.getHeight()/2,null);
			}			
		};
		contentPane.setLayout(null);
		contentPane.setPreferredSize(new Dimension(640, 480));
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		App.setBackAction(contentPane);
		setContentPane(contentPane);
	}
	
	public abstract void initialize();
}
