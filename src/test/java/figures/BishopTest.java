package figures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BishopTest {
	@Test
	public void testPositions() {
		Bishop BW = new Bishop(3,2,"w");
		Bishop BB = new Bishop(1,2,"b");
		assertEquals("B", BW.getBoardVisual(), "Farbe Weiß erkannt");
		assertEquals("b", BB.getBoardVisual(), "Farbe Schwarz erkannt");

	}

}
