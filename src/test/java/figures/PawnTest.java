package figures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {
	@Test
	public void testPositions() {
		Pawn BW = new Pawn(3,2,"w");
		Pawn BB = new Pawn(1,2,"b");
		assertEquals("P", BW.getBoardVisual(), "Farbe Weiß erkannt");
		assertEquals("p", BB.getBoardVisual(), "Farbe Schwarz erkannt");

	}

}