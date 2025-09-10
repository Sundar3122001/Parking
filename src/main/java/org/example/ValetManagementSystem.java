package org.example;

import java.util.*;

public class ValetManagementSystem {
    private List<Valet> availableValets = new ArrayList<>();
    private Map<Facility, List<Valet>> assignedValets = new HashMap<>();

    public void addValet(Valet valet) {
        availableValets.add(valet);
        System.out.println("Valet added: " + valet.getName());
    }

    public void assignValetToFacility(String valetId, Facility facility) {
        Valet found = null;
        for(Valet v : availableValets) {
            if(v.getValetId().equals(valetId)) { found = v; break; }
        }
        if(found != null) {
            found.assignFacility(facility);
            assignedValets.computeIfAbsent(facility, k -> new ArrayList<>()).add(found);
            availableValets.remove(found);
            System.out.println("Valet " + found.getName() + " assigned to " + facility.getName());
        } else {
            System.out.println("Valet not found: " + valetId);
        }
    }

    public List<Valet> getValetsForFacility(Facility facility) {
        return assignedValets.getOrDefault(facility, new ArrayList<>());
    }

    public void showAvailableValets() {
        System.out.println("Available Valets:");
        for (Valet v : availableValets) {
            System.out.println("- " + v.getValetId() + " (" + v.getName() + ", Skill:" + v.getSkillSet() + "))");
        }
    }

}
