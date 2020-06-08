package game;

import org.junit.jupiter.api.Test;

import javafx.scene.control.ListView;
import static org.junit.jupiter.api.Assertions.*;
/**
* Class for GUI calculation tests
* @author Martin Stuwe 676421
* @author Zeyi Sun
* @author Richard Tank
* @author Fin Niklas Tiedemann
* group 23
* it1
*/
public class GuiCalcsTest {
	/**
	* Test For Convert symbols 1
	*/
	@Test
	public void testCheckWhiteSymblos() {
		GuiCalcs calc =new GuiCalcs();
		assertEquals("♙", calc.checkWhiteSymbols("P"), "white Symbol1");
		assertEquals("♖", calc.checkWhiteSymbols("R"), "white Symbol2");
		assertEquals("♘", calc.checkWhiteSymbols("N"), "white Symbol3");

	}
	/**
	* Test For Convert symbols 2
	*/
	@Test
	public void testCheckWhiteSymblos2() {
		GuiCalcs calc =new GuiCalcs();
		assertEquals("♗", calc.checkWhiteSymbols("B"), "white Symbol4");
		assertEquals("♕", calc.checkWhiteSymbols("Q"), "white Symbol5");
		assertEquals("♔", calc.checkWhiteSymbols("K"), "white Symbol6");

	}
	/**
	* Test For Convert symbols 3
	*/
	@Test
	public void testCheckBlackSymblos() {
		GuiCalcs calc =new GuiCalcs();
		assertEquals("♟", calc.checkBlackSymbols("p"), "black Symbol1");
		assertEquals("♜", calc.checkBlackSymbols("r"), "black Symbol2");
		assertEquals("♞", calc.checkBlackSymbols("n"), "black Symbol3");
		

	}
	/**
	* Test For Convert symbols 4
	*/
	@Test
	public void testCheckBlackSymblos2() {
		GuiCalcs calc =new GuiCalcs();

		assertEquals("♝", calc.checkBlackSymbols("b"), "black Symbol4");
		assertEquals("♛", calc.checkBlackSymbols("q"), "black Symbol5");
		assertEquals("♚", calc.checkBlackSymbols("k"), "black Symbol6");
		

	}
	/**
	* Test For Convert numbers 1
	*/
	@Test
	public void testIntToNumber() {
		GuiCalcs calc =new GuiCalcs();
		assertEquals(8,calc.numberToNumber(0),"Convert 0");
		assertEquals(7,calc.numberToNumber(1),"Convert 1");
		assertEquals(6,calc.numberToNumber(2),"Convert 2");
		assertEquals(5,calc.numberToNumber(3),"Convert 3");


	}
	/**
	* Test For Convert numbers 2
	*/
	@Test
	public void testIntToNumber2() {
		GuiCalcs calc =new GuiCalcs();
		
		assertEquals(4,calc.numberToNumber(4),"Convert 4");
		assertEquals(3,calc.numberToNumber(5),"Convert 5");
		assertEquals(2,calc.numberToNumber(6),"Convert 6");
		assertEquals(1,calc.numberToNumber(7),"Convert 7");

	}
	/**
	* Test For Convert numbers 3
	*/
	@Test
	public void testIntToString() {
		GuiCalcs calc =new GuiCalcs();
		assertEquals("a",calc.numberToString(0),"Convert 0");
		assertEquals("b",calc.numberToString(1),"Convert 1");
		assertEquals("c",calc.numberToString(2),"Convert 2");
		assertEquals("d",calc.numberToString(3),"Convert 3");


	}
	/**
	* Test For Convert numbers 4
	*/
	@Test
	public void testIntToString2() {
		GuiCalcs calc =new GuiCalcs();

		assertEquals("e",calc.numberToString(4),"Convert 4");
		assertEquals("f",calc.numberToString(5),"Convert 5");
		assertEquals("g",calc.numberToString(6),"Convert 6");
		assertEquals("h",calc.numberToString(7),"Convert 7");

	}
}
