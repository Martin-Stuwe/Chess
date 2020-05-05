package figures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RookTest {
	@Test
	public void testPositions() {
		Rook BW = new Rook(3,2,"w");
		Rook BB = new Rook(1,2,"b");
		assertEquals("R", BW.getBoardVisual(), "Farbe Weiß erkannt");
		assertEquals("r", BB.getBoardVisual(), "Farbe Schwarz erkannt");

	}

}