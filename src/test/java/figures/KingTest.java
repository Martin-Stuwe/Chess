package figures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import game.Board;
/**
* Class for King tests
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* group 23
* it1
*/
public class KingTest {
	
	/**
	* Test For Boardvisuals
	*/
	@Test
	public void testBoardVisual () {
		King KW = new King(3,2,"w");
		King KB = new King(1,2,"b");
		King BQ = new King(3,2,"q");
		assertEquals("K", KW.getBoardVisual(), "Farbe Weiß erkannt");
		assertEquals("k", KB.getBoardVisual(), "Farbe Schwarz erkannt");
		assertEquals(null, BQ.getBoardVisual(), "Falsche Farbe erkannt");

	}
	/**
	* Test For Positions
	*/
	@Test
	public void testPos () {
		King KW = new King(3,2,"w");
		KW.setPos(1,2);
		assertEquals(1, KW.pos1, "Pos1 gesetzt und ausgelesen");
		assertEquals(2, KW.pos2, "Pos2 gesetzt und ausgelesen");
	}
	/**
	* Test For Color
	*/
	@Test
	public void testColor () {
		King KW = new King(3,2,"w");
		assertEquals("w", KW.getColor(), "Farbe ausgelesen");
	
	}
	/**
	* Test For hasMoved
	*/
	@Test
	public void testhasMoved () {
		King KW = new King(3,2,"w");
		assertFalse(KW.isHasMoved(), "hasMoved ausgelesen");
		KW.setHasMoved(true);
		assertTrue(KW.isHasMoved(), "hasMoved gesetzt");
	}
	/**
	* Test For valid moves 1
	*/
	@Test
	public void testValidMoves1 () {
		King KW = new King(4,4,"w");
		Board board = new Board();
		board.setStart();
		board.setField(4,4,KW);
		assertFalse( KW.validMove(board, 9, 5), "Number out of Bounds1");
		assertFalse( KW.validMove(board, -1, 5), "Number out of Bounds2");
		assertFalse( KW.validMove(board, 5, 9), "Number out of Bounds3");
		assertFalse( KW.validMove(board, 5, -1), "Number out of Bounds4");
		assertFalse(KW.validMove(board, 4, 4), "Same Space");

	}
	/**
	* Test For valid moves 2
	*/
	@Test
	public void testValidMoves2 () {
		King KW = new King(4,4,"w");
		Board board = new Board();
		board.setStart();
		board.setField(4,4,KW);

		assertFalse(KW.validMove(board, 7, 7), "Move too long");
		assertTrue( KW.validMove(board, 4, 3), "Move1 True");
		board.setNull(4, 4);
		board.setField(4, 7, KW);
		assertFalse(KW.validMove(board, 6, 7), "RochadeS false");
		assertFalse(KW.validMove(board, 2, 7), "RochadeL false");
		board.setNull(5, 7);
		board.setNull(6, 7);
		assertTrue( KW.validMove(board, 6, 7), "RochadeS true");
	
	}
	/**
	* Test For valid moves 3
	*/
	@Test
	public void testValidMoves3 () {
		King KW = new King(4,4,"w");
		Board board = new Board();
		board.setStart();
		board.setField(4,4,KW);

		board.setField(4, 7, KW);
		board.setNull(1, 7);
		board.setNull(2, 7);
		board.setNull(3, 7);
		assertTrue( KW.validMove(board, 2, 7), "RochadeL true");
		KW.setHasMoved(true);
		assertFalse( KW.validMove(board, 6, 7), "RochadeS Moved");
		assertFalse( KW.validMove(board, 2, 7), "RochadeL moved");
	}
}
