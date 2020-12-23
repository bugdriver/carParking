package com.step.parking;

public interface ParkingLotListener {
    void onFull(int parkingLotId);

    void onAlmostFull(int parkingLotId);

    void onLessOccupied(int parkingLotId);
}
