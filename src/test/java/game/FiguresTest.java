package game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FiguresTest {
	@Test
	public void testPositions() {
		Figures ftest = new Figures();
		ftest.setPos(1, 2);
		assertEquals(1, ftest.getPos1(), "Pos 1 erfolgreich gesetzt");
		assertEquals(2, ftest.getPos2(), "Pos 2 erfolgreich gesetzt");
	}

}
