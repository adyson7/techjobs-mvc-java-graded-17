package org.launchcode.techjobsmvc.models;

public class Employer extends JobField {

    public Employer(String value) {
        super(value);
    }

    @Override
    public String getName() {
        return getValue();
    }

    public String getValue() {
        return super.getValue();
    }
}

