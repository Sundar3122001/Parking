package org.example;

import java.util.ArrayList;
import java.util.List;

public class TheftTrackingSystem {
    private List<String> reportedVehicles = new ArrayList<>();

    public void reportVehicleTheft(String vehicleId) {
        reportedVehicles.add(vehicleId);
        System.out.println("Law enforcement notified for theft of vehicle " + vehicleId);
    }

    public List<String> getReportedVehicles() {
        return reportedVehicles;
    }
}
