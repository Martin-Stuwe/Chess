package game;

import schach.Console;
import figures.Queen;
import figures.Rook;
import figures.Knight;
import figures.Bishop;
/**
* Class for the states of the game
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* group 23
* it1
*/
public class StartGame {
	
	/**
	 * Catches user input and uses convertAndMove to convert and make the move happen
	 * @param board the actual Board object
	 */
	public static void getAndMakeMove(Board board) { //Könnten später Player Objekt übergeben und im PlayerObj Züge Historie speichern
		while(true) {
			
			// check if draw because of lack of figures
			if(board.checkDraw()) {
				System.out.println("Draw");
			}
			
			// white move
			if(board.getCurrentTurn()==0) {
				System.out.println("White choose a position with a figure you want to move");
			}
			
			//black move
			else if(board.getCurrentTurn()==1) {
				System.out.println("Black choose a position with a figure you want to move");
			}
			
			Console playerMove = new Console();
			playerMove.open();
			
			// exiting the game
			if (playerMove.input.equals("exit")){
				return;	
			}
			
			// returns all beaten figures
			if (playerMove.input.equals("beaten")){
				board.initializeBoard();
				System.out.println(board.Feld);
				System.out.println(board.beaten);			
				getAndMakeMove(board);
			}
			convertAndMove(board,playerMove);
	
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
		if(console.input.length() <5) {
			board.initializeBoard();
			//System.out.println(board.Feld);
			System.out.println("!Invalid Move");
			return;
		}
		
		// converting the user input into Strings
		String From=board.ConvertMoveInput(board,console.input.charAt(0),Character.getNumericValue(console.input.charAt(1)));
		String To = board.ConvertMoveInput(board,console.input.charAt(3),Character.getNumericValue(console.input.charAt(4)));
		
		// check if user input is valid (- as third character)
		if (From =="420" || To =="420" || console.input.charAt(2)!='-' ){
			board.initializeBoard();
			//System.out.println(board.Feld);
			System.out.println("!Invalid Move");
			return;
		}
	
		// converting Strings into Integers
		int From1=Integer.parseInt(Character.toString(From.charAt(0))); 
		int From2=Integer.parseInt(Character.toString(From.charAt(1))); 
		int To1=Integer.parseInt(Character.toString(To.charAt(0))); 
		int To2=Integer.parseInt(Character.toString(To.charAt(1))); 
		
		
		
		// check if input empty
		if (board.getField(From1,From2)==null) {
			board.initializeBoard();
			//System.out.println(board.Feld);
			System.out.println("!Move not allowed");
		}
		convertAndMoveCheck(board, From1, From2, To1, To2, console);
	}
	
	public static void convertAndMoveCheck(Board board, int From1, int From2, int To1, int To2, Console console){
		if(board.getField(From1, From2)!=null) {
			if(board.getField(From1, From2).move(board, From1, From2, To1, To2)) {
				Zug zug = new Zug(board.getField(To1, To2),From1,From2,To1,To2);  //creates new move and saves in list
				board.movedList.add(zug);
				System.out.println("!"+console.input.toString());
			}
			// System.out.println(board.movedList);
			
			// promotes pawns, checks if check and prints out board
			pawnPromotion(To1,To2,board,console);
			board.initializeBoard();
			board.checkCheck();
			//System.out.println(board.Feld);
			
			// prints out if someone is in check
			if(board.whiteCheck) {
				System.out.println("White is in check");
			}
			if(board.blackCheck) {
				System.out.println("Black is in check");
			}
			
			// prints out if either checkmate or stalemate
			if(!board.checkPossibleMoves()) {
				if(board.checkCheck()) {
					System.out.println("Checkmate");
					return;
				}
				else {
					System.out.println("Stalemate");
					return;
				}
				
			}
		
		}
	}
	
	
	/**
	 * method to promote the pawn
	 * @param from1 x axis starting position (not used)
	 * @param from2 y axis starting position (not used)
	 * @param to1 x axis ending position
	 * @param to2 y axis position
	 * @param board board that the pawn gets promoted on
	 * @param console console input
	 */
	public static void pawnPromotion(int to1, int to2, Board board, Console console) {
		if(console.input.length() ==6 && board.getField(to1, to2)!= null) {
			
			
			if(board.getField(to1, to2).getType()==4 && (to2==0||to2==7) ) {
				pawnPromo2(to1,to2,board,console);
			}
			
			}
		
		}
		
			
			public static void pawnPromo2(int to1, int to2, Board board, Console console) {
				if(to2 == 0 && console.input.charAt(5) == 'Q' ) {
					Queen queen = new Queen(to1, to2,board.getField(to1, to2).getColor());
					board.setField(to1, to2, queen);
				}
				
				// pawn into rook
				if(console.input.charAt(5) == 'R' ) {
					Rook rook = new Rook(to1, to2,board.getField(to1, to2).getColor());
					board.setField(to1, to2, rook);
				}
			
			// pawn into knight
			if(console.input.charAt(5) == 'N') {
				Knight knight = new Knight(to1, to2,board.getField(to1, to2).getColor());
				board.setField(to1, to2, knight);
			}
			
			// pawn into bishop
			if(console.input.charAt(5) == 'B' ) {
				Bishop bishop = new Bishop(to1, to2,board.getField(to1, to2).getColor());
				board.setField(to1, to2, bishop);
			}
			
			// pawn into queen (empty space)
			if( console.input.charAt(5) == ' ') {
				Queen queen = new Queen(to1, to2,board.getField(to1, to2).getColor());
				board.setField(to1, to2, queen);
			}
		}
		
		// check if pawn is on last row

	
		
	/**
	* Method for PlayerVsPlayer Mode
	*/
	public static void PlayerVsPlayer() {
	/*	System.out.println("Enter name of Player1");
		Console player1name = new Console();
		player1name.open();
		System.out.println("Hello "+player1name.input);
		System.out.println("Enter a color for Player 1 : white / black");
		Console player1color = new Console();
		player1color.open();
		while (!player1color.input.equals ("white") && !player1color.input.equals("black")) {
			System.out.println("You have to enter white or black");
			player1color.open();
		}
		System.out.println(player1name.input+" chose "+player1color.input);
		Player Player1 = new Player(player1name.input, player1color.input); 
		System.out.println("Enter name of Player2");
		Console player2name = new Console();
		player2name.open();
		System.out.println("Hello "+player2name.input);
		System.out.println("Enter a color for Player 2 : white / black");
		Console player2color = new Console();
		player2color.open();
		while (!player2color.input.equals ("white") && !player2color.input.equals("black")) {
			System.out.println("You have to enter white or black");
			player2color.open();
		}
		while (player2color.input.equals(player1color.input)) {
			System.out.println(player1name.input+" already chose this color");
			System.out.println("Enter a color for Player 2 : white / black");
			player2color.open();
		}
		System.out.println(player2name.input+" is "+player2color.input);
		Player Player2 = new Player(player2name.input, player2color.input);*/
		//erst später
		Board board2 = new Board();
		board2.setStart();
		board2.initializeBoard();
		
		
		
		getAndMakeMove(board2);
		
	}
	
	/*


	public static void chooseMode() { 
		System.out.println("Choose one of the modes \n 1) Versus Human \n Enter 1 for the PlayerVsPlayer Mode");
		Console ChosenMode = new Console();
		ChosenMode.open();
		switch (ChosenMode.input) {
			case "1":  
				PlayerVsPlayer();
				return; //return needs to be deleted later
				
			default: 
				System.out.println("Wrong input");
				chooseMode();
				return; //return needs to be deleted later
			}
		
	}
	
	*/
	
	/**
	* Method to start the game
	*/
	public static void StartGameCommand() {
		PlayerVsPlayer();
		
	}

}
