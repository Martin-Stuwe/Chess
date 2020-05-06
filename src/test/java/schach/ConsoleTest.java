package schach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;


public class ConsoleTest {

	@Test
	public void testConsole() {
		Console TC = new Console();	
		ByteArrayInputStream in= new ByteArrayInputStream ("Test".getBytes());
		System.setIn(in);
		int n = in.available();
		byte[] bytes = new byte[n];
		in.read(bytes, 0, n);
		String s = new String(bytes); 
		assertEquals("Test" , s, "Input Erfolgreich");
		}
}
