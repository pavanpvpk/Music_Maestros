package com.musiccamp.Exceptions;
/**
 * 
 * @author Pushkar Kumar Kanikicherla & Pavan Kumar Pedda Vakkalam
 *
 */
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
