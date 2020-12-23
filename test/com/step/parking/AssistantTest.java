package com.step.parking;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AssistantTest {

    @Test
    void shouldUpdateDisplayWhenParkingLotIsFull() {
        Display display = mock(Display.class);
        Assistant assistant = new Assistant(display);
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.assign(assistant);
        parkingLot.park(123);
        verify(display).update(parkingLot.hashCode(), ParkingLotStatus.FULL_OCCUPIED);
    }
}