////////////////////////////////////////////////////////////////////
// RICCARDO MICHELON 2042341
// GIULIO BOTTACIN 2042340
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

class IntegerToRoman {

    private static final int[] VALUES = 
    { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    private static final String[] ROMAN_LETTERS = 
    { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    
    public static String convert(int num) throws UnexpectedNumberException {
        if (num < 0 || num > 1000) {
            throw new UnexpectedNumberException();   
        }
        
        String romanNum = "";
        
        for (int i = 0; i < VALUES.length; i++) {
            while (num >= VALUES[i]) {
                romanNum += ROMAN_LETTERS[i];
                num -= VALUES[i];
            }
        }
        return romanNum;
    }
}