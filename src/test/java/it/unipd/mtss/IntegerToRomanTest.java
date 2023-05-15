package it.unipd.mtss;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IntegerToRomanTest {

    @Test(expected = UnexpectedNumberException.class)
    public void testIntUnder0() throws UnexpectedNumberException {
        int intNum = -1;

        IntegerToRoman.convert(intNum);
    }

    @Test(expected = UnexpectedNumberException.class)
    public void testIntAbove1000() throws UnexpectedNumberException {
        int intNum = 1001;

        IntegerToRoman.convert(intNum);
    }

    @Test
    public void testInt0() throws UnexpectedNumberException {
        int intNum = 0;
        String expected = "";

        String romanNum = IntegerToRoman.convert(intNum);

        assertEquals(expected, romanNum);
    }
}