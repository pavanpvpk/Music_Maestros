package com.musiccamp.Exceptions;

/**
 * 
 * @author Pushkar Kumar Kanikicherla
 *
 */
public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}