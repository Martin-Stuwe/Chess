package game;
import schach.Console;
import game.Board;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import figures.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class StartGameTest {
	@Test
	public void testStarGameCommand() {
		StartGame testGame = new StartGame();
		Board board2 = new Board();
		InputStream in= new ByteArrayInputStream ("exit\r\n".getBytes());
		System.setIn(in);
		testGame.StartGameCommand(); 

	}
	@Test
	public void testPlayerVSPlayer() {
		StartGame testGame = new StartGame();
		Board board2 = new Board();
		InputStream in= new ByteArrayInputStream ("exit\r\n".getBytes());
		System.setIn(in);
		testGame.PlayerVsPlayer();

	}
	@Test
	public void testGetAndMakeMove() {
		StartGame testGame = new StartGame();
		Board board2 = new Board();
		board2.setCurrentTurn(0);
		InputStream in= new ByteArrayInputStream ("exit\r\n".getBytes());
		System.setIn(in);
		testGame.getAndMakeMove(board2);
		
		board2.setCurrentTurn(1);
		InputStream in2= new ByteArrayInputStream ("exit\r\n".getBytes());
		System.setIn(in2);
		testGame.getAndMakeMove(board2);
		
		board2.setCurrentTurn(1);
		InputStream in3= new ByteArrayInputStream ("beaten\r\n".getBytes());
		System.setIn(in3);
		//testGame.getAndMakeMove(board2);
	}
}
