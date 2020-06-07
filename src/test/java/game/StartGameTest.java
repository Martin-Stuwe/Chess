package game;
import schach.Console;
import game.Board;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import figures.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class StartGameTest {
/*	@Test
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

	}*/
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
	@Test
	public void testConvertAndMove() {
		StartGame testGame = new StartGame();
		Board board2 = new Board();
		board2.setStart();
		Console TC = new Console();	
		//succesfull move
		InputStream in= new ByteArrayInputStream ("e2-e4\r\n".getBytes());
		System.setIn(in);
		TC.open();
		testGame.convertAndMove(board2, TC);
		
		InputStream in2= new ByteArrayInputStream ("\r\n".getBytes());
		System.setIn(in2);
		TC.open();
		testGame.convertAndMove(board2, TC);
		
		InputStream in3= new ByteArrayInputStream ("asfsaf \r\n".getBytes());
		System.setIn(in3);
		TC.open();
		testGame.convertAndMove(board2, TC);
		
		InputStream in4= new ByteArrayInputStream ("e2-e9 \r\n".getBytes());
		System.setIn(in4);
		TC.open();
		testGame.convertAndMove(board2, TC);
		
		InputStream in5= new ByteArrayInputStream ("q2-e5 \r\n".getBytes());
		System.setIn(in5);
		TC.open();
		testGame.convertAndMove(board2, TC);
		board2.setStart();
		board2.setCurrentTurn(0);
		board2.getField(4, 6).move(board2, 4, 6, "44");
		board2.getField(5, 1).move(board2, 5, 1, "52");
		board2.getField(5, 7).move(board2, 5, 7, "46");
		board2.getField(6, 1).move(board2, 6, 1, "63");
		board2.getField(4, 6).move(board2, 4, 6, "73");
		
		InputStream in6= new ByteArrayInputStream ("a3-a4\r\n".getBytes());
		System.setIn(in6);
		TC.open();
		testGame.convertAndMove(board2, TC);
	}
	
	@Test
	public void testPawnPromotion() {
		StartGame testGame = new StartGame();
		Board board2 = new Board();
		board2.setStart();
		Console TC = new Console();	
		InputStream in= new ByteArrayInputStream ("e2-e8Q\r\n".getBytes());
		System.setIn(in);
		TC.open();
		board2.setField(2, 0, new Pawn(2,0,"w"));
		testGame.pawnPromotion(2, 0, board2, TC);
		
		InputStream in2= new ByteArrayInputStream ("e2-e8R\r\n".getBytes());
		System.setIn(in2);
		TC.open();
		board2.setField(2, 0, new Pawn(2,0,"w"));
		testGame.pawnPromotion(2, 0, board2, TC);
		
		InputStream in3= new ByteArrayInputStream ("e2-e8N\r\n".getBytes());
		System.setIn(in3);
		TC.open();
		board2.setField(2, 0, new Pawn(2,0,"w"));
		testGame.pawnPromotion(2, 0, board2, TC);
		
		InputStream in4= new ByteArrayInputStream ("e2-e8B\r\n".getBytes());
		System.setIn(in4);
		TC.open();
		board2.setField(2, 0, new Pawn(2,0,"w"));
		testGame.pawnPromotion(2, 0, board2, TC);
		
		InputStream in5= new ByteArrayInputStream ("e2-e8\r\n".getBytes());
		System.setIn(in5);
		TC.open();
		board2.setField(2, 0, new Pawn(2,0,"w"));
		testGame.pawnPromotion(2, 0, board2, TC);
		
		InputStream in6= new ByteArrayInputStream ("e2-e8 \r\n".getBytes());
		System.setIn(in6);
		TC.open();
		board2.setField(2, 0, new Pawn(2,0,"w"));
		testGame.pawnPromotion(2, 0, board2, TC);
	}
}
