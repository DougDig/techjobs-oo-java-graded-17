package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job(){
        this.id = nextId;
        nextId++;
    }
//question what is the difference between this.id = nextId and id = nextId?
    public Job(String name, Employer employer, Location  location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.


    @Override
    public String toString() {
        String nameField = (name == null||name.isEmpty()?"Data not available":name);
        String employerField = (employer.getValue()==null || employer.getValue().isEmpty()?"Data not available":employer.toString());
        String locationField = (location.getValue()==null||location.getValue().isEmpty()?"Data not available":location.toString());
        String positionField = (positionType.getValue()==null || positionType.getValue().isEmpty()?"Data not available":positionType.toString());
        String coreField = (coreCompetency.getValue()==null||coreCompetency.getValue().isEmpty()?"Data not available":coreCompetency.toString());

        if (nameField.equals(employerField) && employerField.equals(locationField) && locationField.equals(positionField) && positionField.equals(coreField)){
            return "OOPS! This job does not seem to exist.";
        }
            String lineseperator = System.lineSeparator();
            return  System.lineSeparator() +
                    "ID:  _______ " + (id > 0 ? id : "Data not available") + System.lineSeparator() +
                    "Name: _______ " + nameField + System.lineSeparator() +
                    "Employer: _______ " + employerField + System.lineSeparator() +
                    "Location: _______ " + locationField + System.lineSeparator() +
                    "Position Type: _______ " + positionField + System.lineSeparator() +
                    "Core Competency: _______ " + coreField +
                    System.lineSeparator();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
