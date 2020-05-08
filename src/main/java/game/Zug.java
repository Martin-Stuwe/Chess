package game;

public class Zug {
	Figures figur;
	
	int from1;
	int from2;
	
	int to1;
	int to2;
	
	public Zug(Figures figur, int from1, int from2, int to1, int to2) {
		this.figur = figur;
		this.from1=from1;
		this.from2=from2;
		
		this.to1=to1;
		this.to2=to2;
		
	}
	
	public Figures getFigure() {
		return this.figur;
	}
	
	public int getFrom1() {
		return this.from1;
	}
	
	public int getFrom2() {
		return this.from2;
	}
	
	public int getTo1() {
		return this.to1;
	}
	
	public int getTo2() {
		return this.to2;
	}
	
	
//Hier die Spielzüge mit Position etc und erlaubten Zügen?
}
