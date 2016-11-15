package com.musiccamp.Exceptions;
/**
 * 
 * @author Pushkar Kumar Kanikicherla
 *
 */
public class CellDataEmptyException extends RuntimeException{
    public CellDataEmptyException(String message) {
        super(message);
    }

    public CellDataEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
