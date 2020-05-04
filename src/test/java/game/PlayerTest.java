package game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
	@Test
	public void testColor() {
		Player ptest = new Player("hugo" ,"black" );
		assertEquals("hugo", ptest.getName(), "Name erfolgreich gesetzt");
		assertEquals("black", ptest.getColor(), "Farbe erfolgreich gesetzt");
	}

}
