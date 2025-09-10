package org.example;

public class Valet {
    private String valetId;
    private String name;
    private String skillSet;
    private Facility assignedFacility;

    public Valet(String valetId, String name, String skillSet) {
        this.valetId = valetId;
        this.name = name;
        this.skillSet = skillSet;
    }

    public void assignFacility(Facility facility) {
        this.assignedFacility = facility;
    }

    public Facility getAssignedFacility() { return assignedFacility; }
    public String getValetId() { return valetId; }
    public String getName() { return name; }
    public String getSkillSet() { return skillSet; };
}
