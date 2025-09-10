package org.example;

import java.util.ArrayList;
import java.util.List;

public class Facility {
    private String name;
    private String type;
    private int floors;
    private List<ParkingSlot> slots;

    public Facility(String name, String type, int floors, int area, int totalSlots) {
        this.name = name;
        this.type = type;
        this.floors = floors;
        this.slots = new ArrayList<>();
        for(int i=1; i<=totalSlots; i++) {
            slots.add(new ParkingSlot(i));
        }
    }

    public String getName() { return name; }
    public String getType() { return type; }

    public void parkVehicle(Vehicle v) {
        for(ParkingSlot slot : slots) {
            if(slot.isAvailable()) {
                slot.assignVehicle(v);
                System.out.println(v.getVehicleId() + " parked in facility " + name);
                return;
            }
        }
        System.out.println("No slots available in " + name);
    }

    public void releaseVehicle(String vehicleId) {
        for(ParkingSlot slot : slots) {
            if(slot.getVehicle() != null && slot.getVehicle().getVehicleId().equals(vehicleId)) {
                slot.releaseSlot();
                System.out.println("Vehicle " + vehicleId + " released from facility " + name);
                return;
            }
        }
        System.out.println("Vehicle " + vehicleId + " not found in " + name);
    }

    public boolean hasVehicle(String vehicleId) {
        for(ParkingSlot slot : slots) {
            if(slot.getVehicle() != null && slot.getVehicle().getVehicleId().equals(vehicleId)) return true;
        }
        return false;
    }

    public void showAvailability() {
        long available = slots.stream().filter(ParkingSlot::isAvailable).count();
        System.out.println("Facility " + name + " (" + type + "): " + available + " slots available.");
    }
}
