package game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
* Class for AI tests
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* group 23
* it1
*/
public class AITest {
	/**
	* Test For color
	*/
	@Test
	public void testColor() {
		AI ki=new AI(1);
		ki.setColor(0);
		assertEquals(0, ki.getColor(), "getColor");
	}
	/**
	* Test For findPossMoves
	*/
	@Test
	public void testFindPossMoves() {
		AI ki=new AI(1);
		Board board= new Board();
		board.setStart();
		ki.findPossMovesAI(board, 1);
		assertEquals(0, ki.possibleMoves.size(), "possMoves1");
		board.setCurrentTurn(1);
		ki.findPossMovesAI(board, 1);
		assertNotEquals(0, ki.possibleMoves.size(), "possMoves2");
	}

	
	/**
	* Test For ConvertTurn
	*/
	@Test 
	public void testConvertTurn() {
		AI ki=new AI(1);
		Board board= new Board();
		board.setStart();
		assertEquals("w", ki.convertTurn(0), "Turn0");
		assertEquals("b", ki.convertTurn(1), "Turn1");
	}
	/**
	* Test For Calculate Value
	*/
	@Test
	public void testCalculateValue() {
		AI ki=new AI(1);
		Board board= new Board();
		board.setStart();
		assertEquals(5040, ki.calculateValue(board), "Startvalue");
		board.setNull(1, 1);
		assertEquals(5039, ki.calculateValue(board), "remove Pawn -> value -1");

	}
	
	/**
	* Test For Calculate ValueFor
	*/
	@Test
	public void testCalculateValueFor() {
		AI ki=new AI(1);
		Board board= new Board();
		board.setStart();
		assertEquals(5040, ki.calculateValueFor(board,0), "Start value black");
		assertEquals(5040, ki.calculateValueFor(board,1), "Start value white");

	}
	
	/**
	* Test For Figure Value 1
	*/
	@Test
	public void testCalculateFigure() {
		AI ki=new AI(1);
		Board board= new Board();
		board.setStart();
		assertEquals(0, ki.calculateFigure(board.getField(1, 1), "b"), "Color");
		assertEquals(1, ki.calculateFigure(board.getField(1, 1), "w"), "Pawn");
		assertEquals(3, ki.calculateFigure(board.getField(2, 0), "w"), "Bishop");
		assertEquals(3, ki.calculateFigure(board.getField(1, 0), "w"), "Knight");

	}
	/**
	* Test For Figure Value 2
	*/
	@Test
	public void testCalculateFigure2() {
		AI ki=new AI(1);
		Board board= new Board();
		board.setStart();
		assertEquals(5, ki.calculateFigure(board.getField(0, 0), "w"), "Rook");
		assertEquals(10, ki.calculateFigure(board.getField(3, 0), "w"), "Queen");
		assertEquals(5000, ki.calculateFigure(board.getField(4, 0), "w"), "King");
	}
	/**
	* Test For Random moves
	*/
	@Test
	public void testDoRndMove() {
		AI ki=new AI(1);
		Board board= new Board();
		Board board2= new Board();
		board.setStart();
		board2.setStart();
		board2.setCurrentTurn(1);
		ki.findPossMovesAI(board2, 1);
		ki.DoRndMove(board2);
		assertNotEquals(board.positionen,board2.positionen,"moved");
	}
	
	/**
	* Test For min moves
	*/
	@Test
	public void testmin() {
		AI ki=new AI(1);
		Board board= new Board();
		board.setStart();
		ki.min(board, 1, -500000, 500000);
		assertEquals(ki.min(board, 1, -500000, 500000),5040,"min Value");
	}
	
	/**
	* Test For max moves
	*/
	@Test
	public void testmax() {
		AI ki=new AI(1);
		Board board= new Board();
		board.setStart();
		ki.max(board, 1, -500000, 500000);
		assertEquals(ki.min(board, 1, -500000, 500000),5040,"min Value");
	}

}
