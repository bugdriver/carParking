package com.step.parking;

public class Assistant implements ParkingLotListener {
    private final Display display;

    public Assistant(Display display) {
        this.display = display;
    }

    @Override
    public void onFull(int parkingLotId) {
        this.display.update(parkingLotId, ParkingLotStatus.FULL_OCCUPIED);
    }

    @Override
    public void onAlmostFull(int parkingLotId) {

    }

    @Override
    public void onLessOccupied(int parkingLotId) {

    }
}