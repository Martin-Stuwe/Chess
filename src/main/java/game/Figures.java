package game;

public class Figures {
	int Pos1; 
	int Pos2;
	String boardVisual; //Zeichen/Grafik hier
	
	
	
	public void setPos(int Pos1, int Pos2) { 
		this.Pos1 = Pos1;
		this.Pos2 = Pos2;
	}
	public int getPos1() {
		return Pos1; 
	}
	public int getPos2() {
		return Pos2; 
	}
}
