package org.launchcode.techjobsmvc.models;

public class Location extends JobField {

    public Location(String value) {
        super(value);
    }
    @Override
    public String getName() {
        return getValue();
    }

}


