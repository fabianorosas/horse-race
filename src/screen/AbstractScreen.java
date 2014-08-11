package screen;

import game.HorseRace;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.App;

public abstract class AbstractScreen extends JFrame {
	
	protected JPanel contentPane;
	private JPanel panelButtons;
	protected Dimension screenDim;
	protected BufferedImage jockey;
	protected BufferedImage jockeyMirror;

	public AbstractScreen() {
		this.screenDim = Toolkit.getDefaultToolkit().getScreenSize();
    			
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 182, 300);
		setSize(640, 480);
		
		contentPane = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				//g.drawImage(jockey, (this.getWidth() - jockey.getWidth())/2, (this.getHeight() - jockey.getHeight())/12, null);
				g.drawImage(jockey,0,this.getHeight()/2,null);
				g.drawImage(jockeyMirror,this.getWidth()/2 + jockeyMirror.getWidth() - 20,this.getHeight()/2,null);
			}			
		};
		contentPane.setLayout(null);
		contentPane.setPreferredSize(new Dimension(640, 480));
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}

	@SuppressWarnings("nls")
	public void initialize(){
		this.jockey = HorseRace.getApp().getImage("jockey.png");
		this.jockeyMirror = HorseRace.getApp().getImage("jockey_mirror.png");
	}

	public JPanel getPanelButtons() {
		return panelButtons;
	}

	public void setPanelButtons(JPanel panelButtons) {
		this.panelButtons = panelButtons;
	}
}
