package com.step.parking;

public class Assistant implements ParkingLotListener {
    private final Display display;

    public Assistant(Display display) {
        this.display = display;
    }

    @Override
    public void onStatusUpdate(ParkingLot parkingLot, Integer filledPercentage) {
        this.display.update(parkingLot, filledPercentage);
    }
}