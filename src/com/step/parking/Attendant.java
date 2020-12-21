package com.step.parking;

public class Attendant {
    private final Display display;

    public Attendant() {
        this.display = new Display();
    }

    public void informFull(ParkingLot parkingLot) {
        this.display.update(parkingLot, ParkingLotStatus.FULL);
    }
}