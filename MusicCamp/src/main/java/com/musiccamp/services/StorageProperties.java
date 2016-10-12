package com.musiccamp.services;

import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * 
 * @author Pushkar Kumar Kanikicherla 
 *
 */
@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "ExcelData\\"; 

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
