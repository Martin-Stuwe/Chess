package figures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import game.Figures;
import game.Board;

public class RookTest {
	
	
	@Test
	public void testBoardVisual () {
		Rook RW = new Rook(3,2,"w");
		Rook RB = new Rook(1,2,"b");
		Rook RQ = new Rook(3,2,"q");
		assertEquals("R", RW.getBoardVisual(), "Farbe Weiß erkannt");
		assertEquals("r", RB.getBoardVisual(), "Farbe Schwarz erkannt");
		assertEquals(null, RQ.getBoardVisual(), "Falsche Farbe erkannt");

	}
	
	@Test
	public void testPos () {
		Rook RW = new Rook(3,2,"w");
		RW.setPos(1,2);
		assertEquals(1, RW.pos1, "Pos1 gesetzt und ausgelesen");
		assertEquals(2, RW.pos2, "Pos2 gesetzt und ausgelesen");
	}
	@Test
	public void testColor () {
		Rook RW = new Rook(3,2,"w");
		assertEquals("w", RW.getColor(), "Farbe ausgelesen");
	
	}
	@Test
	public void testhasMoved () {
		Rook RW = new Rook(3,2,"w");
		assertEquals(false, RW.getHasMoved(), "hasMoved ausgelesen");
		RW.setHasMoved(true);
		assertEquals(true, RW.getHasMoved(), "hasMoved gesetzt");
	}
	@Test
	public void testValidMoves () {
		Rook RW = new Rook(4,4,"w");
		Board board = new Board();
		board.setStart();
		board.setField(4,4,RW);
		assertEquals(false, RW.validMove(board, 9, 5), "Number out of Bounds");
		assertEquals(false, RW.validMove(board, -1, 5), "Number out of Bounds");
		assertEquals(false, RW.validMove(board, 5, 9), "Number out of Bounds");
		assertEquals(false, RW.validMove(board, 5, -1), "Number out of Bounds");
		assertEquals(false, RW.validMove(board, 4, 4), "Same Space");
		assertEquals(false, RW.validMove(board, 7, 7), "Move not valid");
		assertEquals(true, RW.validMove(board, 4, 5), "Move1 true");
		assertEquals(true, RW.validMove(board, 4, 3), "Move2 true");
		assertEquals(true, RW.validMove(board, 3, 4), "Move3 true");
		assertEquals(true, RW.validMove(board, 5, 4), "Move4 true");
		assertEquals(false, RW.validMove(board, 4, 7), "Move1 false");
		assertEquals(false, RW.validMove(board, 4, 0), "Move2 false");
		board.setField(2, 4, new Pawn(2,4,"w"));
		assertEquals(false, RW.validMove(board, 0, 4), "Move3 false");
		board.setField(5, 4, new Pawn(5,4,"w"));
		assertEquals(false, RW.validMove(board, 7, 4), "Move4 false");
		
	}
}
