package org.launchcode.techjobsmvc.models;

public class PositionType extends JobField {

    public PositionType(String value) {
        super(value);
    }

    @Override
    public String getName() {
        return getValue();
    }
}

