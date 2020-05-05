package figures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueenTest {
	@Test
	public void testPositions() {
		Queen BW = new Queen(3,2,"w");
		Queen BB = new Queen(1,2,"b");
		assertEquals("Q", BW.getBoardVisual(), "Farbe Weiß erkannt");
		assertEquals("q", BB.getBoardVisual(), "Farbe Schwarz erkannt");

	}

}