package game;

import java.util.LinkedList;
import java.util.Random;

import engine.GameMechanics;

public class HorseRace {
	private LinkedList<Horse> horses; 
	private GameMechanics logic ;
	
	public HorseRace(int numberHorses){	
		horses = new LinkedList<Horse>();
		createHorses(numberHorses);
		logic = new GameMechanics(horses);
	}
	
	private LinkedList<Horse> createHorses(int num){
		LinkedList<String> colors = new LinkedList<String>();
		colors.add("mostarda");
		colors.add("amarelo");
		colors.add("verde");
		colors.add("azul");
		colors.add("vermelho");
		colors.add("preto");
		
		for(int i = 0; i < num; i++)
			horses.add(new Horse(colors.get(i)));	
		return horses;
	}
	
	private int randomNum(){
		return (new Random()).nextInt(6);
	}
	
	public void playGame(){
		while(true){
			for(Horse horse :  horses){
				int field = logic.forwardBoard(horse, randomNum());
				
				if(field == 0)
					System.out.println("O cavalo " + horse.getColor() + " devera esperar a proxima rodada");
				else if(field == 80){
					System.out.println("O cavalo " + horse.getColor() + " ganhou a corrida. Parabens ao cavalo");
					System.exit(0);
				}
				else
					System.out.println("O cavalo " + horse.getColor() + " avancou para a casa " + field);
			}
		}
	}
}


