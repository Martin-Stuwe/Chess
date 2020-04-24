package schach;


public class StartGame {
		
	//PlayerVsPlayer Mode. Further Modes have to be placed above the chooseMode
	public static void PlayerVsPlayer() {
		System.out.println("Enter name of Player1");
		Console player1name = new Console();
		player1name.open();
		System.out.println("Enter a color for Player 1 : white / black");
		Console player1color = new Console();
		player1color.open();
		Player Player1 = new Player(player1name.input, player1color.input);
		System.out.println("Enter name of Player2");
		Console player2name = new Console();
		player2name.open();
		System.out.println("Enter a color for Player 2 : white / black");
		Console player2color = new Console();
		player2color.open();
		Player Player2 = new Player(player2name.input, player2color.input);
		Board board = new Board();
		board.initializeBoard();
		board.setStart();
		System.out.println(board.Feld);
	}
	
	//choose Mode cases for different modes
	public static void chooseMode() { 
		System.out.println("Choose one of the modes /n 1) Versus Human /n Enter 1 for the PlayerVsPlayer Mode");
		Console ChosenMode = new Console();
		ChosenMode.open();
		switch (ChosenMode.input) {
			case "1":  
				PlayerVsPlayer();
				return;
				
			default: 
				System.out.println("Wrong input");
				chooseMode();
				return;
			}
		
	}
	public static void StartGameCommand() {
		chooseMode();
		return;
}
}
