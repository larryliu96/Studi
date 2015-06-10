package com.studi.studi.resources;

/**
 * Created by kevin on 2/28/15.
 */
public class User {

    private String id;
    private String name;
    private double latitude;
    private double longitude;
    private String[] subjects;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String[] getSubjects() {
        return subjects;
    }

}
