package schach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExampleTest {
    @Test
    public void testFoo() {
        Example example = new Example(23);
        assertEquals(42, example.foo(12), "foo performs a correct computation");
    }
}
