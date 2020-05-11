package figures;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import game.Figures;
import game.Zug;
import game.Board;

public class PawnTest {
	
	
	@Test
	public void testBoardVisual () {
		Pawn PW = new Pawn(3,2,"w");
		Pawn PB = new Pawn(1,2,"b");
		Pawn PQ = new Pawn(3,2,"q");
		assertEquals("P", PW.getBoardVisual(), "Farbe Weiß erkannt");
		assertEquals("p", PB.getBoardVisual(), "Farbe Schwarz erkannt");
		assertEquals(null, PQ.getBoardVisual(), "Falsche Farbe erkannt");

	}
	
	@Test
	public void testPos () {
		Pawn PW = new Pawn(3,2,"w");
		PW.setPos(1,2);
		assertEquals(1, PW.pos1, "Pos1 gesetzt und ausgelesen");
		assertEquals(2, PW.pos2, "Pos2 gesetzt und ausgelesen");
	}
	@Test
	public void testColor () {
		Pawn PW = new Pawn(3,2,"w");
		assertEquals("w", PW.getColor(), "Farbe ausgelesen");
	
	}
	@Test
	public void testType () {
		Pawn PW = new Pawn(3,2,"w");
		assertEquals(4, PW.getType(), "Type ausgelesen");
	
	}
	@Test
	public void testhasMoved () {
		Pawn PW = new Pawn(3,2,"w");
		assertEquals(false, PW.getHasMoved(), "hasMoved ausgelesen");
		PW.setHasMoved(true);
		assertEquals(true, PW.getHasMoved(), "hasMoved gesetzt");
	}
	@Test
	public void testValidMoves () {
		Pawn PW = new Pawn(1,6,"w");
		Pawn PB = new Pawn(2,1,"b");
		Board board = new Board();
		board.setStart();
		board.setField(1,6,PW);
		board.setField(2,1,PB);
		assertEquals(false, PW.validMove(board, 9, 5), "Number out of Bounds");
		assertEquals(false, PW.validMove(board, -1, 5), "Number out of Bounds");
		assertEquals(false, PW.validMove(board, 5, 9), "Number out of Bounds");
		assertEquals(false, PW.validMove(board, 5, -1), "Number out of Bounds");
		assertEquals(false, PW.validMove(board, 4, 4), "Same Space");
		assertEquals(false, PW.validMove(board, 7, 7), "Move too long");
		assertEquals(false, PW.validMove(board, 2, 5), "Nothing to take1");
		assertEquals(false, PW.validMove(board, 0, 5), "Nothing to take2");
		assertEquals(false, PB.validMove(board, 1, 2), "Nothing to take3");
		assertEquals(false, PB.validMove(board, 3, 2), "Nothing to take4");
		board.setField(2,5,new Pawn(2,5,"b"));
		board.setField(0,5,new Pawn(0,5,"b"));
		board.setField(1,2,new Pawn(1,2,"w"));
		board.setField(3,2,new Pawn(3,2,"w"));
		assertEquals(true, PW.validMove(board, 2, 5), "take1");
		assertEquals(true, PW.validMove(board, 0, 5), "take2");
		assertEquals(true, PB.validMove(board, 1, 2), "take3");
		assertEquals(true, PB.validMove(board, 3, 2), "take4");
		board.setField(2,5,new Pawn(2,5,"w"));
		board.setField(0,5,new Pawn(0,5,"w"));
		board.setField(1,2,new Pawn(1,2,"b"));
		board.setField(3,2,new Pawn(3,2,"b"));
		assertEquals(false, PW.validMove(board, 2, 5), "wrong color to take1");
		assertEquals(false, PW.validMove(board, 0, 5), "wrong color to take2");
		assertEquals(false, PB.validMove(board, 1, 2), "wrong color to take3");
		assertEquals(false, PB.validMove(board, 3, 2), "wrong color to take4");
		
		assertEquals(true, PW.validMove(board, 1, 5), "Normal w true");
		assertEquals(true, PB.validMove(board, 2, 2), "Normal b true");
		assertEquals(true, PW.validMove(board, 1, 4), "Double w true");
		assertEquals(true, PB.validMove(board, 2, 3), "Double b true");
		board.setField(2,3,new Pawn(2,3,"b"));
		board.setField(1,4,new Pawn(1,4,"b"));
		assertEquals(false, PW.validMove(board, 1, 4), "Double w false1");
		assertEquals(false, PB.validMove(board, 2, 3), "Double b false1");
		board.setField(2, 2,new Pawn(2,2,"b") );
		board.setField(1, 5,new Pawn(1,5,"b") );
		assertEquals(false, PW.validMove(board, 1, 5), "Normal w false");
		assertEquals(false, PB.validMove(board, 2, 2), "Normal b false");
		assertEquals(false, PW.validMove(board, 1, 4), "Double w false");
		assertEquals(false, PB.validMove(board, 2, 3), "Double b false");
	}
	
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
		Zug zug1 = new Zug(sacPawnW,1,6,1,4);  
		board.movedList.add(zug1);
		assertEquals(true, PB.validMove(board, 1, 5), "En Passant b1 true");
		
		board.setField(3,4,sacPawnW);
		Zug zug2 = new Zug(sacPawnW,3,6,3,4);  
		board.movedList.add(zug2);
		assertEquals(true, PB.validMove(board, 3, 5), "En Passant b2 true");
		
		board.setField(5,3,sacPawnB);
		Zug zug3 = new Zug(sacPawnB,5,1,5,3);  
		board.movedList.add(zug3);
		assertEquals(true, PW.validMove(board, 5, 2), "En Passant w1 true");
		
		board.setField(7,3,sacPawnB);
		Zug zug4 = new Zug(sacPawnB,7,1,7,3);  
		board.movedList.add(zug4);
		assertEquals(true, PW.validMove(board, 7, 2), "En Passant w2 true");
	}
}
