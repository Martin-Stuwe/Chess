package figures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import game.Board;
/**
* Class for Rook tests
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* group 23
* it1
*/
public class RookTest {
	
	/**
	* Test For Boardvisuals
	*/
	@Test
	public void testBoardVisual () {
		Rook RW = new Rook(3,2,"w");
		Rook RB = new Rook(1,2,"b");
		Rook RQ = new Rook(3,2,"q");
		assertEquals("R", RW.getBoardVisual(), "Farbe Weiß erkannt");
		assertEquals("r", RB.getBoardVisual(), "Farbe Schwarz erkannt");
		assertEquals(null, RQ.getBoardVisual(), "Falsche Farbe erkannt");

	}
	/**
	* Test For Positions
	*/
	@Test
	public void testPos () {
		Rook RW = new Rook(3,2,"w");
		RW.setPos(1,2);
		assertEquals(1, RW.pos1, "Pos1 gesetzt und ausgelesen");
		assertEquals(2, RW.pos2, "Pos2 gesetzt und ausgelesen");
	}
	/**
	* Test For Color
	*/
	@Test
	public void testColor () {
		Rook RW = new Rook(3,2,"w");
		assertEquals("w", RW.getColor(), "Farbe ausgelesen");
	
	}
	/**
	* Test For hasMoved
	*/
	@Test
	public void testhasMoved () {
		Rook RW = new Rook(3,2,"w");
		assertFalse( RW.isHasMoved(), "hasMoved ausgelesen");
		RW.setHasMoved(true);
		assertTrue( RW.isHasMoved(), "hasMoved gesetzt");
	}
	/**
	* Test For valid moves 1
	*/
	@Test
	public void testValidMoves1 () {
		Rook RW = new Rook(4,4,"w");
		Board board = new Board();
		board.setStart();
		board.setField(4,4,RW);
		assertFalse( RW.validMove(board, 9, 5), "Number out of Bounds1");
		assertFalse( RW.validMove(board, -1, 5), "Number out of Bounds2");
		assertFalse( RW.validMove(board, 5, 9), "Number out of Bounds3");
		assertFalse( RW.validMove(board, 5, -1), "Number out of Bounds4");
		assertFalse( RW.validMove(board, 4, 4), "Same Space");
		
		
	}
	/**
	* Test For valid moves 2
	*/
	@Test
	public void testValidMoves2 () {
		Rook RW = new Rook(4,4,"w");
		Board board = new Board();
		board.setStart();
		board.setField(4,4,RW);

		assertFalse( RW.validMove(board, 7, 7), "Move not valid");
		assertTrue( RW.validMove(board, 4, 5), "Move1 true");
		assertTrue( RW.validMove(board, 4, 3), "Move2 true");
		assertTrue( RW.validMove(board, 3, 4), "Move3 true");
		assertTrue( RW.validMove(board, 5, 4), "Move4 true");

		
	}
	/**
	* Test For valid moves 3
	*/
	@Test
	public void testValidMoves3 () {
		Rook RW = new Rook(4,4,"w");
		Board board = new Board();
		board.setStart();
		board.setField(4,4,RW);

		assertFalse( RW.validMove(board, 4, 7), "Move1 false");
		assertFalse( RW.validMove(board, 4, 0), "Move2 false");
		board.setField(2, 4, new Pawn(2,4,"w"));
		assertFalse( RW.validMove(board, 0, 4), "Move3 false");
		board.setField(5, 4, new Pawn(5,4,"w"));
		assertFalse( RW.validMove(board, 7, 4), "Move4 false");
		
	}
}
