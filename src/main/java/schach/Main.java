package schach;

import game.StartGame;

/**
 * Main Class
 * @author Martin Stuwe 676421
 * @author Zeyi Sun
 * @author Richard Tank
 * @author Fin Niklas Tiedemann
 * group 23
 * it1
 */
public class Main {
    
	/**
	 * main-method for the game
	 * @param args
	 */
	public static void main(String[] args) {
		  System.out.println("Argument count: " + args.length);
		    for (int i = 0; i < args.length; i++) {
		        System.out.println("Argument " + i + ": " + args[i]);
		    }
		    if(args.length>0 && args[0].intern()=="--no-gui") {
        System.out.println("starting chess match");
        StartGame.StartGameCommand();
		    }
		    else if(args.length>0 && args[0].intern()=="--simple") {
		        System.out.println("starting chess match");
		        StartGame.PlayerVsPlayer();
				    }
		    else {
		    	 
		    	GuiMain.main(args); 
		    }
    }
}