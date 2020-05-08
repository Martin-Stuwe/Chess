package game;

import schach.Console;

public class StartGame {
	
	
	public static void getAndMakeMove(Board board) { //Könnten später Player Objekt übergeben und im PlayerObj Züge Historie speichern
		while(true) {
		
			if(board.getCurrentTurn()==0) {
		System.out.println("White choose a position with a figure you want to move");
			}
			else if(board.getCurrentTurn()==1) {
				System.out.println("Black choose a position with a figure you want to move");
					}
		Console playerMove = new Console();
		playerMove.open();
		if (playerMove.input.equals("exit")==true){
			return;	
		}
		convertAndMove(board,playerMove);
	
	}
}
	public static void convertAndMove(Board board, Console console) {
		String From=board.ConvertMoveInput(board, console.input.charAt(0),Character.getNumericValue(console.input.charAt(1)));
		String To = board.ConvertMoveInput(board,console.input.charAt(3),Character.getNumericValue(console.input.charAt(4)));
		
		if (From =="420" || To =="420" || From.length()==2. || console.input.charAt(2)=='-'){
			board.initializeBoard();
			System.out.println(board.Feld);
			System.out.println("!invalid Move");
			return;
		}
	
		
		int From1=Integer.parseInt(Character.toString(From.charAt(0))); 
		int From2=Integer.parseInt(Character.toString(From.charAt(1))); 
		int To1=Integer.parseInt(Character.toString(To.charAt(0))); 
		int To2=Integer.parseInt(Character.toString(To.charAt(1))); 
		
		if (board.getField(From1, From2)!=null) {
		board.getField(From1, From2).move(board, From1, From2, To1, To2);
		board.initializeBoard();
		System.out.println(board.Feld);
		}
		
		else if (board.getField(From1,From2)==null) {
			board.initializeBoard();
			System.out.println(board.Feld);
			System.out.println("!invalid Move");
		}
	}
		
	//PlayerVsPlayer Mode. Further Modes have to be placed above the chooseMode
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
		System.out.println(board2.Feld);
		
		
		/*System.out.println("White choose a position with a figure to move");
		
		Console player1FirstMove = new Console();
		player1FirstMove.open();
		
		//Convert+Move part
		String From=board2.ConvertMoveInput(board2, player1FirstMove.input.charAt(0),Character.getNumericValue(player1FirstMove.input.charAt(1)));
		String To = board2.ConvertMoveInput(board2, player1FirstMove.input.charAt(3),Character.getNumericValue(player1FirstMove.input.charAt(4)));

		int From1=Integer.parseInt(Character.toString(From.charAt(0))); 
		int From2=Integer.parseInt(Character.toString(From.charAt(1))); 
		int To1=Integer.parseInt(Character.toString(To.charAt(0))); 
		int To2=Integer.parseInt(Character.toString(To.charAt(1))); 
		
		board2.getField(From1, From2).move(board2, From1, From2, To1, To2);
		board2.initializeBoard();
		System.out.println(board2.Feld);
		*/
		
		getAndMakeMove(board2);
		
	}
	//choose Mode cases for different modes
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
	public static void StartGameCommand() {
		PlayerVsPlayer();
		return;
}

}
