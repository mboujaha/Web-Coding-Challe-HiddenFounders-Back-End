package com.medo.shopsv1.models;

import java.util.ArrayList;

public class Location {

    private String type;

    private ArrayList<String> coordinates = new ArrayList<String>(2);

    public Location() {
    }

    public Location(String type, ArrayList<String> coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<String> coordinates) {
        this.coordinates = coordinates;
    }
}
