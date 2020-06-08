package schach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
/**
* Class for Console tests
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* group 23
* it1
*/
public class ConsoleTest {
	/**
	* Test For Console
	*/
	@Test
	public void testConsole() {
		Console TC = new Console();	
		InputStream in= new ByteArrayInputStream ("Test\r\n".getBytes());
		System.setIn(in);
		TC.open();				
		assertEquals("Test" , TC.input.toString(), "Input Erfolgreich");
		} 
}
