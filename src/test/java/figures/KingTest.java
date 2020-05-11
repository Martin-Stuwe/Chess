package figures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import game.Figures;
import game.Board;

public class KingTest {
	
	
	@Test
	public void testBoardVisual () {
		King KW = new King(3,2,"w");
		King KB = new King(1,2,"b");
		King BQ = new King(3,2,"q");
		assertEquals("K", KW.getBoardVisual(), "Farbe Weiß erkannt");
		assertEquals("k", KB.getBoardVisual(), "Farbe Schwarz erkannt");
		assertEquals(null, BQ.getBoardVisual(), "Falsche Farbe erkannt");

	}
	
	@Test
	public void testPos () {
		King KW = new King(3,2,"w");
		KW.setPos(1,2);
		assertEquals(1, KW.pos1, "Pos1 gesetzt und ausgelesen");
		assertEquals(2, KW.pos2, "Pos2 gesetzt und ausgelesen");
	}
	@Test
	public void testColor () {
		King KW = new King(3,2,"w");
		assertEquals("w", KW.getColor(), "Farbe ausgelesen");
	
	}
	@Test
	public void testhasMoved () {
		King KW = new King(3,2,"w");
		assertEquals(false, KW.getHasMoved(), "hasMoved ausgelesen");
		KW.setHasMoved(true);
		assertEquals(true, KW.getHasMoved(), "hasMoved gesetzt");
	}
	@Test
	public void testValidMoves () {
		King KW = new King(4,4,"w");
		Board board = new Board();
		board.setStart();
		board.setField(4,4,KW);
		assertEquals(false, KW.validMove(board, 9, 5), "Number out of Bounds");
		assertEquals(false, KW.validMove(board, -1, 5), "Number out of Bounds");
		assertEquals(false, KW.validMove(board, 5, 9), "Number out of Bounds");
		assertEquals(false, KW.validMove(board, 5, -1), "Number out of Bounds");
		assertEquals(false, KW.validMove(board, 4, 4), "Same Space");
		assertEquals(false, KW.validMove(board, 7, 7), "Move too long");
		assertEquals(true, KW.validMove(board, 4, 3), "Move1 True");
		assertEquals(true, KW.validMove(board, 4, 5), "Move2 True");
		assertEquals(true, KW.validMove(board, 5, 3), "Move3 True");
		assertEquals(true, KW.validMove(board, 5, 4), "Move4 True");
		assertEquals(true, KW.validMove(board, 5, 5), "Move5 True");
		assertEquals(true, KW.validMove(board, 3, 3), "Move6 True");
		assertEquals(true, KW.validMove(board, 3, 4), "Move7 True");
		assertEquals(true, KW.validMove(board, 3, 5), "Move8 True");
		board.setNull(4, 4);
		board.setField(4, 7, KW);
		assertEquals(false, KW.validMove(board, 6, 7), "RochadeS false");
		assertEquals(false, KW.validMove(board, 2, 7), "RochadeL false");
		board.setNull(5, 7);
		board.setNull(6, 7);
		assertEquals(true, KW.validMove(board, 6, 7), "RochadeS true");
		board.setNull(1, 7);
		board.setNull(2, 7);
		board.setNull(3, 7);
		assertEquals(true, KW.validMove(board, 2, 7), "RochadeL true");
		KW.setHasMoved(true);
		assertEquals(false, KW.validMove(board, 6, 7), "RochadeS Moved");
		assertEquals(false, KW.validMove(board, 2, 7), "RochadeL moved");
	}
}
