////////////////////////////////////////////////////////////////////
// RICCARDO MICHELON 2042341
// GIULIO BOTTACIN 2042340
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

class UnexpectedRomanException extends Exception{
    public UnexpectedRomanException(char romanChar) {
        super("Il numero romano contiene lettere non accettate: " + romanChar);
    }
}