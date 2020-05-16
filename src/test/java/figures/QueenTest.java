package figures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import game.Figures;
import game.Board;

public class QueenTest {
	
	
	@Test
	public void testBoardVisual () {
		Queen RW = new Queen(3,2,"w");
		Queen RB = new Queen(1,2,"b");
		Queen RQ = new Queen(3,2,"q");
		assertEquals("Q", RW.getBoardVisual(), "Farbe Weiß erkannt");
		assertEquals("q", RB.getBoardVisual(), "Farbe Schwarz erkannt");
		assertEquals(null, RQ.getBoardVisual(), "Falsche Farbe erkannt");

	}
	
	@Test
	public void testPos () {
		Queen RW = new Queen(3,2,"w");
		RW.setPos(1,2);
		assertEquals(1, RW.pos1, "Pos1 gesetzt und ausgelesen");
		assertEquals(2, RW.pos2, "Pos2 gesetzt und ausgelesen");
	}
	@Test
	public void testColor () {
		Queen RW = new Queen(3,2,"w");
		assertEquals("w", RW.getColor(), "Farbe ausgelesen");
	
	}
	@Test
	public void testhasMoved () {
		Queen RW = new Queen(3,2,"w");
		assertEquals(false, RW.isHasMoved(), "hasMoved ausgelesen");
		RW.setHasMoved(true);
		assertEquals(true, RW.isHasMoved(), "hasMoved gesetzt");
	}
	@Test
	public void testValidRookMoves () {
		Queen RW = new Queen(4,4,"w");
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
	@Test
	public void testValidBishopMoves () {
		Queen BW = new Queen(3,7,"w");
		Board board = new Board();
		board.setStart();
		board.setField(3,7,BW);
		assertEquals(false, BW.validMove(board, 9, 5), "Number out of Bounds");
		assertEquals(false, BW.validMove(board, 7, 7), "Not a valid Move");
		assertEquals(false, BW.validMove(board, 1, 5), "Fields not Empty 1");
		assertEquals(false, BW.validMove(board, 0, 4), "Fields not Empty 1");
		board.setNull(2, 6);
		assertEquals(true, BW.validMove(board, 1, 5), "Fields now Empty 1");
		assertEquals(true, BW.validMove(board, 0, 4), "Fields now Empty 1");
		assertEquals(false, BW.validMove(board, 6, 4), "Fields not Empty 2");
		board.setNull(4, 6);
		assertEquals(true, BW.validMove(board, 6, 4), "Fields now Empty 2");
		
		Bishop BB = new Bishop(3,0,"b");
		board.setField(3,0,BB);
		assertEquals(false, BB.validMove(board, 5, 2), "Fields not Empty 3");	
		board.setNull(4, 1);
		assertEquals(true, BB.validMove(board, 5, 2), "Fields now Empty 3");
		assertEquals(false, BB.validMove(board, 1, 2), "Fields not Empty 4");	
		board.setNull(2, 1);
		assertEquals(true, BB.validMove(board, 1, 2), "Fields now Empty 4");
	}
}
