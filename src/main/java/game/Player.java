package game;

public class Player {
	
	String name;
	String color;
	
	//Constructor for Players
	public Player(String name, String color) { 
		this.name= name;
		this.color=color;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getName() {
		return name;
	}
}
