package com.step.parking;

public interface ParkingLotListener {
    void onStatusUpdate(ParkingLot parkingLot, Integer status);
}
