package com.step.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private final List<Integer> parkingLot;
    private final int capacity;
    private ParkingLotListner parkingLotListner;

    public ParkingLot(int capacity) {
        this.parkingLot = new ArrayList<>();
        this.capacity = capacity;
    }

    public int park(int carNumber) {
        if (!this.isFull()) {
            parkingLot.add(carNumber);
        }
        if (this.isFull() && this.hasAssistant()) {
            parkingLotListner.onStatusUpdate(this, ParkingLotStatus.FULL);
        }
        if (this.isEightyPercentFull() && this.hasAssistant()) {
            parkingLotListner.onStatusUpdate(this, ParkingLotStatus.EIGHTY_PERCENT_FULL);
        }
        return this.parkingLot.indexOf(carNumber) + 1;
    }

    public void assign(ParkingLotListner parkingLotListner) {
        this.parkingLotListner = parkingLotListner;
    }

    private boolean hasAssistant() {
        return this.parkingLotListner != null;
    }

    private boolean isFull() {
        return parkingLot.size() >= this.capacity;
    }

    private boolean isEightyPercentFull() {
        return (parkingLot.size() * 100) / this.capacity == 80;
    }
}
