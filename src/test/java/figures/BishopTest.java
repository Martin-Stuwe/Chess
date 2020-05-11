package figures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import game.Figures;
import game.Board;

public class BishopTest {
	
	
	@Test
	public void testBoardVisual () {
		Bishop BW = new Bishop(3,2,"w");
		Bishop BB = new Bishop(1,2,"b");
		Bishop BQ = new Bishop(3,2,"q");
		assertEquals("B", BW.getBoardVisual(), "Farbe Weiß erkannt");
		assertEquals("b", BB.getBoardVisual(), "Farbe Schwarz erkannt");
		assertEquals(null, BQ.getBoardVisual(), "Falsche Farbe erkannt");

	}
	
	@Test
	public void testPos () {
		Bishop BW = new Bishop(3,2,"w");
		BW.setPos(1,2);
		assertEquals(1, BW.pos1, "Pos1 gesetzt und ausgelesen");
		assertEquals(2, BW.pos2, "Pos2 gesetzt und ausgelesen");
	}
	@Test
	public void testColor () {
		Bishop BW = new Bishop(3,2,"w");
		assertEquals("w", BW.getColor(), "Farbe ausgelesen");
	
	}
	@Test
	public void testValidMoves () {
		Bishop BW = new Bishop(3,7,"w");
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
