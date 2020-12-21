package com.step.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private final List<Integer> parkingLot;
    private final int capacity;
    private Assistant assistant;

    public ParkingLot(int capacity) {
        this.parkingLot = new ArrayList<>();
        this.capacity = capacity;
    }

    public int park(int carNumber) {
        if (!this.isFull()) {
            parkingLot.add(carNumber);
        }
        if (this.isFull() && this.hasAssistant()) {
            assistant.informFull(this);
        }
        return this.parkingLot.indexOf(carNumber) + 1;
    }

    public void assign(Assistant assistant){
       this.assistant = assistant;
    }

    private boolean hasAssistant(){
        return this.assistant != null;
    }

    private boolean isFull() {
        return parkingLot.size() >= this.capacity;
    }
}
