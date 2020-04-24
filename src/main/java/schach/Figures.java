package schach;

public class Figures {
	String Pos1;
	int Pos2;
	String boardVisual; //Zeichen/Grafik hier?
	
	
	
	public void setPos(String Pos1, int Pos2) {
		this.Pos1 = Pos1;
		this.Pos2 = Pos2;
	}
	public String getPos1() {
		return Pos1; 
	}
	public int getPos2() {
		return Pos2; 
	}
}
