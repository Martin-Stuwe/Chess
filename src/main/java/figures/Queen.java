package figures;

import game.Board;
import game.Figures;

/**
 * Class for the figure: queen
 * @author Martin Stuwe 676421
 * @author Zeyi Sun
 * @author Richard Tank
 * @author Fin Niklas Tiedemann
 * group 23
 * it1
 */
public class Queen extends Figures {
	 
	/**
	 *  the String shown on the board in the console
	 */
	private String boardVisual;
	
	/**
	 * the x axis position of the queen
	 */
	public int pos1;
	
	/**
	 * the y axis position of the queen 
	 */
	public int pos2;
	
	/**
	 * the color of the queen
	 */
	private String color;
	
	/**
	 * the constructor creates a new queen object and needs a x and a y axis position plus a color
	 * @param pos1 x axis position of the queen
	 * @param pos2 y axis position of the queen
	 * @param color color of the queen, valid input: "w" for white, "b" for black
	 */
	public Queen(int pos1, int pos2, String color) {
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.color = color;
		this.type = 5;
	}
	
	/**
	 * get-method of boardVisual
	 * if color is "w" boardVisual is in capital letter
	 * if color is "b" boardVisual is in lower case letter
	 * @return boardVisual of the queen as a String
	 */
	public String getBoardVisual() {
		if(this.color =="w") {
			this.boardVisual = "Q";
			return boardVisual;
		}
		else if(this.color =="b") {
			this.boardVisual = "q";
			return boardVisual;
		}
		else {
			return boardVisual;
		}
			
	}
	
	/**
	 * set-method of x and y axis position
	 * @param pos1 new x axis position of queen
	 * @param pos2 new y axis position of queen
	 */
	public void setPos(int Pos1, int Pos2) { 
		this.pos1 = Pos1;
		this.pos2 = Pos2;
	}
	
	/**
	 * get-method of color
	 * @return color of the queen as a String
	 */
	public String getColor(){
		return color;
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
		Rook QRook = new Rook(this.pos1, this.pos2, this.color);
		Bishop QBishop = new Bishop(this.pos1, this.pos2, this.color);
		if(QRook.validMove(board, x, y) || QBishop.validMove(board, x, y)) {
			return true;
			
		}

			return false;
		
	}
}

