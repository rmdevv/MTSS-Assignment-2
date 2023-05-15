////////////////////////////////////////////////////////////////////
// RICCARDO MICHELON 2042341
// GIULIO BOTTACIN 2042340
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import java.util.HashMap;

public class RomanPrinter {

    private static HashMap<Character, String[]> asciiart = null;
    static {
        asciiart = new HashMap<Character, String[]>();
        asciiart.put('I', new String[] {
            " _____ ",
            "|_   _|",
            "  | |  ",
            "  | |  ",
            " _| |_ ",
            "|_____|"
        });
            asciiart.put('V', new String[] {
            "__      __",
            "\\ \\    / /",
            " \\ \\  / / ",
            "  \\ \\/ /  ",
            "   \\  /   ",
            "    \\/    "
        });
            asciiart.put('X', new String[] {
            "__    __",
            "\\ \\  / /",
            " \\ \\/ / ",
            "  >  <  ",
            " / /\\ \\ ",
            "/_/  \\_\\"
        });
            asciiart.put('L', new String[] {
            " _      ",
            "| |     ",
            "| |     ",
            "| |     ",
            "| |____ ",
            "|______|"
        });
            asciiart.put('C', new String[] {
            "  _____ ",
            " / ____|",
            "| |     ",
            "| |     ",
            "| |____ ",
            " \\_____|"
        });
            asciiart.put('D', new String[] {
            " _____  ",
            "|  __ \\ ",
            "| |  | |",
            "| |  | |",
            "| |__| |",
            "|_____/ "
        });
            asciiart.put('M', new String[] {
            " __  __",
            "|  \\/  |",
            "| \\  / |",
            "| |\\/| |",
            "| |  | |",
            "|_|  |_|"
        });
    }

    public static String print(int num) throws UnexpectedNumberException, UnexpectedRomanException {
        return printAsciiArt(IntegerToRoman.convert(num));
    }
  
    private static String printAsciiArt(String romanNumber) throws UnexpectedRomanException {

        StringBuilder romanAsciiart = new StringBuilder();

        if(romanNumber != ""){
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < romanNumber.length(); j++) {
                    char currentChar = romanNumber.charAt(j);

                    if (!asciiart.containsKey(currentChar)) {
                        throw new UnexpectedRomanException(currentChar);
                    }

                    romanAsciiart.append(asciiart.get(currentChar)[i]);
                }
                romanAsciiart.append('\n');
            }
        }

        return romanAsciiart.toString();
    }
}