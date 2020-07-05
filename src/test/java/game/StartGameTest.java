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
/*	@Test
	public void testStarGameCommand() {
		StartGame StartGame = new StartGame();
		Board board2 = new Board();
		InputStream in= new ByteArrayInputStream ("exit\r\n".getBytes());
		System.setIn(in);
		StartGame.StartGameCommand(); 

	}
	@Test
	public void testPlayerVSPlayer() {
		StartGame StartGame = new StartGame();
		Board board2 = new Board();
		InputStream in= new ByteArrayInputStream ("exit\r\n".getBytes());
		System.setIn(in);
		StartGame.PlayerVsPlayer();

	}*/
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
	@Test
	public void testPlayerVsPlayer() {
		InputStream in= new ByteArrayInputStream ("white\r\n exit\r\n".getBytes());
		System.setIn(in);
		StartGame.PlayerVsPlayer();
	}
	
	@Test
	public void testPlayerVsAI() {
		InputStream in= new ByteArrayInputStream ("white\r\n exit\r\n".getBytes());
		System.setIn(in);
		StartGame.PlayerVsAI(0);
	}
}
