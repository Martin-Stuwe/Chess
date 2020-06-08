package game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class AITest {

	@Test
	public void testColor() {
		AI ki=new AI(1);
		ki.setColor(0);
		assertEquals(0, ki.getColor(), "getColor");
	}
	
	@Test
	public void testFindPossMoves() {
		AI ki=new AI(1);
		Board board= new Board();
		board.setStart();
		ki.findPossMoves(board, 1);
		assertEquals(0, ki.possibleMoves.size(), "possMoves1");
		board.setCurrentTurn(1);
		ki.findPossMoves(board, 1);
		assertNotEquals(0, ki.possibleMoves.size(), "possMoves2");
	}
	
	@Test
	public void testCalculate() {
		AI ki=new AI(1);
		Board board= new Board();
		board.setStart();

		board.setCurrentTurn(1);
		ki.findPossMoves(board, 1);
		assertEquals(0, ki.enPossibleMoves.size(), "enPossMoves1");
		ki.Calculate(board);
		assertNotEquals(0, ki.enPossibleMoves.size(), "enPossMoves2");
	}
	
	@Test
	public void testConvertTurn() {
		AI ki=new AI(1);
		Board board= new Board();
		board.setStart();
		assertEquals("w", ki.convertTurn(0), "Turn0");
		assertEquals("b", ki.convertTurn(1), "Turn1");
	}
	
}
