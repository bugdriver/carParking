package com.step.parking;

public class Assistant {
    private final Display display;

    public Assistant() {
        this.display = Display.getDisplay();
    }

    public void informFull(ParkingLot parkingLot) {
        this.display.update(parkingLot, ParkingLotStatus.FULL);
    }
}