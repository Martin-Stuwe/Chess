package schach;

import java.util.Scanner;

import game.Board;
import game.StartGame;
import game.Time;
import game.Zug;

/**
 * Class for reading Console input
 * @author Martin Stuwe 676421
 * @author Zeyi Sun
 * @author Richard Tank
 * @author Fin Niklas Tiedemann
 * group 23
 * it1
 */
public class Console {
	/**
	 * clock of the console game
	 */
	static Time clock = new Time(600,600);
	
	/**
	 * the input as a String
	 */
	public String input;
	
	/**
	 * method to open the console
	 */
	public void open() {
		Scanner userInput = new Scanner(System.in);
		this.input = userInput.nextLine();
		userInput.close();
	}
	/**
	 * Method to read and react on user input
	 * @param console the console object with the users input
	 * @param board the actual Board object
	 */
	public static void checkUserInput(Console console, Board board) {
				if (console.input.equals("exit")){
			        StartGame.StartGameCommand();
				}
				
				// returns all beaten figures
				if (console.input.equals("beaten")){
					board.initializeBoard();
					System.out.println(board.beaten);			
					StartGame.getAndMakeMove(board);
				}
				
				if(console.input.equals("save")) {
					board.initializeBoard();
					StartGame.makeSaveConsole(board);
					StartGame.getAndMakeMove(board);
				}
				if(console.input.equals("undo")&&board.movedList.size()>0) {
					StartGame.undoMove(board);
					}
				if(console.input.equals("redo")&&StartGame.undoneTurns.size()>0) {
					StartGame.redoMove(board);
					
				}
	}
	
	/**
	 * Checks the user input, uses ConvertMoveInput to convert,
	 * adds the legit move to the previous moves list 
	 * @param board: the actual Board object
	 * @param console: the Console object
	 */
	public static void convertAndMove(Board board, Console console) { 
		// check if user input is valid (length)
		if(console.input.length() <5 ||console.input.length() >5 && console.input.charAt(5)!='Q' && console.input.charAt(5)!='R' && console.input.charAt(5)!='N' && console.input.charAt(5)!='B' && console.input.charAt(5)!=' ')  {
			board.initializeBoard();
			//System.out.println(board.Feld);
			System.out.println("!Invalid move");
			return;
		}
		convertAndMove2(board,console);
		
	}
	
	/**
	 * Uses ConvertMoveInput to convert, parses and checks for From != null,
	 * adds the legit move to the previous moves list 
	 * @param board: the actual Board object
	 * @param console: the Console object
	 */
	public static void convertAndMove2(Board board, Console console){
		
		// converting the user input into Strings
		String From=board.ConvertMoveInput(board,console.input.charAt(0),Character.getNumericValue(console.input.charAt(1)));
		String To = board.ConvertMoveInput(board,console.input.charAt(3),Character.getNumericValue(console.input.charAt(4)));
		
		// check if user input is valid (- as third character)
		if (From =="420" || To =="420" || console.input.charAt(2)!='-' ){
			board.initializeBoard();
			//System.out.println(board.Feld);
			System.out.println("!Invalid move");
			return;
		}
	
		// converting Strings into Integers
		int From1=Integer.parseInt(Character.toString(From.charAt(0))); 
		int From2=Integer.parseInt(Character.toString(From.charAt(1))); 
				
		// check if input empty
		if (board.getField(From1,From2)==null) {
			board.initializeBoard();
			//System.out.println(board.Feld);
			System.out.println("!Move not allowed");
		}
		convertAndMoveCheck(board,  From+To, console);
	}
	
	/**
	 * method to show current state
	 * @param board the board the move is on
	 * @param From1 x axis starting position
	 * @param From2 y axis starting position
	 * @param To1 x axis position to move to
	 * @param To2 y axis position to move to
	 * @param console console input
	 */
	public static void convertAndMoveCheck(Board board, String pos, Console console){
		int From1=Integer.parseInt(Character.toString(pos.charAt(0)));
		int From2=Integer.parseInt(Character.toString(pos.charAt(1)));
		int To1=Integer.parseInt(Character.toString(pos.charAt(2)));
		int To2=Integer.parseInt(Character.toString(pos.charAt(3)));
		if(board.getField(From1, From2)!=null) {
			String ToString = Integer.toString(To1)+Integer.toString(To2);
			if(board.getField(From1, From2).move(board, From1, From2, ToString)) {
				
				System.out.println("!"+console.input.toString());
			}
			// System.out.println(board.movedList);
			
			// promotes pawns, checks if check and prints out board
			StartGame.pawnPromotion(To1,To2,board,console);
			board.initializeBoard();
			Zug.checkCheck(board);
			//System.out.println(board.Feld);
			
			// prints out if someone is in check
			if(board.whiteCheck) {
				System.out.println("White is in check");
			}
			if(board.blackCheck) {
				System.out.println("Black is in check");
			}
			
			// prints out if either checkmate or stalemate
			if(!Zug.checkPossibleMoves(board)) {
				if(Zug.checkCheck(board)) {
					System.out.println("Checkmate");
					return;
				}
				else {
					System.out.println("Stalemate");
					return;
				}
				
			}
			
			if(clock.active) {
			System.out.println("white time left: " + clock.timeWhite + " | black time left: " + clock.timeBlack);
			}
		}
	}
	

}
