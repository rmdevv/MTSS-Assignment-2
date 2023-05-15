package it.unipd.mtss;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedIntegerToRomanTest {
    
    private int input;
    private String expectedOutput;

    public ParameterizedIntegerToRomanTest(String input, String expectedOutput) {
        this.input = Integer.parseInt(input);
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<String[]> testConditions() {
        String expectedOutputs[][] = {
                { "1", "I" },
                { "2", "II" },
                { "3", "III" },
                { "4", "IV" },
                { "5", "V" },
                { "6", "VI" },
                { "7", "VII" },
                { "8", "VIII" },
                { "9", "IX" },
                { "10", "X" },
                { "11", "XI" },
                { "12", "XII" },
                { "13", "XIII" },
                { "14", "XIV" },
                { "15", "XV" },
                { "16", "XVI" },
                { "17", "XVII" },
                { "18", "XVIII" },
                { "19", "XIX" },
                { "20", "XX" },
                { "30", "XXX" },
                { "40", "XL" },
                { "44", "XLIV" },
                { "49", "XLIX" },
                { "50", "L" },
                { "60", "LX" },
                { "70", "LXX" },
                { "80", "LXXX" },
                { "89", "LXXXIX" },
                { "90", "XC" },
                { "99", "XCIX" },
                { "100", "C" },
                { "178", "CLXXVIII" },
                { "200", "CC" },
                { "300", "CCC" },
                { "378", "CCCLXXVIII" },
                { "400", "CD" },
                { "500", "D" },
                { "600", "DC" },
                { "650", "CCCCCLLXXXXX" },
                { "700", "DCC" },
                { "777", "DCCLXXVII" },
                { "800", "DCCC" },
                { "888", "DCCCLXXXVIII" },
                { "900", "CM" },
                { "984", "CMLXXXIV" },
                { "999", "CMXCIX"},
                { "1000", "M" }
        };
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void testIntegersToRomans() throws UnexpectedNumberException, UnexpectedRomanException {
        int intNum = input;
        String romanNum = IntegerToRoman.convert(intNum);
        assertEquals(expectedOutput, romanNum);
    }
}