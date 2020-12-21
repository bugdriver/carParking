package com.step.parking;

import java.util.HashMap;
import java.util.Map;

public class Display {
    private final Map<ParkingLot, ParkingLotStatus> parkingLotLogs;
    private static Display displayInstance = null;

    private Display() {
        this.parkingLotLogs = new HashMap<>();
    }

    public static Display getDisplay(){
        if(displayInstance == null){
            displayInstance = new Display();
        }
        return displayInstance;
    }

    public void update(ParkingLot parkingLot, ParkingLotStatus status) {
        this.parkingLotLogs.put(parkingLot, status);
    }

    public int getNumberOfLogs(){
        return parkingLotLogs.size();
    }
}
