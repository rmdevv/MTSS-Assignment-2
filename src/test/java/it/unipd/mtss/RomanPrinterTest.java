package it.unipd.mtss;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockedStatic;

public class RomanPrinterTest {

    @Test
    public void testPrintEmptyRoman() throws UnexpectedNumberException, UnexpectedRomanException {
        try(MockedStatic<IntegerToRoman> utilities=Mockito.mockStatic(IntegerToRoman.class)){
            utilities.when(() -> IntegerToRoman.convert(0)).thenReturn("");
            String expected = "";

            assertEquals(RomanPrinter.print(0), expected);
        }
    }

    @Test(expected = UnexpectedRomanException.class)
    public void testUnexpectedRomanChar() throws UnexpectedNumberException, UnexpectedRomanException {
        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(2)).thenReturn("XT");
            RomanPrinter.print(2);
        }
    }

    @Test
    public void testPrintI() throws UnexpectedNumberException, UnexpectedRomanException {
        try(MockedStatic<IntegerToRoman> utilities=Mockito.mockStatic(IntegerToRoman.class)){
            utilities.when(()->IntegerToRoman.convert(1)).thenReturn("I");
            String expected = new String(
            " _____ \n"+ 
            "|_   _|\n"+ 
            "  | |  \n"+ 
            "  | |  \n"+ 
            " _| |_ \n"+ 
            "|_____|\n"   );
            assertEquals(RomanPrinter.print(1), expected);
        }
    }

    @Test
    public void testPrintV() throws UnexpectedNumberException, UnexpectedRomanException{
        try(MockedStatic<IntegerToRoman> utilities=Mockito.mockStatic(IntegerToRoman.class)){
            utilities.when(()->IntegerToRoman.convert(5)).thenReturn("V");
            String expected = new String( 
            "__      __\n"  + 
            "\\ \\    / /\n"+ 
            " \\ \\  / / \n"+ 
            "  \\ \\/ /  \n"+ 
            "   \\  /   \n" + 
            "    \\/    \n"    );
            assertEquals(RomanPrinter.print(5), expected);
        }
    }

    @Test
    public void testPrintX() throws UnexpectedNumberException, UnexpectedRomanException {
        try(MockedStatic<IntegerToRoman> utilities=Mockito.mockStatic(IntegerToRoman.class)){
            utilities.when(()->IntegerToRoman.convert(10)).thenReturn("X");
            String expected = new String(
            "__    __\n"+ 
            "\\ \\  / /\n"+
            " \\ \\/ / \n"+ 
            "  >  <  \n"+
            " / /\\ \\ \n"+
             "/_/  \\_\\\n" );
            assertEquals(RomanPrinter.print(10), expected);
        }
    }

    @Test
    public void testPrintL() throws UnexpectedNumberException, UnexpectedRomanException {
        try(MockedStatic<IntegerToRoman> utilities=Mockito.mockStatic(IntegerToRoman.class)){
            utilities.when(()->IntegerToRoman.convert(50)).thenReturn("L");
            String expected = new String(
            " _      \n"+
            "| |     \n"+
            "| |     \n"+ 
            "| |     \n"+ 
            "| |____ \n"+ 
            "|______|\n");
            assertEquals(RomanPrinter.print(50), expected);
        }
    }

    @Test
    public void testPrintC() throws UnexpectedNumberException, UnexpectedRomanException {
        try(MockedStatic<IntegerToRoman> utilities=Mockito.mockStatic(IntegerToRoman.class)){
            utilities.when(()->IntegerToRoman.convert(100)).thenReturn("C");
            String expected = new String(
            "  _____ \n"+
            " / ____|\n"+
            "| |     \n"+
            "| |     \n"+
            "| |____ \n"+
            " \\_____|\n");
            assertEquals(RomanPrinter.print(100), expected);
        }
    }

    @Test
    public void testPrintD() throws UnexpectedNumberException, UnexpectedRomanException {
        try(MockedStatic<IntegerToRoman> utilities=Mockito.mockStatic(IntegerToRoman.class)){
            utilities.when(()->IntegerToRoman.convert(500)).thenReturn("D");
            String expected = new String(
            " _____  \n" +
            "|  __ \\ \n"+
            "| |  | |\n" +
            "| |  | |\n" +
            "| |__| |\n" +
            "|_____/ \n"    );
            assertEquals(RomanPrinter.print(500), expected);
        }
    }
    
    @Test
    public void testPrintM() throws UnexpectedNumberException, UnexpectedRomanException {
        try(MockedStatic<IntegerToRoman> utilities=Mockito.mockStatic(IntegerToRoman.class)){
            utilities.when(()->IntegerToRoman.convert(1000)).thenReturn("M");
            String expected = new String(
            " __  __\n" +
            "|  \\/  |\n"+ 
            "| \\  / |\n"+ 
            "| |\\/| |\n"+ 
            "| |  | |\n" + 
            "|_|  |_|\n"    );
            assertEquals(RomanPrinter.print(1000), expected);
        }
    }

    @Test
    public void testPrint999()
            throws UnexpectedNumberException, UnexpectedRomanException {
        int intNum = 999;
        String expected = new String(
                "  _____ " + " __  __" + "__    __"   + "  _____ " + " _____ " +"__    __\n"+ 
                " / ____|" + "|  \\/  |"+ "\\ \\  / /" + " / ____|" + "|_   _|" +"\\ \\  / /\n"+
                "| |     " + "| \\  / |"+ " \\ \\/ / " + "| |     " + "  | |  " +" \\ \\/ / \n"+
                "| |     " + "| |\\/| |"+ "  >  <  "   + "| |     " + "  | |  " +"  >  <  \n"+
                "| |____ " + "| |  | |" + " / /\\ \\ " + "| |____ " + " _| |_ " +" / /\\ \\ \n"+
                " \\_____|"+ "|_|  |_|" + "/_/  \\_\\" + " \\_____|"+ "|_____|" + "/_/  \\_\\\n"
        );

        String asciiArt = RomanPrinter.print(intNum);

        assertEquals(expected, asciiArt);
    }

    @Test
    public void testPrint138() throws UnexpectedNumberException, UnexpectedRomanException {
        int intNum = 138;
        String expected = new String(
            "  _____ " + "__    __"   + "__    __"  + "__    __"  +"__      __"  +" _____ "+" _____ "+" _____ \n"+
            " / ____|" + "\\ \\  / /" + "\\ \\  / /"+ "\\ \\  / /"+"\\ \\    / /"+"|_   _|"+"|_   _|"+"|_   _|\n"+
            "| |     " + " \\ \\/ / " + " \\ \\/ / "+ " \\ \\/ / "+" \\ \\  / / "+"  | |  "+"  | |  "+"  | |  \n"+
            "| |     " + "  >  <  "   + "  >  <  "  + "  >  <  "  +"  \\ \\/ /  "+"  | |  "+"  | |  "+"  | |  \n"+
            "| |____ " + " / /\\ \\ " + " / /\\ \\ "+ " / /\\ \\ "+"   \\  /   " +" _| |_ "+" _| |_ "+" _| |_ \n"+
            " \\_____|"+ "/_/  \\_\\" + "/_/  \\_\\"+ "/_/  \\_\\"+"    \\/    " +"|_____|"+"|_____|"+"|_____|\n"   
                
        );

        String asciiArt = RomanPrinter.print(intNum);

        assertEquals(expected, asciiArt);
    }

    @Test
    public void testPrint696() throws UnexpectedNumberException, UnexpectedRomanException {
        int intNum = 696;
        String expected = new String(
            " _____  " + "  _____ " + "__    __"   +"  _____ " +"__      __"  +" _____ \n"+
            "|  __ \\ "+ " / ____|" + "\\ \\  / /" +" / ____|" +"\\ \\    / /"+"|_   _|\n"+
            "| |  | |" + "| |     " + " \\ \\/ / " +"| |     " +" \\ \\  / / "+"  | |  \n"+
            "| |  | |" + "| |     " + "  >  <  "   +"| |     " +"  \\ \\/ /  "+"  | |  \n"+
            "| |__| |" + "| |____ " + " / /\\ \\ " +"| |____ " +"   \\  /   " +" _| |_ \n"+
            "|_____/ " + " \\_____|"+ "/_/  \\_\\" +" \\_____|"+"    \\/    " +"|_____|\n"
        );

        String asciiArt = RomanPrinter.print(intNum);

        assertEquals(expected, asciiArt);
    }
}