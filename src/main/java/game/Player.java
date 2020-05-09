/**
* Class for the Chess Players
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* Gruppe 23
*/


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
