package org.example;

public class ParkingSlot {
    private int slotId;
    private boolean isAvailable;
    private Vehicle vehicle;

    public ParkingSlot(int slotId) {
        this.slotId = slotId;
        this.isAvailable = true;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isAvailable = false;
        System.out.println(vehicle.getVehicleId() + " parked in slot " + slotId);
    }

    public void releaseSlot() {
        if(vehicle != null) {
            System.out.println("Vehicle " + vehicle.getVehicleId() + " released from slot " + slotId);
            vehicle = null;
        }
        isAvailable = true;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
