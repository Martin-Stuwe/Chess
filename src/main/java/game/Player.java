package game;

/**
 * Class for the Chess Players
 * @author Martin Stuwe 676421
 * @author Zeyi Sun
 * @author Richard Tank
 * @author Fin Niklas Tiedemann
 * group 23
 */
public class Player {
	
	/**
	 * name of the player
	 */
	String name;
	
	/**
	 * color of the player
	 */
	String color;
	
	/**
	 * constructor for the player
	 * @param name name of the player as a String
	 * @param color color of the player as a String
	 */
	public Player(String name, String color) { 
		this.name= name;
		this.color=color;
	}
	
	/**
	 * get-method of the color
	 * @return color 
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * get-method of the name
	 * @return name
	 */
	public String getName() {
		return name;
	}
}
