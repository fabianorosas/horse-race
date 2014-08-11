package game;

import java.awt.Container;

import app.Sprite;

public class Horse extends Sprite implements Cloneable{
	
	private String player;
	
	public Horse(String name, Container parent){
		super(name, parent);
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}