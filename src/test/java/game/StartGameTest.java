package game;
import schach.Console;

import java.io.InputStream;
import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;
import figures.Pawn;

import static org.junit.jupiter.api.Assertions.*;
/**
* Class for Startgame tests
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* group 23
* it1
*/
public class StartGameTest {

	/**
	* Test For getAndMakeMove
	*/
	@Test
	public void testGetAndMakeMove() {

		Board board2 = new Board();
		board2.setCurrentTurn(0);
		InputStream in= new ByteArrayInputStream ("white\r\nexit\r\n".getBytes());
		System.setIn(in);
		StartGame.getAndMakeMove(board2);
		
		board2.setCurrentTurn(1);
		InputStream in2= new ByteArrayInputStream ("white\r\n exit\r\n".getBytes());
		System.setIn(in2);
		StartGame.getAndMakeMove(board2);
		
		board2.setCurrentTurn(1);
		InputStream in3= new ByteArrayInputStream ("white\r\n beaten\r\n".getBytes());
		System.setIn(in3);
		assertEquals(null,board2.getField(0, 5));
		//StartGame.getAndMakeMove(board2);
	}

	/**
	* Test For Pawnpromo
	*/
	@Test
	public void testPawnPromotion() {
		StartGame StartGame = new StartGame();
		Board board2 = new Board();
		board2.setStart();
		Console TC = new Console();	
		InputStream in= new ByteArrayInputStream ("e2-e8Q\r\n".getBytes());
		System.setIn(in);
		TC.open();
		board2.setField(2, 0, new Pawn(2,0,"w"));
		StartGame.pawnPromotion(2, 0, board2, TC);
		assertNotEquals(null,board2.getField(2, 0));
		InputStream in2= new ByteArrayInputStream ("e2-e8R\r\n".getBytes());
		System.setIn(in2);
		TC.open();
		board2.setField(2, 0, new Pawn(2,0,"w"));
		StartGame.pawnPromotion(2, 0, board2, TC);
		
		InputStream in3= new ByteArrayInputStream ("e2-e8N\r\n".getBytes());
		System.setIn(in3);
		TC.open();
		board2.setField(2, 0, new Pawn(2,0,"w"));
		StartGame.pawnPromotion(2, 0, board2, TC);
		
		InputStream in4= new ByteArrayInputStream ("e2-e8B\r\n".getBytes());
		System.setIn(in4);
		TC.open();
		board2.setField(2, 0, new Pawn(2,0,"w"));
		StartGame.pawnPromotion(2, 0, board2, TC);
		
		InputStream in5= new ByteArrayInputStream ("e2-e8\r\n".getBytes());
		System.setIn(in5);
		TC.open();
		board2.setField(2, 0, new Pawn(2,0,"w"));
		StartGame.pawnPromotion(2, 0, board2, TC);
		
		InputStream in6= new ByteArrayInputStream ("e2-e8 \r\n".getBytes());
		System.setIn(in6);
		TC.open();
		board2.setField(2, 0, new Pawn(2,0,"w"));
		StartGame.pawnPromotion(2, 0, board2, TC);
	}
	
	/**
	* Test For Player vs Player
	*/
	/*@Test
	public void testPlayerVsPlayer() {

		Console TC = new Console();	
		InputStream in= new ByteArrayInputStream ("white\r\n exit\r\n".getBytes());
		System.setIn(in);
		StartGame.PlayerVsPlayer();
	}*/
	/**
	* Test For Player Vs AI
	*/
	/*@Test
	public void testPlayerVsAI() {

		InputStream in= new ByteArrayInputStream ("white\n exit\n".getBytes());
		System.setIn(in);
		StartGame.PlayerVsAI(0);
	}*/
	/**
	* Test For Timer
	*/
	/*@Test
	public void testTimeQuestion() {
		Board board2 = new Board();
		board2.setStart();
		String input = "1"
				+"\n200"
				+"\n200";
		Console TC = new Console();	
		InputStream in= new ByteArrayInputStream (input.getBytes());
		System.setIn(in);
		StartGame.timeQuestion();
	}*/
	
	/**
	* Test For Timer2
	*/
	@Test
	public void testTimeQuestion2() {
		Board board2 = new Board();
		board2.setStart();
		String input = "200"
				+"\n200"
				+"\n200";

		InputStream in= new ByteArrayInputStream (input.getBytes());
		System.setIn(in);
		StartGame.timeQuestionPartTwo(200);
		assertEquals(200,StartGame.clock.timeBlack,"tiem set");
	}
	/**
	* Test For Undo and Redo
	*/
	@Test
	public void testUndoRedoMoves() {
		Board board2 = new Board();
		board2.setStart();
		board2.getField(4, 6).move(board2, 4, 6, "44");
		board2.getField(4, 1).move(board2, 4, 1, "43");
		board2.getField(5, 6).move(board2, 5, 6, "54");
		System.out.println(board2.movedList);
		StartGame.undoMove(board2);
		assertNotEquals(null,board2.getField(5, 6),"undo test 1");
		StartGame.redoMove(board2);
		assertEquals(null,board2.getField(5, 6),"redo test 1");
	}
	/**
	* Test For make save
	*/
	@Test
	public void testMakeSaveConsole() {
		Board board2 = new Board();
		board2.setStart();
		board2.getField(4, 6).move(board2, 4, 6, "44");
		board2.getField(4, 1).move(board2, 4, 1, "43");
		board2.getField(5, 6).move(board2, 5, 6, "54");
		StartGame.makeSaveConsole(board2);
		assertEquals(null, board2.getField(5, 6));
	}
	

	/* @Test 
	public void testStartGameCommand() {
		InputStream in= new ByteArrayInputStream ("white\r\n exit\r\n".getBytes());
		System.setIn(in);
		StartGame.StartGameCommand();
	}
	/**
	* Test For Startgame2
	*/
	/*@Test
	public void testStartGameCommand2() {
		InputStream in= new ByteArrayInputStream ("1".getBytes());
		System.setIn(in);
		StartGame.StartGamePartTwo(0);
	}*/
}
