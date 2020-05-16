package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import figures.Bishop;
import figures.King;
import figures.Knight;
import figures.Pawn;
import figures.Queen;
import figures.Rook;

/**
* Class for the Chess Board
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* group 23
* it1
*/
public class Board {
	
	/**
	 * actual board shown in the console
	 */
	public String Feld;
	
	/**
	 * boolean to check if game is live (not used)
	 */
	private boolean gameLive = true;
	
	/**
	 * Array for all positions as Figures objects
	 */
	Figures[][] positionen= new Figures[8][8]; //Array to store each field later change to figure or field object
	
	/**
	 * Array for all board symbols as String
	 */
	String[][] positionenS = new String[8][8];
	
	/**
	* List with all previous beaten Figures
	*/
	public List<String> beaten = new ArrayList<String>();
	
	/**
	 * List with all previous moves
	 */
	public List<Zug> movedList = new ArrayList<Zug>();
	
	/**
	 * check if black is in check
	 */
	public boolean blackCheck;
	
	/**
	 * check if white is in check
	 */
	public boolean whiteCheck;
	
	
	/**
	 * integer to store whose turn it is currently
	 * 0 = white, 1 = black
	 */
	int CurrentTurn; 
	
	/**
	* Initializes all initial Figures objects
	*/
	Rook Rook1b = new Rook(0,0,"b");
	Rook Rook2b = new Rook(7,0,"b");
	Rook Rook1w = new Rook(0,7,"w");
	Rook Rook2w = new Rook(7,7,"w");
	Knight Knight1b = new Knight(1,0,"b");
	Knight Knight2b = new Knight(6,0,"b");
	Knight Knight1w = new Knight(1,7,"w");
	Knight Knight2w = new Knight(6,7,"w");
	Bishop Bishop1b = new Bishop(2,0,"b");
	Bishop Bishop2b = new Bishop(0,5,"b");
	Bishop Bishop1w = new Bishop(2,7,"w");
	Bishop Bishop2w = new Bishop(5,7,"w");
	Queen Queen1b = new Queen(3,0,"b");
	Queen Queen1w = new Queen(3,7,"w");
	King King1b	= new King(4,0,"b");
	King King1w = new King(4,7,"w");
	
	/**
	 * get-method for gameLive
	 * @return gameLive
	 */
	public boolean isGameLive() {
		return gameLive;
	}
	
	/**
	 * get-method for the beaten figures list
	 * @return beaten list of beaten figures
	 */
	public List<String> getBeaten() {
		return beaten;
	}
	
	/**
	 * get-method for all moves played before
	 * @return movedList list of moves played before
	 */
	public List<Zug> getPreMoves() {
		return movedList;
	}
	
	/**
	 * set-method for gameLive
	 * @param gameLive true or false depending on game state
	 */
	public void setGameLive(boolean gameLive) {
		this.gameLive = gameLive;
	}
	
