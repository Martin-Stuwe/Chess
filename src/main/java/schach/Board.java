package schach;

public class Board {
	
	String Feld; //store for the actual board
	
	String[][] Positionen= new String[8][8]; //Array to store each field later change to figure or field object
		
	public void initializeBoard() { //Method to init the console based board
		Feld = "8xxxxxxxx\n"
				+ "7xxxxxxxx\n"
				+ "6xxxxxxxx\n"
				+ "5xxxxxxxx\n" //Change to empty space between 6 and 2?
				+ "4xxxxxxxx\n"
				+ "3xxxxxxxx\n"
				+ "2xxxxxxxx\n"
				+ "1xxxxxxxx\n"
				+ " "+"abcdefgh";//Change to use the array needed
	} 
	
	
	
	
	

}
