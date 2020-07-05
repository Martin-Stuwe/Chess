package game;

import figures.Bishop;
import figures.Pawn;
import figures.Rook;


/**
 * Class for the AI Calculations
 * @author Martin Stuwe 676421
 * @author Zeyi Sun
 * @author Richard Tank
 * @author Fin Niklas Tiedemann
 * group 23
 * it2
 */
public class AICalcs {
	
	
	/**
	* Method to evaluate the current position based on the figure type
	* @param figure the figure to evaluate
	* @param x the x position on the board
	* @param y the y position on the board
	* @return val the value based on the position
	*/
	 public static int positionEval(Figures figure, int x, int y) {
	         String name = figure.getClass().toString();
	         int val=0;
	         int valnew=0;
	         switch(name) {
	         case "Pawn":
	        	 
		          if(figure.getColor()=="w") {
		        	  val += 100 + Pawn.getTable()[8*(7 - y) + x]; 
		          }
		          if(figure.getColor()=="b") {
		        	  val -= 100 + Pawn.getTable()[8 + (8* y) - (1 +x)];
		           }
		           break;
	
	         case "Rook":
	        	 
		        if(figure.getColor()=="w") {
		           val += 500 + Rook.getTable()[8*(7 - y) + x]; 
		        	 }
		        if(figure.getColor()=="b") {
		        	val -= 500 + Rook.getTable()[8 + (8* y) - (1 +x)];
		        
		        }
		        break;
	         }
	         valnew = positionEvalBK(name,x,y,figure.getColor(),val);
	         return valnew;
	     }
	 
	 
		/**
		* Method to evaluate the current position based for King, Queen and Knight
		* @param figure the figure to evaluate
		* @param x the x position on the board
		* @param y the y position on the board
		* @return val the value based on the position
		*/	 
		 public static int positionEvalBK(String name, int x, int y, String color, int val) {
			 int val2=val;
			 switch(name) {
		       case "Bishop":
		        	 
		    	   if(color=="w") {
		        		 val2 += 330 + Bishop.getTable()[8*(7 - y) + x]; 
		        	}
		        	if(color=="b") {
		        		val2 -= 330 + Bishop.getTable()[8 + (8* y) - (1 +x)];
		        	}
		        	break;
			 
				 	case "Knight":
		    	 
			    	if(color=="w") {
			    		val2 += 320 + figures.Knight.getTable()[8*(7 - y) + x];
			    	}
			    	if(color=="b") {
			    		val2 -= 320 + figures.Knight.getTable()[8 + (8* y) - (1 +x)];
			    	}
		    	
			    	break;
			 }
			 val2 = positionEvalQK(name,x,y,color,val2);
			 return val2=val+val2;
		 }
			
		 
		 /**
		  * Method to evaluate the current position based for King, Queen and Knight
		  * @param figure the figure to evaluate
		  * @param x the x position on the board
		  * @param y the y position on the board
		  * @return val the value based on the position
		  */	 
		 public static int positionEvalQK(String name, int x, int y, String color, int val) {
			 int valnew=0;
			 switch(name) {
			
			
			     case "Queen":
			    	 if(color=="w") {	     
			    		 valnew += 900 + figures.Queen.getTable()[8*(7 - y) + x]; 
			    	 }
			    	 if(color=="b") {	
			    		 valnew -= 900 + figures.Queen.getTable()[8 + (8* y) - (1 +x)];
			    	 }
			       break;
			
			
			     case "King":
			    	 if(color=="w") {
			    		 valnew += 20000 + figures.King.getTable()[8*(7 - y) + x]; 
			    	 }
			    	 if(color=="b") {	
			    		 valnew -= 20000 + figures.King.getTable()[8 + (8* y) - (1 +x)];
			    	 }
			       break;
				 }
		       return valnew=val+valnew;
		   }

}
