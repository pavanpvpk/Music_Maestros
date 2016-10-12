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
    private String location = "C:\\Users\\S525021\\Downloads\\Masters\\Sem4\\GDP\\Music_Maestros\\MusicCamp\\ExcelData\\";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
