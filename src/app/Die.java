package app;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Die extends JPanel {
	
	private BufferedImage img;

	public Die(BufferedImage img) {
		this.setImg(img);
		setSize(new Dimension(100, 100));
		setPreferredSize(new Dimension(100, 100));
		setDoubleBuffered(true);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(getImg(),0,0,this.getWidth(),this.getHeight(),null);
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
		this.repaint();
	}
}
