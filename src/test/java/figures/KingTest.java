package figures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KingTest {
	@Test
	public void testPositions() {
		King BW = new King(3,2,"w");
		King BB = new King(1,2,"b");
		assertEquals("K", BW.getBoardVisual(), "Farbe Weiß erkannt");
		assertEquals("k", BB.getBoardVisual(), "Farbe Schwarz erkannt");

	}

}