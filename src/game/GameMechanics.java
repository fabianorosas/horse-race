package game;

import java.util.LinkedList;

public class GameMechanics {
	private Board board;
	
	public GameMechanics(Board board){
		this.board = board;
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
		
		if((newHorsePosition - 1 >= 20 && horsePosition - 1 < 20) || (newHorsePosition - 1 >= 60 && horsePosition - 1 < 60)){
			horse.flip();
		}
		if(newHorsePosition <= 40){
			horse.setLocation(board.getFields().get(newHorsePosition).getPoint());
		} else if(newHorsePosition <= 70){
			horse.setLocation(board.getFields().get(newHorsePosition-2).getPoint());
		} else {
			horse.setLocation(board.getFields().get(newHorsePosition-1).getPoint());
		}
				
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