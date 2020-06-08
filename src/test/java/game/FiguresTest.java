package game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import figures.*;
/**
* Class for Pawn tests
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* group 23
* it1
*/
public class FiguresTest {
	/**
	* Test For Postitions
	*/
	@Test
	public void testPositions() {
		Figures ftest = new Figures();
		ftest.setPos(1, 2);
		assertEquals(1, ftest.getPos1(), "Pos 1 erfolgreich gesetzt");
		assertEquals(2, ftest.getPos2(), "Pos 2 erfolgreich gesetzt");
	}
	/**
	* Test For boardVisual
	*/
	@Test
	public void testgetBoardVisual() {
		Figures ftest = new Figures();
		assertEquals(null, ftest.getBoardVisual(), "boardVisual = null");
	}
	/**
	* Test For type
	*/
	@Test
	public void testgetType() {
		Figures ftest = new Figures();
		assertEquals(0, ftest.getType(), "type = 0");
	}
	/**
	* Test For color
	*/
	@Test
	public void testgetColor() {
		Figures ftest = new Figures();
		assertEquals(null, ftest.getColor(), "color = null");
	}
	/**
	* Test For hasMoved
	*/
	@Test
	public void testHasMoved() {
		Figures ftest = new Figures();
		ftest.setHasMoved(true);
		assertTrue( ftest.isHasMoved(), "hasMoved = true");
	}
	/**
	* Test For validMove
	*/
	@Test
	public void testValidMove() {
		Figures ftest = new Figures();
		ftest.setHasMoved(true);
		assertFalse( ftest.validMove(new Board(),1,1), "valid Move = false");
	}
	/**
	* Test For moves
	*/
	@Test
	public void testMove() {
		Board board = new Board();
		board.setStart();
		Rook rook = new Rook(4,4,"w");
		board.setField(4, 4, rook);
		
		board.setStart();
		Rook rookb = new Rook(4,4,"b");
		board.setField(4, 4, rookb);
		board.setCurrentTurn(1);
		assertTrue(board.getField(4, 4).move(board, 4, 4, "43"),"valid move rightturn");
		assertFalse(board.getField(4, 3).move(board, 4, 3, "44"),"valid move wrong turn");
		board.setCurrentTurn(1);
		assertFalse(board.getField(4, 3).move(board, 4, 3, "74"),"invalid move");
		
		assertTrue(board.getField(4, 3).move(board, 4, 3, "46"),"valid move");
		assertFalse(board.getField(0, 6).move(board, 0, 6, "04"),"valid move");
	}
	/**
	* Test For more moves
	*/
	@Test
	public void testMove2() {
		Board board = new Board();
		board.setStart();
		Rook rook = new Rook(4,4,"w");
		board.setField(4, 4, rook);
		assertTrue(board.getField(4, 4).move(board, 4, 4, "43"),"valid move rightturn");
		assertFalse(board.getField(4, 3).move(board, 4, 3, "44"),"valid move wrong turn");
		board.setCurrentTurn(0);
		assertTrue(board.getField(4, 3).move(board, 4, 3, "41"),"valid move wrong turn");
		assertFalse(board.getField(0, 1).move(board, 0, 1, "03"),"valid move");
	}
}
