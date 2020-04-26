package schach;

public class Board {
	
	String Feld; //store for the actual board
	
	String[][] Positionen= new String[8][8]; //Array to store each field later change to figure or field object
		
	public void initializeBoard() { //Method to init the console based board
		
		Feld = "8"+ Positionen[0][0] + Positionen[0][1] + Positionen[0][2] + Positionen[0][3] +Positionen[0][4] + Positionen[0][5] + Positionen[0][6] + Positionen[0][7] + "\n"
				+ "7"+ Positionen[1][0] + Positionen[1][1] + Positionen[1][2] + Positionen[1][3] +Positionen[1][4] + Positionen[1][5] + Positionen[1][6] + Positionen[1][7]+"\n"
				+ "6"+ Positionen[2][0] + Positionen[2][1] + Positionen[2][2] + Positionen[2][3] +Positionen[2][4] + Positionen[2][5] + Positionen[2][6] + Positionen[2][7]+"\n"
				+ "5"+ Positionen[3][0] + Positionen[3][1] + Positionen[3][2] + Positionen[3][3] +Positionen[3][4] + Positionen[3][5] + Positionen[3][6] + Positionen[3][7]+"\n" 
				+ "4"+ Positionen[4][0] + Positionen[4][1] + Positionen[4][2] + Positionen[4][3] +Positionen[4][4] + Positionen[4][5] + Positionen[4][6] + Positionen[4][7] +"\n"
				+ "3"+ Positionen[5][0] + Positionen[5][1] + Positionen[5][2] + Positionen[5][3] +Positionen[5][4] + Positionen[5][5] + Positionen[5][6] + Positionen[5][7] +"\n"
				+ "2"+ Positionen[6][0] + Positionen[6][1] + Positionen[6][2] + Positionen[6][3] +Positionen[6][4] + Positionen[6][5] + Positionen[6][6] + Positionen[6][7] +"\n"
				+ "1"+ Positionen[7][0] + Positionen[7][1] + Positionen[7][2] + Positionen[7][3] +Positionen[7][4] + Positionen[7][5] + Positionen[7][6] + Positionen[7][7] +"\n"
				+ " "+"abcdefgh";
	} 
	
	public void setStart() {
		setField(0,0,"r");
		setField(0,1, "n");
		setField(0,2, "b");
		setField(0,3, "q");
		setField(0,4, "k");
		setField(0,5, "b");
		setField(0,6, "n");
		setField(0,7, "r");
		setField(7,0,"R");
		setField(7,1, "N");
		setField(7,2, "B");
		setField(7,3, "Q");
		setField(7,4, "K");
		setField(7,5, "B");
		setField(7,6, "N");
		setField(7,7, "R");
		for (int i = 0;i<8; i++) {
			setField(1,i,"p");
			setField(2,i,"");
			setField(3,i,"");
			setField(4,i,"");
			setField(5,i,"");
			setField(6,i,"P");
		}
	}
	
	
	public String getField(int pos1, int pos2) {
		return Positionen[pos1][pos2];
	}
	
	
	public void setField(int pos1, int pos2, String setTo) {
		Positionen[pos1][pos2] = setTo;
	}
	
	
	
	
	

}
