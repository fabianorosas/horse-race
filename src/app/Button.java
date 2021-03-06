package app;

import game.HorseRace;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton {
	
	private HorseRace app;
	private String name;
	private Container parent;

	public Button(String name, Container parent) {
		super();
		this.app = HorseRace.getApp();
		this.name = name;
		this.parent = parent;
		setIcons();
		setAppearance();

        parent.add(this);
	}
	
	private void setIcons(){
		setIcon(new ImageIcon(app.getImage(name + "_button_normal.png")));
        setRolloverIcon(new ImageIcon(app.getImage(name + "_button_hover.png")));
        setSelectedIcon(new ImageIcon(app.getImage(name + "_button_pressed.png")));
	}
	
	private void setAppearance(){
		setSize(120, 50);
        setPreferredSize(new Dimension(120, 50));
		setBorder(null);
        setContentAreaFilled(false);
        setVisible(true);
	}
	
	public void setPosition(float xFactor, float yFactor, boolean upperHalf){
		int x = (int) ((parent.getWidth() - this.getWidth())/xFactor);
		int y = (int) ((parent.getHeight() - this.getHeight())/yFactor);
		if(!upperHalf){
			y *= yFactor - 1;
		}
		setLocation(x, y);
	}
}
