package com.step.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssistantTest {

    @Test
    void shouldUpdateDisplayWhenParkingLotIsFull() {
        Assistant assistant = new Assistant();
        Display display = Display.getDisplay();
        ParkingLot parkingLot = new ParkingLot(1);
        assistant.informFull(parkingLot);
        assertEquals(1,display.getNumberOfLogs());
    }
}