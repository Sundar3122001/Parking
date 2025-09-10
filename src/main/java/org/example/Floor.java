package org.example;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int floorNumber;
    private int width;
    private int height;
    private List<ParkingSlot> parkingSlots;
    private boolean isSecurityFloor;

    public Floor(int floorNumber, int width, int height, int capacity, boolean isSecurityFloor) {
        this.floorNumber = floorNumber;
        this.width = width;
        this.height = height;
        this.isSecurityFloor = isSecurityFloor;
        this.parkingSlots = new ArrayList<>();
        for(int i = 1; i <= capacity; i++) {
            parkingSlots.add(new ParkingSlot(i));
        }
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public int getAvailableSlots() {
        int count = 0;
        for(ParkingSlot slot : parkingSlots) {
            if(slot.isAvailable()) count++;
        }
        return count;
    }

    public boolean isSecurityFloor() {
        return isSecurityFloor;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
