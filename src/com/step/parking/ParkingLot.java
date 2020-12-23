package com.step.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private final List<Integer> parkingLot;
    private final int capacity;
    private final List<ParkingLotListener> parkingLotListeners;

    public ParkingLot(int capacity) {
        this.parkingLot = new ArrayList<>();
        this.capacity = capacity;
        this.parkingLotListeners = new ArrayList<>();
    }

    public int park(int carNumber) {
        if (!this.isFull()) {
            parkingLot.add(carNumber);
        }
        notifyListeners();
        return this.parkingLot.indexOf(carNumber) + 1;
    }

    public void assign(ParkingLotListener parkingLotListener) {
        this.parkingLotListeners.add(parkingLotListener);
    }

    private void notifyListeners() {
        parkingLotListeners.forEach(parkingLotListener -> {
            if (isFull()) {
                parkingLotListener.onFull(this.hashCode());
            }
            if (isAlmostFull()) {
                parkingLotListener.onAlmostFull(this.hashCode());
            }
            if (isLessOccupied()) {
                parkingLotListener.onLessOccupied(this.hashCode());
            }
        });
    }

    private boolean isLessOccupied() {
        return this.calculateOccupiedPercentage() <= 20;
    }

    private boolean isAlmostFull() {
        return this.calculateOccupiedPercentage() >= 80;
    }

    private boolean isFull() {
        return parkingLot.size() >= this.capacity;
    }

    private int calculateOccupiedPercentage() {
        return (parkingLot.size() * 100) / this.capacity;
    }
}
