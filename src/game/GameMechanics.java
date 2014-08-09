package engine;

import game.Board;
import game.Field;
import game.Horse;

import java.util.LinkedList;

public class GameMechanics {
	private Board board;
	
	public GameMechanics(LinkedList<Horse> horses){
		board = new Board();
		setInitialPosition(horses);
	}
	
	public int forwardBoard(Horse horse, int fields){
		int horsePosition = findHorsePosition(horse);
		
		if(horsePosition + fields == 80){
			return 80;
		}
		else if(canForward(horsePosition, fields)){
			return moveHorse(horse, horsePosition, fields);
		}
		return 0; //can't move
	}
	
	private int findHorsePosition(Horse horse){
		for(Field field : board.getFields()){
			if(field.containHorse(horse))
				return field.getPosition();
		}
		return 0;
	}
	
	private int moveHorse(Horse horse, int horsePosition, int fields){
		int repayment = board.getFields().get(horsePosition + fields).getRepayment();
		int newHorsePosition = horsePosition + fields + repayment;
		
		board.getFields().get(horsePosition - 1).removeHorse(horse);
		board.getFields().get(newHorsePosition - 1).setHorses(horse);
		
		return newHorsePosition;
	}
	
	/*
	 * set the horses in the first position
	 */
	public void setInitialPosition(LinkedList<Horse> horses){
		for(Horse horse : horses)
			board.getFields().get(0).setHorses(horse);
	}
	
	private boolean canForward(int horsePostion, int fields){
		return (horsePostion + fields) < 80;
	}
}