	/**
	 * method to initialize the board
	 * also works to update the board
	 */
	public void initializeBoard() { 
		
		// gets boardVisual of figures if existing
		for(int i =0; i<8;i++) {
			for(int y =0; y<8;y++) {
				
				if(positionen[i][y] == null) {
					positionenS[i][y] = " ";
				}
				
				else {
					positionenS[i][y] = positionen[i][y].getBoardVisual();
				}
			}
			
		} 
		
		// the actual board
		this.Feld = "8"+" "+  positionenS[0][0] +" "+  positionenS[1][0] +" "+  positionenS[2][0] +" "+  positionenS[3][0] +" "+ positionenS[4][0] +" "+  positionenS[5][0] +" "+  positionenS[6][0] +" "+  positionenS[7][0] + "\n" 
				  + "7"+" "+  positionenS[0][1] +" "+  positionenS[1][1] +" "+  positionenS[2][1] +" "+  positionenS[3][1] +" "+ positionenS[4][1] +" "+  positionenS[5][1] +" "+  positionenS[6][1] +" "+  positionenS[7][1] +"\n" 
				  + "6"+" "+  positionenS[0][2] +" "+  positionenS[1][2] +" "+  positionenS[2][2] +" "+  positionenS[3][2] +" "+ positionenS[4][2] +" "+  positionenS[5][2] +" "+  positionenS[6][2] +" "+  positionenS[7][2]+"\n" 
				  + "5"+" "+  positionenS[0][3] +" "+  positionenS[1][3] +" "+  positionenS[2][3] +" "+  positionenS[3][3] +" "+ positionenS[4][3] +" "+  positionenS[5][3] +" "+  positionenS[6][3] +" "+  positionenS[7][3] +"\n"
				  + "4"+" "+  positionenS[0][4] +" "+  positionenS[1][4] +" "+  positionenS[2][4] +" "+  positionenS[3][4] +" "+ positionenS[4][4] +" "+  positionenS[5][4] +" "+  positionenS[6][4] +" "+  positionenS[7][4] +"\n" 
				  + "3"+" "+  positionenS[0][5] +" "+  positionenS[1][5] +" "+  positionenS[2][5] +" "+  positionenS[3][5] +" "+ positionenS[4][5] +" "+  positionenS[5][5] +" "+  positionenS[6][5] +" "+  positionenS[7][5] +"\n"
				  + "2"+" "+  positionenS[0][6] +" "+  positionenS[1][6] +" "+  positionenS[2][6] +" "+  positionenS[3][6] +" "+ positionenS[4][6] +" "+  positionenS[5][6] +" "+  positionenS[6][6] +" "+  positionenS[7][6] +"\n" 
				  + "1"+" "+  positionenS[0][7] +" "+  positionenS[1][7] +" "+  positionenS[2][7] +" "+  positionenS[3][7] +" "+ positionenS[4][7] +" "+  positionenS[5][7] +" "+  positionenS[6][7] +" "+  positionenS[7][7] +"\n"
				  + " "+" a"+" b"+" c"+ " d"+" e"+" f"+" g"+" h";
		
		System.out.println(Feld);
	} 
	
	/**
	 * sets starting position of all figures
	 */
	public void setStart() {
		setField(0,0, Rook1b);
		setField(1,0, Knight1b);
		setField(2,0, Bishop1b);
		setField(3,0, Queen1b);
		setField(4,0, King1b);
		setField(5,0, Bishop2b);
		setField(6,0, Knight2b);
		setField(7,0, Rook2b);
		setField(0,7, Rook1w);
		setField(1,7, Knight1w);
		setField(2,7, Bishop1w);
		setField(3,7, Queen1w);
		setField(4,7, King1w);
		setField(5,7, Bishop2w);
		setField(6,7, Knight2w);
		setField(7,7, Rook2w);
		for (int i = 0;i<8; i++) {
			Pawn Pawnb = new Pawn(i,1,"b");
			Pawn Pawnw = new Pawn(i,6,"w");
			setField(i,1, Pawnb);
			setField(i,6, Pawnw);
		}
	}
	
	/**
	 * get-method for certain fields on the board
	 * @param pos1 x axis position on the board
	 * @param pos2 y axis position on the board
	 * @return figure on the position on the board
	 */
	public Figures getField(int pos1, int pos2) {
		return this.positionen[pos1][pos2];
	}
	
	/**
	 * set-method for certain fields on the board
	 * @param pos1 x axis position on the board
	 * @param pos2 y axis position on the board
	 * @param setTo figure to place on the field
	 */
	public void setField(int pos1, int pos2, Figures setTo) {
		this.positionen[pos1][pos2] = setTo;
		this.positionen[pos1][pos2].setPos(pos1, pos2);
	}
	
	/**
	 * emptying certain field on the board
	 * @param pos1 x axis position on the board
	 * @param pos2 y axis position on the board
	 */
	public void setNull(int pos1, int pos2) {
		positionen[pos1][pos2]=null;
	}
	
	
	/**
	* Converts the user input for position to internal conform input
	* @param board: board object pos2from: second position integer e.g.: 1 (a1)
	* @param pos1from first position character e.g.: a (a1)
	* @param pos2from second position integer e.g.: 1 (a1)
	* @return converted version as String e.g.: 07
	*/
	public String ConvertMoveInput(Board board, char pos1from, int pos2from) { 
		
		// integer to save first position
		int pos1new;
		
		switch (pos1from) {
		case 'a':
			pos1new =0;
			break;
		case 'b':
			pos1new =1;
			break;
		case 'c':
			pos1new =2;
			break;
		case 'd':
			pos1new =3;
			break;
		case 'e':
			pos1new =4;
			break;
		case 'f':
			pos1new =5;
			break;
		case 'g':
			pos1new =6;
			break;
		case 'h':
			pos1new =7;
			break;
		default:
			pos1new=420;
			return "420";
			
		}
		// integer to save second position
		int pos2new = pos2from;
	
		if (pos2new < 1 || pos2new >8) {
			return "420";
		}
		else {
			pos2new =-1*(pos2from-8);
		}
		return pos1new+Integer.toString(pos2new);

	}
	
