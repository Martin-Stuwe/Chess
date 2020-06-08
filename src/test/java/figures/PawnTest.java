package figures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import game.Zug;
import game.Board;
/**
* Class for Pawn tests
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* group 23
* it1
*/
public class PawnTest {
	
	/**
	* Test For Boardvisuals
	*/
	@Test
	public void testBoardVisual () {
		Pawn PW = new Pawn(3,2,"w");
		Pawn PB = new Pawn(1,2,"b");
		Pawn PQ = new Pawn(3,2,"q");
		assertEquals("P", PW.getBoardVisual(), "Farbe Weiß erkannt");
		assertEquals("p", PB.getBoardVisual(), "Farbe Schwarz erkannt");
		assertEquals(null, PQ.getBoardVisual(), "Falsche Farbe erkannt");

	}
	/**
	* Test For Positions
	*/
	@Test
	public void testPos () {
		Pawn PW = new Pawn(3,2,"w");
		PW.setPos(1,2);
		assertEquals(1, PW.pos1, "Pos1 gesetzt und ausgelesen");
		assertEquals(2, PW.pos2, "Pos2 gesetzt und ausgelesen");
	}
	/**
	* Test For Color
	*/
	@Test
	public void testColor () {
		Pawn PW = new Pawn(3,2,"w");
		assertEquals("w", PW.getColor(), "Farbe ausgelesen");
	
	}
	/**
	* Test For Type
	*/
	@Test
	public void testType () {
		Pawn PW = new Pawn(3,2,"w");
		assertEquals(4, PW.getType(), "Type ausgelesen");
	
	}
	/**
	* Test For hasMoved
	*/
	@Test
	public void testhasMoved () {
		Pawn PW = new Pawn(3,2,"w");
		assertFalse( PW.isHasMoved(), "hasMoved ausgelesen");
		PW.setHasMoved(true);
		assertTrue( PW.isHasMoved(), "hasMoved gesetzt");
	}
	/**
	* Test For valid moves 1
	*/
	@Test
	public void testValidMoves1 () {
		Pawn PW = new Pawn(1,6,"w");
		Pawn PB = new Pawn(2,1,"b");
		Board board = new Board();
		board.setStart();
		board.setField(1,6,PW);
		board.setField(2,1,PB);
		assertFalse( PW.validMove(board, 9, 5), "Number out of Bounds");
		assertFalse( PW.validMove(board, -1, 5), "Number out of Bounds");
		assertFalse( PW.validMove(board, 5, 9), "Number out of Bounds");
		assertFalse( PW.validMove(board, 5, -1), "Number out of Bounds");
		assertFalse( PW.validMove(board, 4, 4), "Same Space");
		assertFalse( PW.validMove(board, 7, 7), "Move too long");

	}
	/**
	* Test For valid moves 2
	*/
	@Test
	public void testValidMoves2 () {
		Pawn PW = new Pawn(1,6,"w");
		Pawn PB = new Pawn(2,1,"b");
		Board board = new Board();
		board.setStart();
		board.setField(1,6,PW);
		board.setField(2,1,PB);
		assertFalse( PW.validMove(board, 2, 5), "Nothing to take1");
		assertFalse( PW.validMove(board, 0, 5), "Nothing to take2");
		assertFalse( PB.validMove(board, 1, 2), "Nothing to take3");
		assertFalse( PB.validMove(board, 3, 2), "Nothing to take4");
	}
	/**
	* Test For valid moves 3
	*/
	@Test
	public void testValidMoves3 () {
		Pawn PW = new Pawn(1,6,"w");
		Pawn PB = new Pawn(2,1,"b");
		Board board = new Board();
		board.setStart();
		board.setField(1,6,PW);
		board.setField(2,1,PB);
		board.setField(2,5,new Pawn(2,5,"b"));
		board.setField(0,5,new Pawn(0,5,"b"));
		board.setField(1,2,new Pawn(1,2,"w"));
		board.setField(3,2,new Pawn(3,2,"w"));
		assertTrue( PW.validMove(board, 2, 5), "take1");
		assertTrue( PW.validMove(board, 0, 5), "take2");
		assertTrue( PB.validMove(board, 1, 2), "take3");
		assertTrue( PB.validMove(board, 3, 2), "take4");
	}
	/**
	* Test For valid moves 4
	*/
	@Test
	public void testValidMoves4 () {
		Pawn PW = new Pawn(1,6,"w");
		Pawn PB = new Pawn(2,1,"b");
		Board board = new Board();
		board.setStart();
		board.setField(1,6,PW);
		board.setField(2,1,PB);
		board.setField(2,5,new Pawn(2,5,"w"));
		board.setField(0,5,new Pawn(0,5,"w"));
		board.setField(1,2,new Pawn(1,2,"b"));
		board.setField(3,2,new Pawn(3,2,"b"));
		assertFalse( PW.validMove(board, 2, 5), "wrong color to take1");
		assertFalse( PW.validMove(board, 0, 5), "wrong color to take2");
		assertFalse( PB.validMove(board, 1, 2), "wrong color to take3");
		assertFalse( PB.validMove(board, 3, 2), "wrong color to take4");
	}
	/**
	* Test For valid moves 5
	*/
	@Test
	public void testValidMoves5 () {
		Pawn PW = new Pawn(1,6,"w");
		Pawn PB = new Pawn(2,1,"b");
		Board board = new Board();
		board.setStart();
		board.setField(1,6,PW);
		board.setField(2,1,PB);
		
		assertTrue( PW.validMove(board, 1, 5), "Normal w true");
		assertTrue( PB.validMove(board, 2, 2), "Normal b true");
		assertTrue( PW.validMove(board, 1, 4), "Double w true");
		assertTrue( PB.validMove(board, 2, 3), "Double b true");
	}
	/**
	* Test For valid moves 6
	*/
	@Test
	public void testValidMoves6 () {
		Pawn PW = new Pawn(1,6,"w");
		Pawn PB = new Pawn(2,1,"b");
		Board board = new Board();
		board.setStart();
		board.setField(1,6,PW);
		board.setField(2,1,PB);
		board.setField(2,3,new Pawn(2,3,"b"));
		board.setField(1,4,new Pawn(1,4,"b"));
		assertFalse( PW.validMove(board, 1, 4), "Double w false1");
		assertFalse( PB.validMove(board, 2, 3), "Double b false1");
	}
	/**
	* Test For valid moves 7
	*/
	@Test
	public void testValidMoves7 () {
		Pawn PW = new Pawn(1,6,"w");
		Pawn PB = new Pawn(2,1,"b");
		Board board = new Board();
		board.setStart();
		board.setField(1,6,PW);
		board.setField(2,1,PB);
		board.setField(2, 2,new Pawn(2,2,"b") );
		board.setField(1, 5,new Pawn(1,5,"b") );
		assertFalse( PW.validMove(board, 1, 5), "Normal w false");
		assertFalse( PB.validMove(board, 2, 2), "Normal b false");
		assertFalse( PW.validMove(board, 1, 4), "Double w false");
		assertFalse( PB.validMove(board, 2, 3), "Double b false");
	}
	/**
	* Test For EnPassant
	*/
	@Test
	public void testEnPassant() {
		Pawn PW = new Pawn(6,3,"w");
		Pawn PB = new Pawn(2,4,"b");
		Pawn sacPawnW = new Pawn (1,1,"w");
		Pawn sacPawnB = new Pawn (1,1,"b");
		Board board = new Board();
		board.setStart();
		board.setField(6,3,PW);
		board.setField(2,4,PB);
		
		board.setField(1,4,sacPawnW);
		Zug zug1 = new Zug(sacPawnW,1,6,"14");  
		board.movedList.add(zug1);
		PB.realMove =true;
		assertTrue( PB.validMove1(board, 1, 5), "En Passant b1 true");
		
		board.setField(3,4,sacPawnW);
		Zug zug2 = new Zug(sacPawnW,3,6,"34");  
		board.movedList.add(zug2);
		PB.realMove =true;
		assertTrue( PB.validMove1(board, 3, 5), "En Passant b2 true");
		
		board.setField(5,3,sacPawnB);
		Zug zug3 = new Zug(sacPawnB,5,1,"53");  
		board.movedList.add(zug3);
		PW.realMove =true;
		assertTrue( PW.validMove1(board, 5, 2), "En Passant w1 true");
		
		board.setField(7,3,sacPawnB);
		Zug zug4 = new Zug(sacPawnB,7,1,"73");  
		board.movedList.add(zug4);
		PW.realMove =true;
		assertTrue( PW.validMove1(board, 7, 2), "En Passant w2 true");
	}
}
