package app;

public class GameInProgressException extends Exception {
      public GameInProgressException(){
    	  
      }

      public GameInProgressException(String message){
         super(message);
      }
}
