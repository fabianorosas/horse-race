package game;

import java.awt.Point;
import java.util.LinkedList;

public class Field {
	private int position;
	private int penalty;
	private LinkedList<Horse> horses = new LinkedList<Horse>();
	private Point point;
	
	public Field(int position, int penalty){
		this.position = position;
		this.penalty = penalty;
	}

	public boolean containHorse(Horse horse){
		return horses.contains(horse);
	}
	
	public boolean removeHorse(Horse horse){
		return horses.remove(horse);
	}
	
	public int getPosition(){
		return position;
	}

	public int getPenalty(){
		return penalty;
	}
	
	public void setPenalty(int repayment){
		this.penalty = repayment;
	}
	
	public void setHorses(Horse horse){
		this.horses.add(horse);
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
}