package com.step.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private final List<Integer> parkingLot;
    private final int capacity;
    private final Attendant attendant;

    public ParkingLot(int capacity, Attendant attendant) {
        this.parkingLot = new ArrayList<>();
        this.capacity = capacity;
        this.attendant = attendant;
    }

    public int park(int carNumber) {
        parkingLot.add(carNumber);
        if (this.isFull()) {
            attendant.informFull(this);
        }
        return this.parkingLot.indexOf(carNumber) + 1;
    }

    private boolean isFull() {
        return parkingLot.size() >= this.capacity;
    }
}
