package com.step.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private final List<Integer> parkingLot;
    private final int capacity;

    public ParkingLot(int capacity) {
        this.parkingLot = new ArrayList<>();
        this.capacity = capacity;
    }

    public boolean park(int carNumber) {
        if (this.isFull()) return false;
        return parkingLot.add(carNumber);
    }

    public boolean isFull() {
        return parkingLot.size() >= this.capacity;
    }
}
