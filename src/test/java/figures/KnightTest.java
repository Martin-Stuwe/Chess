package figures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {
	@Test
	public void testPositions() {
		Knight BW = new Knight(3,2,"w");
		Knight BB = new Knight(1,2,"b");
		assertEquals("N", BW.getBoardVisual(), "Farbe Weiß erkannt");
		assertEquals("n", BB.getBoardVisual(), "Farbe Schwarz erkannt");

	}

}