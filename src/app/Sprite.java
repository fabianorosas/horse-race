package app;

import game.HorseRace;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Sprite extends JPanel {

	private BufferedImage img;
	private AffineTransform tx;
	private AffineTransformOp op;

	public Sprite(String name, Container parent) {
		super();
		this.img = HorseRace.getApp().getImage(name);

		setAppearance();

        parent.add(this);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img,0,0,null);
	}
	
	public void flip(){
		tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-img.getWidth(null), 0);
		
        op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        img = op.filter(img, null);
	}

	public void scale(double x, double y){
		tx = AffineTransform.getScaleInstance(x, y);
		//tx.translate(-img.getWidth(null), 0);
		
        op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        img = op.filter(img, null);
	}
	
	private void setAppearance(){
		setSize(152, 103);
		this.setBackground(new Color(238, 233, 233, Transparency.TRANSLUCENT));
        setPreferredSize(new Dimension(152, 103));
		setBorder(null);
        setVisible(true);
	}
}
