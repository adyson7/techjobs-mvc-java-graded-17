package org.launchcode.techjobsmvc.models;

public class CoreCompetency extends JobField {

    public CoreCompetency(String value) {
        super(value);
    }

    //method to get the name of the core competency
    public String getName() {
        return getValue();
    }

}
