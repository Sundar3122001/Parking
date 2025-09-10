package org.example;

import java.util.Date;

public abstract class Vehicle {
    private String vehicleId;
    private Date entryTime;
    private Date exitTime;
    private String insurancePolicyId;

    public Vehicle(String vehicleId) {
        this.vehicleId = vehicleId;
        this.entryTime = new Date();
    }

    public void assignInsurance(String policyId) {
        this.insurancePolicyId = policyId;
    }

    public String getVehicleId() {
        return vehicleId;
    }
}
