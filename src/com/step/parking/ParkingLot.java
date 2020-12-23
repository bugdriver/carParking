package com.step.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private final List<Integer> parkingLot;
    private final int capacity;
    private final Map<ParkingLotListener, Integer> parkingLotListeners;

    public ParkingLot(int capacity) {
        this.parkingLot = new ArrayList<>();
        this.capacity = capacity;
        this.parkingLotListeners = new HashMap<>();
    }

    public int park(int carNumber) {
        if (!this.isFull()) {
            parkingLot.add(carNumber);
        }
        notifyListeners();
        return this.parkingLot.indexOf(carNumber) + 1;
    }

    public void assign(ParkingLotListener parkingLotListener, int thresholdPercentage) {
        this.parkingLotListeners.put(parkingLotListener, thresholdPercentage);
    }

    private void notifyListeners() {
        parkingLotListeners.forEach((parkingLotListener, thresholdPercentage) -> {
            if (this.isReachedPercent(thresholdPercentage)) {
                parkingLotListener.onStatusUpdate(this, thresholdPercentage);
            }
        });
    }

    private boolean isFull() {
        return parkingLot.size() >= this.capacity;
    }

    private boolean isReachedPercent(int percentage) {
        return (parkingLot.size() * 100) / this.capacity == percentage;
    }
}
