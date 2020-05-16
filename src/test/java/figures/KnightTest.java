package figures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import game.Figures;
import game.Board;

public class KnightTest {
	
	
	@Test
	public void testBoardVisual () {
		Knight NW = new Knight(3,2,"w");
		Knight NB = new Knight(1,2,"b");
		Knight NQ = new Knight(3,2,"q");
		assertEquals("N", NW.getBoardVisual(), "Farbe Weiß erkannt");
		assertEquals("n", NB.getBoardVisual(), "Farbe Schwarz erkannt");
		assertEquals(null, NQ.getBoardVisual(), "Falsche Farbe erkannt");

	}
	
	@Test
	public void testPos () {
		Knight NW = new Knight(3,2,"w");
		NW.setPos(1,2);
		assertEquals(1, NW.pos1, "Pos1 gesetzt und ausgelesen");
		assertEquals(2, NW.pos2, "Pos2 gesetzt und ausgelesen");
	}
	@Test
	public void testColor () {
		Knight NW = new Knight(3,2,"w");
		assertEquals("w", NW.getColor(), "Farbe ausgelesen");
	
	}
	@Test
	public void testhasMoved () {
		Knight NW = new Knight(3,2,"w");
		assertEquals(false, NW.isHasMoved(), "hasMoved ausgelesen");
		NW.setHasMoved(true);
		assertEquals(true, NW.isHasMoved(), "hasMoved gesetzt");
	}
	@Test
	public void testValidMoves () {
		Knight NW = new Knight(4,4,"w");
		Board board = new Board();
		board.setStart();
		board.setField(4,4,NW);
		assertEquals(false, NW.validMove(board, 9, 5), "Number out of Bounds");
		assertEquals(false, NW.validMove(board, -1, 5), "Number out of Bounds");
		assertEquals(false, NW.validMove(board, 5, 9), "Number out of Bounds");
		assertEquals(false, NW.validMove(board, 5, -1), "Number out of Bounds");
		assertEquals(false, NW.validMove(board, 4, 4), "Same Space");
		assertEquals(false, NW.validMove(board, 7, 7), "Move too long");
		assertEquals(true, NW.validMove(board, 5, 2), "Move1 True");
		assertEquals(true, NW.validMove(board, 5, 6), "Move2 True");
		assertEquals(true, NW.validMove(board, 3, 2), "Move3 True");
		assertEquals(true, NW.validMove(board, 3, 6), "Move4 True");
		assertEquals(true, NW.validMove(board, 6, 3), "Move5 True");
		assertEquals(true, NW.validMove(board, 6, 5), "Move6 True");
		assertEquals(true, NW.validMove(board, 2, 3), "Move7 True");
		assertEquals(true, NW.validMove(board, 2, 5), "Move8 True");
		
	}
}
