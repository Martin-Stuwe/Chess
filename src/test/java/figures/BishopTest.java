package figures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import game.Board;
/**
* Class for Bishop tests
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* group 23
* it1
*/
public class BishopTest {
	/**
	* Test For Boardvisuals
	*/	
	@Test
	public void testBoardVisual () {
		Bishop BW = new Bishop(3,2,"w");
		Bishop BB = new Bishop(1,2,"b");
		Bishop BQ = new Bishop(3,2,"q");
		assertEquals("B", BW.getBoardVisual(), "Farbe Weiß erkannt");
		assertEquals("b", BB.getBoardVisual(), "Farbe Schwarz erkannt");
		assertEquals(null, BQ.getBoardVisual(), "Falsche Farbe erkannt");

	}
	/**
	* Test For Positions
	*/
	@Test
	public void testPos () {
		Bishop BW = new Bishop(3,2,"w");
		BW.setPos(1,2);
		assertEquals(1, BW.pos1, "Pos1 gesetzt und ausgelesen");
		assertEquals(2, BW.pos2, "Pos2 gesetzt und ausgelesen");
	}
	/**
	* Test For Color
	*/
	@Test
	public void testColor () {
		Bishop BW = new Bishop(3,2,"w");
		assertEquals("w", BW.getColor(), "Farbe ausgelesen");
	
	}
	/**
	* Test For valid moves 1
	*/
	@Test
	public void testValidMoves1 () {
		Bishop BW = new Bishop(3,7,"w");
		Board board = new Board();
		board.setStart();
		board.setField(3,7,BW);
		assertFalse(BW.validMove(board, 9, 5), "Number out of Bounds");
		assertFalse( BW.validMove(board, 7, 7), "Not a valid Move");
		assertFalse( BW.validMove(board, 1, 5), "Fields not Empty 1");
		assertFalse(BW.validMove(board, 0, 4), "Fields not Empty 1");
	
	}
	/**
	* Test For valid moves 2
	*/
	@Test
	public void testValidMoves2 () {
		Bishop BW = new Bishop(3,7,"w");
		Board board = new Board();
		board.setStart();
		board.setNull(2, 6);
		assertTrue( BW.validMove(board, 1, 5), "Fields now Empty 1");
		assertTrue( BW.validMove(board, 0, 4), "Fields now Empty 1");
		assertFalse( BW.validMove(board, 6, 4), "Fields not Empty 2");
		board.setNull(4, 6);
		assertTrue( BW.validMove(board, 6, 4), "Fields now Empty 2");

	}
	/**
	* Test For valid moves 3
	*/
	@Test
	public void testValidMoves3 () {
		Bishop BW = new Bishop(3,7,"w");
		Board board = new Board();
		board.setStart();
		
		Bishop BB = new Bishop(3,0,"b");
		board.setField(3,0,BB);
		assertFalse(BB.validMove(board, 5, 2), "Fields not Empty 3");	
		board.setNull(4, 1);
		assertTrue( BB.validMove(board, 5, 2), "Fields now Empty 3");
		assertFalse(BB.validMove(board, 1, 2), "Fields not Empty 4");	
		board.setNull(2, 1);
		assertTrue( BB.validMove(board, 1, 2), "Fields now Empty 4");
	}
}
