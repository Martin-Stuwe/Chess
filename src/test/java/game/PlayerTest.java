package game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
* Class for Player tests
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* group 23
* it1
*/
public class PlayerTest {
	/**
	* Test For color
	*/
	@Test
	public void testColor() {
		Player ptest = new Player("hugo" ,"black" );
		assertEquals("hugo", ptest.getName(), "Name erfolgreich gesetzt");
		assertEquals("black", ptest.getColor(), "Farbe erfolgreich gesetzt");
	}

}
