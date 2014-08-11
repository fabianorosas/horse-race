package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class ScoreBoard{
	private PrintWriter writer;
	private BufferedReader reader;
	private File file;
	private Map<String, String> mapScore = new HashMap<String, String>();
	
	public ScoreBoard(){
		reader();
	}
	
	public ScoreBoard(String nome){
		reader();
		scoreWriter(nome);
	}
	
	private void scoreWriter(String nome){
		if(getMapScore().isEmpty() || !getMapScore().containsKey(nome))
			getMapScore().put(nome, "100");
		else{
			Integer num = Integer.parseInt(getMapScore().get(nome));
			num += 100;
			getMapScore().put(nome, String.valueOf(num));
		}
		
		writer();
	}
	
	protected void reader(){
		try {
		    file = new File("score");  
			
			if(file.canRead() == false)
				return;
			
			reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null){
				String[] array = line.split(" ");
				getMapScore().put(array[0], array[1]);
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void writer(){
		try {
			writer = new PrintWriter("score", "UTF-8");
			
			for(String nome : getMapScore().keySet())
				writer.println(nome + " " + getMapScore().get(nome));
			
			writer.close();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public Map<String, String> getMapScore() {
		return mapScore;
	}

	public void setMapScore(Map<String, String> mapScore) {
		this.mapScore = mapScore;
	}
}


