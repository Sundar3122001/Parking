package org.example;

import java.util.*;

public class MultiVehicleParkingSystem {

    private final Map<String, Facility> facilities = new HashMap<>();
    private final Map<String, User> users = new HashMap<>();
    private final TheftTrackingSystem theftSystem = new TheftTrackingSystem();
    private final ValetManagementSystem valetSystem = new ValetManagementSystem();

    // --- Facility Management ---
    public void addFacility(Facility f) {
        if(f != null) {
            facilities.put(f.getName(), f);
        }
    }

    public Facility getFacility(String name) {
        return facilities.get(name);
    }

    // --- User Management ---
    public void registerUser(User u) {
        if(u != null) {
            users.put(u.getUserId(), u);
        }
    }

    public boolean verifyIdentity(String userId) {
        User u = users.get(userId);
        return u != null && u.verifyIdentity();
    }

    // --- Vehicle Management ---
    public void parkVehicle(Vehicle v, String facilityName) {
        Facility f = facilities.get(facilityName);
        if(f != null) {
            f.parkVehicle(v);
        } else {
            System.out.println("Facility not found: " + facilityName);
        }
    }

    public void releaseVehicle(String vehicleId, String facilityName) {
        Facility f = facilities.get(facilityName);
        if(f != null) {
            f.releaseVehicle(vehicleId);
        } else {
            System.out.println("Facility not found: " + facilityName);
        }
    }

    public void showAvailability() {
        facilities.values().forEach(Facility::showAvailability);
    }

    public void reportTheft(String vehicleId, String facilityName) {
        Facility f = facilities.get(facilityName);
        if(f != null && f.hasVehicle(vehicleId)) {
            theftSystem.reportVehicleTheft(vehicleId);
        } else {
            System.out.println("Vehicle not found in facility: " + facilityName);
        }
    }

    // --- Valet Management ---
    public void addValet(Valet valet) {
        if(valet != null) {
            valetSystem.addValet(valet);
        }
    }

    public void assignValetToFacility(String valetId, String facilityName) {
        Facility f = facilities.get(facilityName);
        if(f != null) {
            valetSystem.assignValetToFacility(valetId, f);
        } else {
            System.out.println("Facility not found: " + facilityName);
        }
    }

    public void showValetsForFacility(String facilityName) {
        Facility f = facilities.get(facilityName);
        if(f != null) {
            List<Valet> valets = valetSystem.getValetsForFacility(f);
            System.out.println("Valets at " + facilityName + ":");
            if(valets.isEmpty()) {
                System.out.println("  None assigned");
            } else {
                valets.forEach(v -> System.out.println("  " + v.getName() + " (ID: " + v.getValetId() + ", Skill: " + v.getSkillSet() + ")"));
            }
        } else {
            System.out.println("Facility not found: " + facilityName);
        }
    }

    public ValetManagementSystem getValetSystem() {
        return valetSystem;
    }
}
