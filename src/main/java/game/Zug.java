package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import figures.King;

/**
 * Class for the moves
 * @author Martin Stuwe 676421
 * @author Zeyi Sun
 * @author Richard Tank
 * @author Fin Niklas Tiedemann
 * group 23
 * it2
 */
public class Zug {
	
	/**
	 * the figure that has been moved
	 */
	Figures figure;
	
	/**
	 * from where the figure has moved x axis position
	 */
	int from1;
	
	/**
	 * from where the figure has moved y axis position
	 */
	int from2;
	
	/**
	 * where the figure has moved to x axis position
	 */
	int to1;
	
	/**
	 * where the figure has moved to y axis position
	 */
	int to2;
	

	
	/**
	 * constructor for a zug object
	 * @param figure figure that has been moved
	 * @param from1 x axis position of starting field
	 * @param from2 y axis position of starting field
	 * @param to String of x and y axis position of the field to move to
	 */
	public Zug(Figures figure, int from1, int from2, String to) {  
		this.figure = figure;
		this.from1 = from1;
		this.from2 = from2;
		this.to1 = Character.getNumericValue(to.charAt(0));
		this.to2 = Character.getNumericValue(to.charAt(1));	
	}
	
	/**
	 * get-method for the figure object
	 * @return figure figure of the zug object
	 */
	public Figures getFigure() {
		return this.figure;
	}
	
	/**
	 * get-method for the integer from1
	 * @return from1 from1 integer of the zug object
	 */
	public int getFrom1() {
		return this.from1;
	}
	
	/**
	 * get-method for the integer from2
	 * @return from2 from2 integer of the zug object
	 */
	public int getFrom2() {
		return this.from2;
	}
	
	/**
	 * get-method for the integer to1
	 * @return to1 to1 integer of the zug object
	 */
	public int getTo1() {
		return this.to1;
	}
	
	/**
	 * get-method for the integer to2
	 * @return to2 to2 integer of the zug object
	 */
	public int getTo2() {
		return this.to2;
	}
	/**
	 * checks if a player is in check
	 * @param board board on which the check Test is on
	 * @return true if a player is in check
	 */
	public static boolean checkCheck(Board board) {
		board.whiteCheck=false;
		board.blackCheck=false;
		for(int i =0; i<8;i++) {
			for(int y =0; y<8;y++) {
				for(int k =0; k<8;k++) {
					for(int j =0; j<8;j++) {
						// check if white is in check
						if(board.positionen[i][y]!=null&&board.positionen[i][y].getClass() == King.class && checkCheckCheck(board,Integer.toString(i)+Integer.toString(j)+Integer.toString(k)+Integer.toString(y))) {
							if(board.positionen[i][y].getColor() == "w") {
								board.whiteCheck = true;
							}
							else{
								board.blackCheck=true;
							}
								
						}
					}
				}
			}
		}
		return board.whiteCheck||board.blackCheck;
	}


		
	
	/**
	 * method to check for check
	 * @param board the board the check of check is on
	 * @param num String of the x and y axis positions of the king and the figure that could do check
	 * @return true if other figure has validMove to king's position
	 */
	public static boolean checkCheckCheck(Board board,String num) {
		int i = Character.getNumericValue(num.charAt(0));
		int j = Character.getNumericValue(num.charAt(1));	
		int k = Character.getNumericValue(num.charAt(2));
		int y = Character.getNumericValue(num.charAt(3));	
		return board.positionen[k][j]!= null &&board.positionen[k][j].validMove(board, i, y) && board.positionen[k][j].getColor() != board.positionen[i][y].getColor();
	}

	
	/**
	 * method to check if certain Field would be in check
	 * @param x the x axis position of the field
	 * @param y the y axis position of the field
	 * @param color the color that needs to be checked for check
	 * @return true if field is in check
	 */
	public static boolean checkField(Board board,int x, int y, String color) {
		for(int k =0; k<8;k++) {
			for(int j =0; j<8;j++) {
				if(board.positionen[k][j]!= null &&board.positionen[k][j].getType() !=2 && board.positionen[k][j].validMove(board, x, y) && board.positionen[k][j].getColor() != color) {			
						return true;
					
				}
				
			}
			
		} 
		return false;
	}
	
	/**
	 * check if current player has a possible move
	 * @param board the board the move is o
	 * @return true if current player has a possible move
	 */
	public static boolean checkPossibleMoves(Board board) {
		boolean whitemoves=false;
		boolean blackmoves=false;
		for(int i =0; i<8;i++) {
			for(int y =0; y<8;y++) {
				
				// check if white or black has possible move
				if(board.positionen[i][y]!=null&&board.positionen[i][y].getClass() == King.class&&board.positionen[i][y].getColor()=="b") {
					blackmoves = Zug.checkPossibleMovesCheck(board,i, y); 
			
				}
				if(board.positionen[i][y]!=null&&board.positionen[i][y].getClass() == King.class&&board.positionen[i][y].getColor()=="w") {
					whitemoves = Zug.checkPossibleMovesCheck(board,i, y); 
			
				}
			}
		}
		return blackmoves||whitemoves;
	}
	
	/**
	 * method to check for possible moves
	 * @param board the board the check test is on
	 * @param i the x axis position of the king
	 * @param y the y axis position of the king
	 * @return true if figures have possible moves
	 */
	public static boolean checkPossibleMovesCheck(Board board, int i, int y) {
		for(int k =0; k<8;k++) {
			for(int j =0; j<8;j++) {
				if(board.positionen[k][j]!= null&&board.positionen[k][j].getColor() == board.positionen[i][y].getColor()) {
						for(int a =0; a<8;a++) {
							for(int b =0; b<8;b++) {
								if(board.positionen[k][j]!= null&&board.positionen[k][j].hasPossibleMove(board, k, j, Integer.toString(a)+Integer.toString(b))) {
										return true;
									
								
							}
						}
					}
				}	
			}	
		}
		return false;
	}
	
	/**
	 * check if there is no checkmate possible anymore
	 * @param board the board the draw is on
	 * @return true if no checkmate possible anymore
	 */
	public static boolean checkDraw(Board board) {
		// figures that together can not checkmate anymore
		ArrayList<String> draw1 = new ArrayList<String>(Arrays.asList(new String[]{"K", "k", "B"}));
		ArrayList<String> draw2 = new ArrayList<String>(Arrays.asList(new String[]{"K","k","b"}));
		ArrayList<String> draw3 = new ArrayList<String>(Arrays.asList(new String[]{"K","k","n"}));
		ArrayList<String> draw4 = new ArrayList<String>(Arrays.asList(new String[]{"K","k","N"}));
		ArrayList<String> test = new ArrayList<String>();
		
		// adding figures to arraylist
		for(int i = 0; i<8; i++) {
			for(int y = 0; y<8; y++) {
				if(board.positionen[i][y] != null) {
					test.add(board.positionen[i][y].getBoardVisual());
				}
			}
		}
		Collections.sort(draw1);
		Collections.sort(draw2);
		Collections.sort(draw3);
		Collections.sort(draw4);
		Collections.sort(test);
		
		// comparing board's arraylist to no checkmate positions
		if(test.equals(draw1)) {
			return true;
		}
		else if(test.equals(draw2)) {
			return true;
		}
		else if(test.equals(draw3)) {
			return true;
		}
		else if(test.equals(draw4)) {
			return true;
		}
		

			
		return false;
		
	}
}


