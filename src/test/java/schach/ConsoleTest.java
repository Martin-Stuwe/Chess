package schach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import game.Board;

import java.io.InputStream;

import java.io.ByteArrayInputStream;


/**
* Class for Console tests
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* group 23
* it1
*/
public class ConsoleTest {
	/**
	* Test For Console
	*/
	@Test
	public void testConsole() {
		Console TC = new Console();	
		InputStream in= new ByteArrayInputStream ("Test\r\n".getBytes());
		System.setIn(in);
		TC.open();				
		assertEquals("Test",TC.input,"undo test 1");
		} 
	
	/**
	* Test for user Input
	*/
	@Test
	public void testCheckUserInput(){
		Board board2 = new Board();
		board2.setStart();
		Console TC = new Console();	
		InputStream in= new ByteArrayInputStream ("test\r\n".getBytes());
		System.setIn(in);
		TC.open();
		Console.checkUserInput(TC, board2);
		assertEquals("test",TC.input,"input written");
	}
	
	/**
	* Test For Move Conversion
	*/
	@Test
	public void testConvertAndMove() {
		Board board2 = new Board();
		board2.setStart();
		Console TC = new Console();	
		//succesfull move
		InputStream in= new ByteArrayInputStream ("e2-e4\r\n".getBytes());
		System.setIn(in);
		TC.open();
		Console.convertAndMove(board2, TC);
		
		InputStream in2= new ByteArrayInputStream ("\r\n".getBytes());
		System.setIn(in2);
		TC.open();
		Console.convertAndMove(board2, TC);
		
		InputStream in3= new ByteArrayInputStream ("asfsaf \r\n".getBytes());
		System.setIn(in3);
		TC.open();
		Console.convertAndMove(board2, TC);
		
		InputStream in4= new ByteArrayInputStream ("e2-e9 \r\n".getBytes());
		System.setIn(in4);
		TC.open();
		Console.convertAndMove(board2, TC);
		
		InputStream in5= new ByteArrayInputStream ("q2-e5 \r\n".getBytes());
		System.setIn(in5);
		TC.open();
		Console.convertAndMove(board2, TC);
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
		Console.convertAndMove(board2, TC);
		assertEquals(null,board2.getField(0, 3));
	}
}
