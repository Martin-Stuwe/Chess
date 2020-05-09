/**
* Class for the Chess Board
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* Gruppe 23
*/





package game;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;


import figures.*;

public class Board {
	
	String Feld; //store for the actual board
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
	LinkedList<String> beaten = new LinkedList<String>();
	
	/**
	* List with all previous moves
	*/
	public LinkedList<Zug> movedList = new LinkedList<Zug>();
	
	public boolean blackCheck;
	public boolean whiteCheck;
	public boolean lastCheck;
	
	//Field object for highlighting prob needed
	int CurrentTurn; // 0=weis  1=schwarz
	
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
	
	public boolean getGameLive() {
		return gameLive;
	}
	public LinkedList<String> getBeaten() {
	
		return beaten;
	}
	
	public LinkedList<Zug> getPreMoves() {
		
		return movedList;
	}
	public void setGameLive(boolean gameLive) {
		
	}
	
	public void initializeBoard() { //Method to init the console based board. Also acts as updater
		
		for(int i =0; i<8;i++) {
			for(int y =0; y<8;y++) {
				
				if(positionen[i][y] == null) {
					positionenS[i][y] = " ";
				}
				
				else {
					positionenS[i][y] = positionen[i][y].getBoardVisual();
				}
			}
			
		} //test
		
		this.Feld = "8"+" "+  positionenS[0][0] +" "+  positionenS[1][0] +" "+  positionenS[2][0] +" "+  positionenS[3][0] +" "+ positionenS[4][0] +" "+  positionenS[5][0] +" "+  positionenS[6][0] +" "+  positionenS[7][0] + "\n" 
				  + "7"+" "+  positionenS[0][1] +" "+  positionenS[1][1] +" "+  positionenS[2][1] +" "+  positionenS[3][1] +" "+ positionenS[4][1] +" "+  positionenS[5][1] +" "+  positionenS[6][1] +" "+  positionenS[7][1] +"\n" 
				  + "6"+" "+  positionenS[0][2] +" "+  positionenS[1][2] +" "+  positionenS[2][2] +" "+  positionenS[3][2] +" "+ positionenS[4][2] +" "+  positionenS[5][2] +" "+  positionenS[6][2] +" "+  positionenS[7][2]+"\n" 
				  + "5"+" "+  positionenS[0][3] +" "+  positionenS[1][3] +" "+  positionenS[2][3] +" "+  positionenS[3][3] +" "+ positionenS[4][3] +" "+  positionenS[5][3] +" "+  positionenS[6][3] +" "+  positionenS[7][3] +"\n"
				  + "4"+" "+  positionenS[0][4] +" "+  positionenS[1][4] +" "+  positionenS[2][4] +" "+  positionenS[3][4] +" "+ positionenS[4][4] +" "+  positionenS[5][4] +" "+  positionenS[6][4] +" "+  positionenS[7][4] +"\n" 
				  + "3"+" "+  positionenS[0][5] +" "+  positionenS[1][5] +" "+  positionenS[2][5] +" "+  positionenS[3][5] +" "+ positionenS[4][5] +" "+  positionenS[5][5] +" "+  positionenS[6][5] +" "+  positionenS[7][5] +"\n"
				  + "2"+" "+  positionenS[0][6] +" "+  positionenS[1][6] +" "+  positionenS[2][6] +" "+  positionenS[3][6] +" "+ positionenS[4][6] +" "+  positionenS[5][6] +" "+  positionenS[6][6] +" "+  positionenS[7][6] +"\n" 
				  + "1"+" "+  positionenS[0][7] +" "+  positionenS[1][7] +" "+  positionenS[2][7] +" "+  positionenS[3][7] +" "+ positionenS[4][7] +" "+  positionenS[5][7] +" "+  positionenS[6][7] +" "+  positionenS[7][7] +"\n"
				  + " "+" a"+" b"+" c"+ " d"+" e"+" f"+" g"+" h";
		
	} 
	
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
	
	
	public Figures getField(int pos1, int pos2) {
		return this.positionen[pos1][pos2];
	}
	
	
	public void setField(int pos1, int pos2, Figures setTo) {
		this.positionen[pos1][pos2] = setTo;
		this.positionen[pos1][pos2].setPos(pos1, pos2);
	}
	
