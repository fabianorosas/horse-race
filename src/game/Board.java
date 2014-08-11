package game;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.JPanel;


public class Board extends JPanel{
	
	private final int NUMBER_OF_POSITIONS = 80; 	
	private final int START_X = 630;
	
	private LinkedList<Field> fields;
	private LinkedList<Horse> horses; 
	private BufferedImage board;
	
	@SuppressWarnings("nls")
	public Board(LinkedList<Horse> horses){
		this.fields = new LinkedList<>();
		this.horses = horses;
		this.board = HorseRace.getApp().getImage("board.jpg");
		
		for(int i = 0; i < NUMBER_OF_POSITIONS; i++){
			fields.add(new Field(i+1, 0));
		}
		initializeSpecialFields();
		initPositions();
		addHorses();
		HorseRace.getApp().setBoard(this);
		HorseRace.getApp().setHorses(horses);
		setVisible(true);
		setDoubleBuffered(true);
	}
	
	public LinkedList<Field> getFields(){
		return this.fields;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(board,0,0,this.getWidth(),this.getHeight(),null);
	}
	
	private void addHorses(){
		int i = 0;
		int factor = 100 / (horses.size() - 1); 
		for(Horse horse : horses){
			add(horse);
			horse.setVisible(true);
			horse.setSize(152, 103);
			horse.setLocation(START_X, 580 + (i*factor));
			horse.flip();
			horse.scale(0.8, 0.8);
			i++;
		}
	}

	private void initializeSpecialFields(){
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
	
	private void initPositions(){				
		fields.get(0).setPoint(new Point(630, 650));
		fields.get(1).setPoint(new Point(582, 650));
		fields.get(2).setPoint(new Point(536, 650));
		fields.get(3).setPoint(new Point(496, 650));
		fields.get(4).setPoint(new Point(456, 650));
		fields.get(5).setPoint(new Point(418, 650));
		fields.get(6).setPoint(new Point(378, 650));
		fields.get(7).setPoint(new Point(340, 650));
		fields.get(8).setPoint(new Point(310, 640));
		fields.get(9).setPoint(new Point(280, 630));
		fields.get(10).setPoint(new Point(240, 620));
		fields.get(11).setPoint(new Point(220, 590));
		fields.get(12).setPoint(new Point(193, 570));
		fields.get(13).setPoint(new Point(170, 550));
		fields.get(14).setPoint(new Point(140, 530));
		fields.get(15).setPoint(new Point(120, 500));
		fields.get(16).setPoint(new Point(100, 480));
		fields.get(17).setPoint(new Point(110, 440));
		fields.get(18).setPoint(new Point(120, 410));
		fields.get(19).setPoint(new Point(120, 380));
		fields.get(20).setPoint(new Point(120, 350));
		fields.get(21).setPoint(new Point(120, 323));
		fields.get(22).setPoint(new Point(120, 298));
		fields.get(23).setPoint(new Point(120, 265));
		fields.get(24).setPoint(new Point(120, 230));
		fields.get(25).setPoint(new Point(135, 200));
		fields.get(26).setPoint(new Point(170, 180));
		fields.get(27).setPoint(new Point(210, 170));
		fields.get(28).setPoint(new Point(250, 160));
		fields.get(29).setPoint(new Point(275, 150));
		fields.get(30).setPoint(new Point(308, 130));
		fields.get(31).setPoint(new Point(335, 120));
		fields.get(32).setPoint(new Point(370, 110));
		fields.get(33).setPoint(new Point(406, 100));
		fields.get(34).setPoint(new Point(440, 100));
		fields.get(35).setPoint(new Point(480, 100));
		fields.get(36).setPoint(new Point(528, 100));
		fields.get(37).setPoint(new Point(572, 100));
		fields.get(38).setPoint(new Point(610, 100));
		fields.get(39).setPoint(new Point(670, 100));
		fields.get(40).setPoint(new Point(710, 100));
		fields.get(41).setPoint(new Point(760, 100));
		fields.get(42).setPoint(new Point(806, 100));
		fields.get(43).setPoint(new Point(850, 100));
		fields.get(44).setPoint(new Point(890, 110));
		fields.get(45).setPoint(new Point(930, 110));
		fields.get(46).setPoint(new Point(960, 120));
		fields.get(47).setPoint(new Point(990, 130));
		fields.get(48).setPoint(new Point(1030, 130));
		fields.get(49).setPoint(new Point(1070, 130));
		fields.get(50).setPoint(new Point(1110, 140));
		fields.get(51).setPoint(new Point(1150, 140));
		fields.get(52).setPoint(new Point(1165, 180));
		fields.get(53).setPoint(new Point(1200, 195));
		fields.get(54).setPoint(new Point(1200, 235));
		fields.get(55).setPoint(new Point(1200, 262));
		fields.get(56).setPoint(new Point(1200, 295));
		fields.get(57).setPoint(new Point(1240, 310));
		fields.get(58).setPoint(new Point(1240, 345));
		fields.get(59).setPoint(new Point(1240, 375));
		fields.get(60).setPoint(new Point(1240, 400));
		fields.get(61).setPoint(new Point(1230, 430));
		fields.get(62).setPoint(new Point(1230, 460));
		fields.get(63).setPoint(new Point(1220, 490));
		fields.get(64).setPoint(new Point(1220, 530));
		fields.get(65).setPoint(new Point(1210, 560));
		fields.get(66).setPoint(new Point(1180, 580));
		fields.get(67).setPoint(new Point(1138, 590));
		fields.get(68).setPoint(new Point(1105, 610));
		fields.get(69).setPoint(new Point(1055, 620));
		fields.get(70).setPoint(new Point(1030, 620));
		fields.get(71).setPoint(new Point(1000, 620));
		fields.get(72).setPoint(new Point(975, 630));
		fields.get(73).setPoint(new Point(930, 640));
		fields.get(74).setPoint(new Point(890, 640));
		fields.get(75).setPoint(new Point(850, 640));
		fields.get(76).setPoint(new Point(815, 640));
		fields.get(77).setPoint(new Point(755, 650));
		fields.get(78).setPoint(new Point(730, 650));
		fields.get(79).setPoint(new Point(690, 650));
	}
}




























