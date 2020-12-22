package com.step.parking;

public class ParkingLotListner implements ParkingLotListener {
    private final Display display;

    public ParkingLotListner(Display display) {
        this.display = display;
    }

    @Override
    public void onStatusUpdate(ParkingLot parkingLot,ParkingLotStatus status) {
        this.display.update(parkingLot, status);
    }
}