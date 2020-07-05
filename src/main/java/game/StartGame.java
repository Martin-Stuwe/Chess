package game;

import schach.Console;
import figures.Queen;
import figures.Rook;
import figures.Knight;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
	 * check if loading a save file is wanted
	 */
	static boolean saveGame = false;
	
	/**
	 * clock of the console game
	 */
	static Time clock = new Time(600,600);
	
	/**
	 * depth of the ai
	 */
	static int depth = 3;
	
	static boolean aiChosen=false;
	public static List<Zug>undoneTurns = new ArrayList<Zug>();
	
	/**
	 * Catches user input and uses convertAndMove to convert and make the move happen
	 * @param board the actual Board object
	 */
	public static void getAndMakeMove(Board board) { //Könnten später Player Objekt übergeben und im PlayerObj Züge Historie speichern
		
			
			// check if draw because of lack of figures
			if(Zug.checkDraw(board)) {
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
			Console.checkUserInput(playerMove, board);

			Console.convertAndMove(board,playerMove);
		
	}
	
	
	
	/**
	 * method to promote the pawn
	 * @param to1 x axis ending position
	 * @param to2 y axis position
	 * @param board board that the pawn gets promoted on
	 * @param console console input
	 */
	public static void pawnPromotion(int to1, int to2, Board board, Console console) {
		if(console.input.length() ==6 && board.getField(to1, to2)!= null &&board.getField(to1, to2).getType()==4 && (to2==0||to2==7) ) {
				pawnPromo2(to1,to2,board,console);
			}
			
		
		
		pawnPromoCheckLast(to1, to2, board);
	}
		
	
		/**
		 * method to check for promote the pawn and second part of pawnPromotion
		 * @param to1 x axis ending position
		 * @param to2 y axis position
		 * @param board board that the pawn gets promoted on
		 * @param console console input
		 */
		private static void pawnPromoCheckLast(int to1, int to2, Board board) {
			
		
		if(board.getField(to1, to2)!= null && board.getField(to1, to2).getType()==4 && (to2==0||to2==7) ) {
			Queen queen = new Queen(to1, to2,board.getField(to1, to2).getColor());
			board.setField(to1, to2, queen);
		}
		
	}
		
	/**
	 * method to replace pawn with wanted figure
	 * @param to1 x axis ending position
	 * @param to2 y axis position
	 * @param board board that the pawn gets promoted on
	 * @param console console input
	 */
	public static void pawnPromo2(int to1, int to2, Board board, Console console) {
		//pawn into queen
		if(console.input.charAt(5) == 'Q' ) {
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
	
		
		
	/**
	 * method for PlayerVsAi gamemode
	 */
	public static void PlayerVsAI(int color) {
		inputAiDepth();
		aiChosen=true;
		GuiCalcs rechner = new GuiCalcs();
		Board board = new Board();
		board.setStart();

		board.initializeBoard();
		if(saveGame) {
			rechner.loadGuiSave(board);
			board.initializeBoard();
			saveGame = false;
		}
		AI ki =new AI(color);
		
		Timer t = new Timer();
		long i = 1000;
		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				clock.updateTime(board);
				if(clock.timeWhite <= 0) {
					System.out.println("white lost on time");
					clock.active = false;
					t.cancel();
				}
				if(clock.timeBlack <= 0) {
					System.out.println("black lost on time");
					clock.active = false;
					t.cancel();
				}
			}
			
		}, i, i);
		
		
		int isStart=1;
		while (true) {
			System.out.println(board.getCurrentTurn());
		
			if(board.getCurrentTurn()==color) {
				if (depth==1&&isStart==1) {
					
					ki.findPossMovesRnd(board, color);
					ki.DoRndMove(board);
				}
				else {
				ki.lookAhead(board,depth,color);
				}
				Zug.checkCheck(board);
				board.initializeBoard();
				isStart=isStart+1;
				if(clock.active) {
				System.out.println("white time left: " + clock.timeWhite + " | black time left: " + clock.timeBlack);
				}
			}
			System.out.println(board.movedList);
			getAndMakeMove(board);
			//board.setCurrentTurn(0);
		}
	}
		
	/**
	* Method for PlayerVsPlayer Mode
	*/
	public static void PlayerVsPlayer() {
		GuiCalcs rechner = new GuiCalcs();
		Board board2 = new Board();
		board2.setStart();
		board2.initializeBoard();
		if(saveGame) {
			rechner.loadGuiSave(board2);
			board2.initializeBoard();
			saveGame = false;
		}
		
		
		Timer t = new Timer();
		long i = 1000;
		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				clock.updateTime(board2);
				if(clock.timeWhite <= 0) {
					System.out.println("white lost on time");
					clock.active = false;
					t.cancel();
				}
				if(clock.timeBlack <= 0) {
					System.out.println("black lost on time");
					clock.active = false;
					t.cancel();
				}
			}
			
		}, i, i);
		
		
		
		while(true) {
		getAndMakeMove(board2);
		}
	}
	
	
	
	/**
	* Method to start the game
	*/
	public static void StartGameCommand() {
		 int i = 0;
	        System.out.print("choose color \n");
	        Console player1color = new Console();
	        player1color.open();
	        while (!player1color.input.equals ("white") && !player1color.input.equals("black")) {
	            System.out.println("You have to enter white or black");
	            player1color.open();
	        }
	        if(player1color.input.equals("white")){
	            i = 1;
	        }
	        else {
	            i = 0;
	        }
	        StartGamePartTwo(i);
	        
	  
	} 
	
	
	/**
	* Method with the further start game algorithm
	*/
	public static void StartGamePartTwo(int i) {
    System.out.println("type 1 for starting a new game and 2 for loading a save game");
    Console save = new Console();
    save.open();
    while (!save.input.equals ("1") && !save.input.equals("2")) {
        System.out.println("You have to enter 1 or 2" );
        save.open();
    }
    if(save.input.equals ("2")) {
    	saveGame = true;
    }
    
    
    timeQuestion();
    
    System.out.println("type 1 for PlayerVsAi and 2 for PlayerVsPlayer");
    Console mode = new Console();
    mode.open();
    while (!mode.input.equals ("1") && !mode.input.equals("2")) {
        System.out.println("You have to enter 1 or 2" );
        mode.open();
    }
    if(mode.input.equals("1")) {
        PlayerVsAI(i);
    }
    else {
        PlayerVsPlayer();
    }
	}
	
	/**
	 * method to make a save in the console
	 * @param board Board the game is on
	 */
	public static void makeSaveConsole(Board board) {
		File file = new File("save.txt");
    	GuiCalcs rechner = new GuiCalcs();
    	
    	try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	ArrayList<String> savegame = new ArrayList<String>();
    	savegame.add(java.time.LocalDate.now().toString());
    	savegame.add("---");
    	for(int i = 0; i < board.movedList.size(); i++ ) {
    		String n =  rechner.numberToString(board.movedList.get(i).from1) + 
    					rechner.numberToNumber(board.movedList.get(i).from2) + "-"  +
    					rechner.numberToString(board.movedList.get(i).to1) +
    					rechner.numberToNumber(board.movedList.get(i).to2);
    		savegame.add(n);
    	}
    	
    	
    	try {
			Files.write(Paths.get("save.txt"), savegame, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("saved");
	}
	
	/**
	 * method to check if time is wanted
	 */
	public static void timeQuestion() {
        System.out.println("type 1 if you want to play with a chess clock, 2 if not");
        Console clockInput = new Console();
        clockInput.open();
        while (!clockInput.input.equals ("1") && !clockInput.input.equals("2")) {
            System.out.println("You have to enter 1 or 2" );
            clockInput.open();
        }
        
        if(clockInput.input.equals("1")) {
        	clock.active = true;
        	System.out.println("first type in the amount of seconds for white");
        	Console white = new Console();
        	white.open();
        	int wh = 0;
        	try {
        		wh = Integer.parseInt(white.input);
        	}
        	catch(NumberFormatException e){
        		e.printStackTrace();
        	}
        	while(wh <= 0){
        		System.out.println("first type in the amount of seconds for white");
        		white.open();
        		try {
	        		wh = Integer.parseInt(white.input);
	        	}
	        	catch(NumberFormatException e){
	        		e.printStackTrace();
	        	}
        	}
        	timeQuestionPartTwo(wh);

        }
	}
	
	/**
	 * second part of method to check if time is wanted
	 */
	public static void timeQuestionPartTwo(int wh) {
	clock.timeWhite = wh;
	
	System.out.println("now type in the amount of seconds for black");
	Console black = new Console();
	black.open();
	int bl = 0;
	try {
		bl = Integer.parseInt(black.input);
	}
	catch(NumberFormatException e){
		e.printStackTrace();
	}
	
	while(bl <= 0){
		System.out.println("now type in the amount of seconds for black");
		black.open();
		try {
    		bl = Integer.parseInt(black.input);
    	}
    	catch(NumberFormatException e){
    		e.printStackTrace();
    	}
	}
	
	clock.timeBlack = bl;
	}
	
	/**
	 * method to ask for specific Ai depth
	 */
	public static void inputAiDepth() {
		System.out.println("type in AI depth (recommended/standard if no or wrong input 3)");
		Console dep = new Console();
		dep.open();
		
		try {
			if(Integer.parseInt(dep.input)> 0) {
				depth = Integer.parseInt(dep.input);
			}
    	}
    	catch(NumberFormatException e){
    		e.printStackTrace();
    	}
	}
	public static void undoMove(Board board) {
		int n =1;
		if(aiChosen) {
			n=2;
		}
		for(int i=0;i<n;i++) {
			
			undoneTurns.add(board.movedList.get(board.movedList.size()-1));
			board.movedList.remove(board.movedList.size()-1);
			if(board.movedList.size()>0) {
			board.setBoard(board.movedList.get(board.movedList.size()-1).getBoardState(),board.movedList.get(board.movedList.size()-1).getTurn());
			}
			else {
				board.setStart();
			}
		}
	}
	
	public static void redoMove(Board board) {
		int n =1;
		if(aiChosen) {
			n=2;
		}
		for(int i=0;i<n;i++) {
			
			board.movedList.add(undoneTurns.get(undoneTurns.size()-1));
			board.setBoard(undoneTurns.get(undoneTurns.size()-1).getBoardState(), undoneTurns.get(undoneTurns.size()-1).getTurn());
			undoneTurns.remove(undoneTurns.size()-1);
		}
	}
}