	/**
	 * set-method to set current players turn
	 * @param x 0 if white, 1 if black
	 */
	public void setCurrentTurn(int x) {
		CurrentTurn = x;
	}
	
	/**
	 * get-method to get current players turn
	 * @return CurrentTurn 0 if white, 1 if black
	 */
	public int getCurrentTurn() {
		return CurrentTurn;
	}
	
	
	/**
	 * checks if a player is in check
	 * @return true if a player is in check
	 */
	public boolean checkCheck() {
		for(int i =0; i<8;i++) {
			for(int y =0; y<8;y++) {
				for(int k =0; k<8;k++) {
					for(int j =0; j<8;j++) {
						// check if white is in check
						if(positionen[i][y] == King1w && positionen[k][j]!= null && positionen[k][j].validMove(this, i, y) && positionen[k][j].getColor() != positionen[i][y].getColor()) {
							whiteCheck = true;
							return true;	
						} 
				
						// check if black is in check
						else if (positionen[i][y] == King1b && positionen[k][j]!= null && positionen[k][j].validMove(this, i, y) && positionen[k][j].getColor() != positionen[i][y].getColor()) {
							blackCheck = true;
							return true;
						}
					}
				}
			} 
		}
		blackCheck = false;
		whiteCheck = false;
		return false;
	}
	
	/**
	 * check if field is in check (to check if castling is possible)
	 */
	public boolean checkField(int x, int y, String color) {
		for(int k =0; k<8;k++) {
			for(int j =0; j<8;j++) {
				if(positionen[k][j]!= null &&positionen[k][j].getType() !=2 && positionen[k][j].validMove(this, x, y) && positionen[k][j].getColor() != color) {			
						return true;
					
				}
				
			}
			
		} 
		return false;
	}
	
	/**
	 * check if current player has a possible move
	 * @return true if current player has a possible move
	 */
	public boolean checkPossibleMoves() {
		for(int i =0; i<8;i++) {
			for(int y =0; y<8;y++) {
				
				// check if white has possible move
				if(positionen[i][y] == King1w) {
					for(int k =0; k<8;k++) {
						for(int j =0; j<8;j++) {
							if(positionen[k][j]!= null&&positionen[k][j].getColor() == positionen[i][y].getColor()) {
									for(int a =0; a<8;a++) {
										for(int b =0; b<8;b++) {
											if(positionen[k][j]!= null&&positionen[k][j].hasPossibleMove(this, k, j, a, b)) {
													return true;
												
											
										}
									}
								}
							}	
						}	
					} 
				}
				
				// check if black has possible move
				else if (positionen[i][y] == King1b ) {
					for(int k =0; k<8;k++) {
						for(int j =0; j<8;j++) {
							if(positionen[k][j]!= null&&positionen[k][j].getColor() == positionen[i][y].getColor()) {
									for(int a =0; a<8;a++) {
										for(int b =0; b<8;b++) {
											if(positionen[k][j]!= null&&positionen[k][j].hasPossibleMove(this, k, j, a, b)) {
													return true;
												
											
										}
									}
								}
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
	 * @return true if no checkmate possible anymore
	 */
	public boolean checkDraw() {
		// figures that together can not checkmate anymore
		ArrayList<String> draw1 = new ArrayList<String>(Arrays.asList(new String[]{"K", "k", "B"}));
		ArrayList<String> draw2 = new ArrayList<String>(Arrays.asList(new String[]{"K","k","b"}));
		ArrayList<String> draw3 = new ArrayList<String>(Arrays.asList(new String[]{"K","k","n"}));
		ArrayList<String> draw4 = new ArrayList<String>(Arrays.asList(new String[]{"K","k","N"}));
		ArrayList<String> test = new ArrayList<String>();
		
		// adding figures to arraylist
		for(int i = 0; i<8; i++) {
			for(int y = 0; y<8; y++) {
				if(positionen[i][y] != null) {
					test.add(positionen[i][y].getBoardVisual());
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
		
		else return false;
	}
}
