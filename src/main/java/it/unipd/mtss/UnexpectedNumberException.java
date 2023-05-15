////////////////////////////////////////////////////////////////////
// RICCARDO MICHELON 2042341
// GIULIO BOTTACIN 2042340
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

class UnexpectedNumberException extends Exception{
    public UnexpectedNumberException() {
        super("Il convertitore accetta solo numeri interi compresi tra 0 e 1000.");
    }
}