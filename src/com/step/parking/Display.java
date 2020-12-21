package com.step.parking;

import java.util.HashMap;
import java.util.Map;

public class Display {
    private final Map<ParkingLot, ParkingLotStatus> parkingLotStatus;

    public Display() {
        this.parkingLotStatus=new HashMap<>();
    }

    public void update(ParkingLot parkingLot, ParkingLotStatus status) {
        this.parkingLotStatus.put(parkingLot, status);
    }
}
