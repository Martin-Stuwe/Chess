package figures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import game.Board;
/**
* Class for Knight tests
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* group 23
* it1
*/
public class KnightTest {
	
	/**
	* Test For Boardvisuals
	*/
	@Test
	public void testBoardVisual () {
		Knight NW = new Knight(3,2,"w");
		Knight NB = new Knight(1,2,"b");
		Knight NQ = new Knight(3,2,"q");
		assertEquals("N", NW.getBoardVisual(), "Farbe Weiß erkannt");
		assertEquals("n", NB.getBoardVisual(), "Farbe Schwarz erkannt");
		assertEquals(null, NQ.getBoardVisual(), "Falsche Farbe erkannt");

	}
	/**
	* Test For Positions
	*/
	@Test
	public void testPos () {
		Knight NW = new Knight(3,2,"w");
		NW.setPos(1,2);
		assertEquals(1, NW.pos1, "Pos1 gesetzt und ausgelesen");
		assertEquals(2, NW.pos2, "Pos2 gesetzt und ausgelesen");
	}
	/**
	* Test For Color
	*/
	@Test
	public void testColor () {
		Knight NW = new Knight(3,2,"w");
		assertEquals("w", NW.getColor(), "Farbe ausgelesen");
	
	}
	/**
	* Test For hasMoved
	*/
	@Test
	public void testhasMoved () {
		Knight NW = new Knight(3,2,"w");
		assertFalse( NW.isHasMoved(), "hasMoved ausgelesen");
		NW.setHasMoved(true);
		assertTrue( NW.isHasMoved(), "hasMoved gesetzt");
	}
	@Test
	/**
	* Test For valid moves 1
	*/
	public void testValidMoves1 () {
		Knight NW = new Knight(4,4,"w");
		Board board = new Board();
		board.setStart();
		board.setField(4,4,NW);
		assertFalse( NW.validMove(board, 9, 5), "Number out of Bounds1");
		assertFalse( NW.validMove(board, -1, 5), "Number out of Bounds2");
		assertFalse( NW.validMove(board, 5, 9), "Number out of Bound3");
		assertFalse( NW.validMove(board, 5, -1), "Number out of Bound4");
		assertFalse( NW.validMove(board, 4, 4), "Same Space");

		
	}
	/**
	* Test For valid moves 2
	*/
	@Test
	public void testValidMoves2 () {
		Knight NW = new Knight(4,4,"w");
		Board board = new Board();
		board.setStart();
		board.setField(4,4,NW);
		assertFalse( NW.validMove(board, 7, 7), "Move too long");
		assertTrue( NW.validMove(board, 5, 2), "Move1 True");
		assertTrue( NW.validMove(board, 5, 6), "Move2 True");
		assertTrue( NW.validMove(board, 3, 2), "Move3 True");
		assertTrue( NW.validMove(board, 3, 6), "Move4 True");
		
		
	}
	/**
	* Test For valid moves 3
	*/
	@Test
	public void testValidMoves3 () {
		Knight NW = new Knight(4,4,"w");
		Board board = new Board();
		board.setStart();
		board.setField(4,4,NW);

		assertTrue( NW.validMove(board, 6, 3), "Move5 True");
		assertTrue( NW.validMove(board, 6, 5), "Move6 True");
		assertTrue( NW.validMove(board, 2, 3), "Move7 True");
		assertTrue( NW.validMove(board, 2, 5), "Move8 True");
		
	}
}
