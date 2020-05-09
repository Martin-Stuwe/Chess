/**
* Class for reading Console input
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* Gruppe 23
*/


package schach;
import java.util.Scanner;


public class Console {
	

	
	public String input;
		
		public void open() {
		    Scanner userInput = new Scanner(System.in);
		      this.input = userInput.nextLine();
		}
		

}
