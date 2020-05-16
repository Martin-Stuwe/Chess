package figures;

import game.Board;
import game.Figures;

/**
 * Class for the figure: pawn
 * @author Martin Stuwe 676421
 * @author Zeyi Sun
 * @author Richard Tank
 * @author Fin Niklas Tiedemann
 * group 23
 * it1
 */
public class Pawn extends Figures {
	
	/**
	 *  the String shown on the board in the console
	 */
	private String boardVisual;
	
	/**
	 * the x axis position of the pawn 
	 */
	public int pos1;
	
	/**
	 * the y axis position of the pawn
	 */
	public int pos2;
	
	/**
	 * the color of the pawn
	 */
	private String color;
	
	/**
	 * the constructor creates a new pawn object and needs a x and a y axis position plus a color
	 * @param pos1 x axis position of the pawn
	 * @param pos2 y axis position of the pawn
	 * @param color color of the pawn, valid input: "w" for white, "b" for black
	 */
	public Pawn(int pos1, int pos2, String color) {
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.color = color;
		this.type = 4;
	}
	
	/**
	 * get-method of boardVisual
	 * if color is "w" boardVisual is in capital letter
	 * if color is "b" boardVisual is in lower case letter
	 * @return boardVisual of the pawn as a String
	 */
	public String getBoardVisual() {
		if(this.color =="w") {
			this.boardVisual = "P";
			return boardVisual;
		}
		else if(this.color =="b") {
			this.boardVisual = "p";
			return boardVisual;
		}
		else {
			return boardVisual;
		}
			
	}
	
	/**
	 * set-method of x and y axis position
	 * @param pos1 new x axis position of pawn
	 * @param pos2 new y axis position of pawn
	 */
	public void setPos(int Pos1, int Pos2) { 
		this.pos1 = Pos1;
		this.pos2 = Pos2;
	}
	
	/**
	 * get-method of color
	 * @return color of the pawn as a String
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * get-method of Type
	 * @return type of the pawn as an Integer
	 */
	public int getType() {
		return type;
	}
	
	/**
	 * Checks if the current move is valid
	 * @param board ,the board on which the move is tested on
	 * @param x for the x axis position to move to
	 * @param y for the y axis position to move to
	 * @return true for valid move 
	 * @return false for invalid move
	 */
	public boolean validMove(Board board,int x, int y) {

		// check if the field to move to is on the board
		if(x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}
		
		// en passant for white
		else if(this.color=="w"&&pos2==3&&y==2&&board.movedList.get(board.movedList.size()-1).getFigure().getType()==4&&    
				board.movedList.get(board.movedList.size()-1).getTo2()-board.movedList.get(board.movedList.size()-1).getFrom2()  ==2 ) {
				if (  
				(board.movedList.get(board.movedList.size()-1).getFigure()==board.getField(pos1+1, pos2) &&x==pos1+1 ) ||
				(board.movedList.get(board.movedList.size()-1).getFigure()==board.getField(pos1-1, pos2) &&x==pos1-1) ) {
				board.setNull(board.movedList.get(board.movedList.size()-1).getTo1(),board.movedList.get(board.movedList.size()-1).getTo2());
				return true; 
				}
				return false;
		}
		return validmove2(board,x,y);
		}
		public  boolean validmove2(Board board, int x, int y){
			
		// en passant for black
		if(this.color=="b"&&pos2==4&&y==5&&board.movedList.get(board.movedList.size()-1).getFigure().getType()==4 &&    
				board.movedList.get(board.movedList.size()-1).getTo2()-board.movedList.get(board.movedList.size()-1).getFrom2()  ==-2) {
					if( (board.movedList.get(board.movedList.size()-1).getFigure()==board.getField(pos1-1, pos2) &&x==pos1-1) || 
						( board.movedList.get(board.movedList.size()-1).getFigure()==board.getField(pos1+1, pos2) &&x==pos1+1 )) {
						board.setNull(board.movedList.get(board.movedList.size()-1).getTo1(),board.movedList.get(board.movedList.size()-1).getTo2());
						return true; 
					}
					return false;			
		}
		return validmove3(board,x,y);
		}
		public boolean validmove3(Board board, int x, int y) {
			
		
		// normal move white
		if(this.color =="w" && this.pos1 == x && this.pos2 == y+1) {
			
			return board.getField(x, this.pos2-1) == null;
			
			
		}
		
		// normal move black
		else if(this.color =="b" && this.pos1 == x && this.pos2 == y-1) {
			return board.getField(x, this.pos2+1) == null;
		}
		
		// double move white
		else if(this.color =="w" && this.pos1 == x && this.pos2 == y+2 && this.pos2 == 6) {
			if(board.getField(x, this.pos2-1) != null) {
				return false;
			}
			else if(board.getField(x, this.pos2-2) != null) {
				return false;
			}
						
				return true;

		}
		return validmove4(board,x,y);
		}
		
		public boolean validmove4(Board board, int x, int y){
		// double move black
		if(this.color =="b" && this.pos1 == x && this.pos2 == y-2 && this.pos2 == 1) {
			if(board.getField(x, this.pos2+1) != null) {
				return false;
			}
			else if(board.getField(x, this.pos2+2) != null) {
				return false;
			}
			
				return true;
			
		}
		
		// take move black
		else if(this.color =="b" && this.pos1 == x+1 && this.pos2 == y-1 || this.color =="b" && this.pos1 == x-1 && this.pos2 == y-1) {
			if(board.getField(x, y)!= null){
				return board.getField(x, y).getColor()=="w";
			}
			else {
				return false;
			}
		}
		
		// take move white
		else if(this.color =="w" && this.pos1 == x+1 && this.pos2 == y+1 || this.color =="w" && this.pos1 == x-1 && this.pos2 == y+1) {
			if(board.getField(x, y)!= null){
				return board.getField(x, y).getColor()=="b";
				
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}