	public void setNull(int pos1, int pos2) {
		positionen[pos1][pos2]=null;
	}
	
	
	/**
	* Converts the user input for position to internal conform input
	* @param board: board object, pos1from: first position character e.g.: A, pos2from: second position integer e.g.: 1 (a1)
	* @return converted version as String e.g.: 07
	*/
	public String ConvertMoveInput(Board board, char pos1from, int pos2from) { //UserInput umwandeln für gewählte Figur.
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
	int pos2new = pos2from;
	if (pos2new < 1 || pos2new >8) {
		return "420";
	}
	else {
		pos2new =-1*(pos2from-8);
	}
	return pos1new+Integer.toString(pos2new);

	}
	public void setCurrentTurn(int x) {
		CurrentTurn = x;
	}
	
	public int getCurrentTurn() {
		return CurrentTurn;
	}
	
	public void checkGameEnded() {
		
	}
	
	public boolean checkCheck() {
		for(int i =0; i<8;i++) {
			for(int y =0; y<8;y++) {
				
				if(positionen[i][y] == King1w) {
					for(int k =0; k<8;k++) {
						for(int j =0; j<8;j++) {
							if(positionen[k][j]!= null) {
							if(positionen[k][j].validMove(this, i, y) == true && positionen[k][j].getColor() != positionen[i][y].getColor()) {
							
							whiteCheck = true;
							return true;
							}
							}
							
						}
						
					} 
				}
				
				else if (positionen[i][y] == King1b ) {
					for(int k =0; k<8;k++) {
						for(int j =0; j<8;j++) {
							if(positionen[k][j]!= null) {
							if(positionen[k][j].validMove(this, i, y) == true && positionen[k][j].getColor() != positionen[i][y].getColor()) {
							
							blackCheck = true;
							return true;
							}
							}
							
						}
						
					} 
				}
			}
			
		} 
		
		blackCheck = false;
		whiteCheck = false;
		return false;
	}
	
	public boolean checkField(int x, int y, String color) {
		for(int k =0; k<8;k++) {
			for(int j =0; j<8;j++) {
				if(positionen[k][j]!= null &&positionen[k][j].getType() !=2) {
				if(positionen[k][j].validMove(this, x, y) == true && positionen[k][j].getColor() != color) {			
				return true;
				}
				}
				
			}
			
		} 
		return false;
	}
	public boolean checkPossibleMoves() {
		for(int i =0; i<8;i++) {
			for(int y =0; y<8;y++) {
				
				if(positionen[i][y] == King1w) {
					for(int k =0; k<8;k++) {
						for(int j =0; j<8;j++) {
							if(positionen[k][j]!= null) {
							if(positionen[k][j].getColor() == positionen[i][y].getColor()) {
								for(int a =0; a<8;a++) {
									for(int b =0; b<8;b++) {
										if(positionen[k][j]!= null) {
										if(positionen[k][j].hasPossibleMove(this, k, j, a, b)==true) {
											System.out.println(positionen[k][j] +"has a valid move");
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
				
				else if (positionen[i][y] == King1b ) {
					for(int k =0; k<8;k++) {
						for(int j =0; j<8;j++) {
							if(positionen[k][j]!= null) {
							if(positionen[k][j].getColor() == positionen[i][y].getColor()) {
								for(int a =0; a<8;a++) {
									for(int b =0; b<8;b++) {
										if(positionen[k][j]!= null) {
										if(positionen[k][j].hasPossibleMove(this, k, j, a, b)==true) {
											System.out.println(positionen[k][j] +"has a valid move");
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
				}
			}
			
		 
		
		return false;
	}
	
	public boolean checkDraw() {
		ArrayList<String> draw1 = new ArrayList<String>(Arrays.asList(new String[]{"K", "k", "B"}));
		ArrayList<String> draw2 = new ArrayList<String>(Arrays.asList(new String[]{"K","k","b"}));
		ArrayList<String> draw3 = new ArrayList<String>(Arrays.asList(new String[]{"K","k","n"}));
		ArrayList<String> draw4 = new ArrayList<String>(Arrays.asList(new String[]{"K","k","N"}));
		ArrayList<String> test = new ArrayList<String>();
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
