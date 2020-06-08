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
	
	@Test
	public void testCalculateValue() {
		AI ki=new AI(1);
		Board board= new Board();
		board.setStart();
		assertEquals(10080, ki.calculateValue(board), "Startvalue");
		board.setNull(1, 1);
		assertEquals(10079, ki.calculateValue(board), "remove Pawn -> value -1");

	}
	@Test
	public void testCalculateFigure() {
		AI ki=new AI(1);
		Board board= new Board();
		board.setStart();
		assertEquals(0, ki.calculateFigure(board.getField(1, 1), "b"), "Color");
		assertEquals(1, ki.calculateFigure(board.getField(1, 1), "w"), "Pawn");
		assertEquals(3, ki.calculateFigure(board.getField(2, 0), "w"), "Bishop");
		assertEquals(3, ki.calculateFigure(board.getField(1, 0), "w"), "Knight");
		assertEquals(5, ki.calculateFigure(board.getField(0, 0), "w"), "Rook");
		assertEquals(10, ki.calculateFigure(board.getField(3, 0), "w"), "Queen");
		assertEquals(5000, ki.calculateFigure(board.getField(4, 0), "w"), "King");
	}
	@Test
	public void testDoRndMove() {
		AI ki=new AI(1);
		Board board= new Board();
		Board board2= new Board();
		board.setStart();
		board2.setStart();
		board2.setCurrentTurn(1);
		ki.findPossMoves(board2, 1);
		ki.DoRndMove(board2);
		assertNotEquals(board.positionen,board2.positionen,"moved");
	}
	@Test
	public void testDoMinMove() {
		AI ki=new AI(1);
		Board board= new Board();
		Board board2= new Board();
		board.setStart();
		board2.setStart();
		board2.setCurrentTurn(1);
		ki.findPossMoves(board2, 1);
		ki.DoMinMove(board2);
		assertNotEquals(board.positionen,board2.positionen,"moved");
		ki.EnemyValue.add(1);
		ki.DoMinMove(board2);
		assertNotEquals(board.positionen,board2.positionen,"moved2");
	}
}
