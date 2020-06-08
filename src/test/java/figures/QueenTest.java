package figures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import game.Board;
/**
* Class for Queen tests
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* group 23
* it1
*/
public class QueenTest {
	
	/**
	* Test For Boardvisuals
	*/
	@Test
	public void testBoardVisual () {
		Queen QW = new Queen(3,2,"w");
		Queen RB = new Queen(1,2,"b");
		Queen RQ = new Queen(3,2,"q");
		assertEquals("Q", QW.getBoardVisual(), "Farbe Weiß erkannt");
		assertEquals("q", RB.getBoardVisual(), "Farbe Schwarz erkannt");
		assertEquals(null, RQ.getBoardVisual(), "Falsche Farbe erkannt");

	}
	/**
	* Test For Positions
	*/
	@Test
	public void testPos () {
		Queen QW = new Queen(3,2,"w");
		QW.setPos(1,2);
		assertEquals(1, QW.pos1, "Pos1 gesetzt und ausgelesen");
		assertEquals(2, QW.pos2, "Pos2 gesetzt und ausgelesen");
	}
	/**
	* Test For Color
	*/
	@Test
	public void testColor () {
		Queen QW = new Queen(3,2,"w");
		assertEquals("w", QW.getColor(), "Farbe ausgelesen");
	
	}
	/**
	* Test For hasMoved
	*/
	@Test
	public void testhasMoved () {
		Queen QW = new Queen(3,2,"w");
		assertFalse( QW.isHasMoved(), "hasMoved ausgelesen");
		QW.setHasMoved(true);
		assertTrue( QW.isHasMoved(), "hasMoved gesetzt");
	}
	/**
	* Test For valid moves 1
	*/
	@Test
	public void testValidRookMoves1 () {
		Queen QW = new Queen(4,4,"w");
		Board board = new Board();
		board.setStart();
		board.setField(4,4,QW);
		assertFalse( QW.validMove(board, 9, 5), "Number out of Bounds1");
		assertFalse( QW.validMove(board, -1, 5), "Number out of Bounds2");
		assertFalse( QW.validMove(board, 5, 9), "Number out of Bounds3");
		assertFalse( QW.validMove(board, 5, -1), "Number out of Bounds4");
		assertFalse( QW.validMove(board, 4, 4), "Same Space");
		
		
	}
	/**
	* Test For valid moves 2
	*/
	@Test
	public void testValidRookMoves2 () {
		Queen QW = new Queen(4,4,"w");
		Board board = new Board();
		board.setStart();
		board.setField(4,4,QW);
		assertFalse( QW.validMove(board, 7, 7), "Move not valid");
		assertTrue( QW.validMove(board, 4, 5), "Move1 true");
		assertTrue( QW.validMove(board, 4, 3), "Move2 true");
		assertTrue( QW.validMove(board, 3, 4), "Move3 true");
		assertTrue( QW.validMove(board, 5, 4), "Move4 true");

		
	}
	/**
	* Test For valid moves 3
	*/
	@Test
	public void testValidRookMoves3 () {
		Queen QW = new Queen(4,4,"w");
		Board board = new Board();
		board.setStart();
		board.setField(4,4,QW);

		assertFalse( QW.validMove(board, 4, 7), "Move1 false");
		assertFalse( QW.validMove(board, 4, 0), "Move2 false");
		board.setField(2, 4, new Pawn(2,4,"w"));
		assertFalse( QW.validMove(board, 0, 4), "Move3 false");
		board.setField(5, 4, new Pawn(5,4,"w"));
		assertFalse( QW.validMove(board, 7, 4), "Move4 false");
		
	}
	/**
	* Test For valid moves 4
	*/
	@Test
	public void testValidBishopMoves1 () {
		Queen QW = new Queen(3,7,"w");
		Board board = new Board();
		board.setStart();
		board.setField(3,7,QW);
		assertFalse( QW.validMove(board, 9, 5), "Number out of Bounds");
		assertFalse( QW.validMove(board, 1, 5), "Fields not Empty 1");
		assertFalse( QW.validMove(board, 0, 4), "Fields not Empty 1");
		board.setNull(2, 6);
		assertTrue( QW.validMove(board, 1, 5), "Fields now Empty 1");
		assertTrue( QW.validMove(board, 0, 4), "Fields now Empty 1");

	}
	/**
	* Test For valid moves 5
	*/
	@Test
	public void testValidBishopMoves2 () {
		Queen QW = new Queen(3,7,"w");
		Board board = new Board();
		board.setStart();
		board.setField(3,7,QW);
		assertFalse( QW.validMove(board, 7, 7), "Not a valid Move");

		assertFalse( QW.validMove(board, 6, 4), "Fields not Empty 2");
		board.setNull(4, 6);
		assertTrue( QW.validMove(board, 6, 4), "Fields now Empty 2");
		
		
	}
	/**
	* Test For valid moves 6
	*/
	@Test
	public void testValidBishopMoves3 () {
		Queen QW = new Queen(3,7,"w");
		Board board = new Board();
		board.setStart();
		board.setField(3,7,QW);
		Queen QB = new Queen(3,0,"b");
		board.setField(3,0,QB);
		assertFalse( QB.validMove(board, 5, 2), "Fields not Empty 3");	
		board.setNull(4, 1);
		assertTrue( QB.validMove(board, 5, 2), "Fields now Empty 3");
		assertFalse( QB.validMove(board, 1, 2), "Fields not Empty 4");	
		board.setNull(2, 1);
		assertTrue( QB.validMove(board, 1, 2), "Fields now Empty 4");
		
		
	}
}
