package game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import game.Board;
import figures.*;
public class FiguresTest {
	@Test
	public void testPositions() {
		Figures ftest = new Figures();
		ftest.setPos(1, 2);
		assertEquals(1, ftest.getPos1(), "Pos 1 erfolgreich gesetzt");
		assertEquals(2, ftest.getPos2(), "Pos 2 erfolgreich gesetzt");
	}
	@Test
	public void testgetBoardVisual() {
		Figures ftest = new Figures();
		assertEquals(null, ftest.getBoardVisual(), "boardVisual = null");
	}
	@Test
	public void testgetType() {
		Figures ftest = new Figures();
		assertEquals(0, ftest.getType(), "type = 0");
	}
	@Test
	public void testgetColor() {
		Figures ftest = new Figures();
		assertEquals(null, ftest.getColor(), "color = null");
	}
	@Test
	public void testHasMoved() {
		Figures ftest = new Figures();
		ftest.setHasMoved(true);
		assertEquals(true, ftest.isHasMoved(), "hasMoved = true");
	}
	@Test
	public void testValidMove() {
		Figures ftest = new Figures();
		ftest.setHasMoved(true);
		assertEquals(false, ftest.validMove(new Board(),1,1), "valid Move = false");
	}
	@Test
	public void testMove() {
		Board board = new Board();
		board.setStart();
		Rook rook = new Rook(4,4,"w");
		board.setField(4, 4, rook);
		assertEquals(true,board.getField(4, 4).move(board, 4, 4, 4, 3),"valid move rightturn");
		assertEquals(false,board.getField(4, 3).move(board, 4, 3, 4, 4),"valid move wrong turn");
		board.setCurrentTurn(0);
		assertEquals(true,board.getField(4, 3).move(board, 4, 3, 4, 1),"valid move wrong turn");
		assertEquals(false,board.getField(0, 1).move(board, 0, 1, 0, 3),"valid move");
		
		board.setStart();
		Rook rookb = new Rook(4,4,"b");
		board.setField(4, 4, rookb);
		board.setCurrentTurn(1);
		assertEquals(true,board.getField(4, 4).move(board, 4, 4, 4, 3),"valid move rightturn");
		assertEquals(false,board.getField(4, 3).move(board, 4, 3, 4, 4),"valid move wrong turn");
		board.setCurrentTurn(1);
		assertEquals(false,board.getField(4, 3).move(board, 4, 3, 7, 4),"invalid move");
		
		assertEquals(true,board.getField(4, 3).move(board, 4, 3, 4, 6),"valid move");
		assertEquals(false,board.getField(0, 6).move(board, 0, 6, 0, 4),"valid move");
	}
}
