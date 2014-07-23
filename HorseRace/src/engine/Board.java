package engine;

import java.util.LinkedList;

public class Board {
	private final int NUMBER_OF_POSITIONS = 80; 	
	private LinkedList<Field> fields = new LinkedList<Field>();
	
	public Board(){
		createBoard();
	}
	
	public void createBoard(){
		for(int i = 0; i < NUMBER_OF_POSITIONS; i++){
			fields.add(new Field(i+1, 0));
		}
		initializeSpecialFields();
	}
	
	public void initializeSpecialFields(){
		fields.get(7).setRepayment(-1);
		fields.get(13).setRepayment(-1);
		fields.get(15).setRepayment(-3);
		fields.get(19).setRepayment(-1);
		fields.get(20).setRepayment(-4);
		fields.get(21).setRepayment(6);
		fields.get(28).setRepayment(-1);
		fields.get(30).setRepayment(-3);
		fields.get(31).setRepayment(6);
		fields.get(38).setRepayment(-1);
		fields.get(39).setRepayment(-2);
		fields.get(42).setRepayment(-5);
		fields.get(43).setRepayment(-6);
		fields.get(44).setRepayment(5);
		fields.get(51).setRepayment(-1);
		fields.get(53).setRepayment(-3);
		fields.get(60).setRepayment(-4);
		fields.get(61).setRepayment(-5);
		fields.get(62).setRepayment(5);
		fields.get(69).setRepayment(-1);
		fields.get(73).setRepayment(-3);
		fields.get(74).setRepayment(-4);
	}
	
	public LinkedList<Field> getFields(){
		return this.fields;
	}
}
