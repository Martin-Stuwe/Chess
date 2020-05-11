package schach;

import java.util.Scanner;

/**
 * Class for reading Console input
 * @author Martin Stuwe 676421
 * @author Zeyi Sun
 * @author Richard Tank
 * @author Fin Niklas Tiedemann
 * group 23
 * it1
 */
public class Console {
	
	/**
	 * the input as a String
	 */
	public String input;
	
	/**
	 * method to open the console
	 */
	public void open() {
		Scanner userInput = new Scanner(System.in);
		this.input = userInput.nextLine();
	}
		

}
