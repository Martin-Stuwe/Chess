package game;
import figures.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
	@Test
	public void testGetFieldSetField() {
		Board board = new Board();
		Rook R = new Rook(1,1,"b");
		board.setField(1, 1, R);
		assertEquals(R, board.getField(1, 1), "getField und setField funktionieren");
	}
	@Test
	public void testSetNull() {
		Board board = new Board();
		Rook R = new Rook(1,1,"b");
		board.setField(1, 1, R);
		assertEquals(R, board.getField(1, 1), "getField und setField funktionieren");
		board.setNull(1, 1);
		assertEquals(null, board.getField(1, 1), "setNull funktioniert");
	}
	@Test
	public void testInitializeBoard() { 
		Board board = new Board();
		board.setStart();
		board.initializeBoard();
		for(int i =0; i<8;i++) {
			for(int y =0; y<8;y++) {
				
				if(board.positionen[i][y] == null) {
					board.positionenS[i][y] = " ";
					assertEquals(" ", board.positionenS[i][y], "leerzeichen in Feld");
				}
				
				else {
					assertEquals(board.positionen[i][y].getBoardVisual(), board.positionenS[i][y], "leerzeichen in Feld");
				}
			}
			
		}
	}
		@Test
		public void testConverMoveInput() {
			Board board = new Board();
			board.setStart();
			assertEquals("07" ,board.ConvertMoveInput(board, 'a', 1) ,"test a1");
			assertEquals("17" ,board.ConvertMoveInput(board, 'b', 1) ,"test b1");
			assertEquals("27" ,board.ConvertMoveInput(board, 'c', 1) ,"test c1");
			assertEquals("37" ,board.ConvertMoveInput(board, 'd', 1) ,"test d1");
			assertEquals("47" ,board.ConvertMoveInput(board, 'e', 1) ,"test e1");
			assertEquals("57" ,board.ConvertMoveInput(board, 'f', 1) ,"test f1");
			assertEquals("67" ,board.ConvertMoveInput(board, 'g', 1) ,"test g1");
			assertEquals("77" ,board.ConvertMoveInput(board, 'h', 1) ,"test h1");
			assertEquals("420" ,board.ConvertMoveInput(board, 'q', 1) ,"test 420 1");
			assertEquals("420" ,board.ConvertMoveInput(board, 'a', 9) ,"test 420 2");
			assertEquals("420" ,board.ConvertMoveInput(board, 'a', 0) ,"test 420 3");
}
		@Test
		public void testSetCurrentTurn() {
			Board board = new Board();
			board.setCurrentTurn(2);
			assertEquals(2, board.getCurrentTurn(), "getCurrentTurn und setCurrentTurn funktionieren");
			
		}
	
}