package com.step.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ParkingLotTest {
    @Test
    void shouldParkCarInParkingLotHavingEmptySpace() {
        ParkingLot parkingLot = new ParkingLot(1);
        assertEquals(1, parkingLot.park(123));
    }

    @Test
    void shouldInformAttendantIfParkingLotFull() {
        ParkingLotListener attendant = mock(ParkingLotListener.class);
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.assign(attendant);
        parkingLot.park(234);
        verify(attendant).onFull(parkingLot.hashCode());
    }

    @Test
    void shouldInformManagerIfParkingLotIs80percentFull() {
        ParkingLotListener manager = mock(ParkingLotListener.class);
        ParkingLot parkingLot = new ParkingLot(5);
        parkingLot.assign(manager);
        parkingLot.park(1);
        parkingLot.park(2);
        parkingLot.park(3);
        parkingLot.park(4);
        verify(manager).onAlmostFull(parkingLot.hashCode());
    }

    @Test
    void shouldInformManagerIfParkingLotIsLessOccupied() {
        ParkingLotListener attendant = mock(ParkingLotListener.class);
        ParkingLot parkingLot = new ParkingLot(5);
        parkingLot.assign(attendant);
        parkingLot.park(1);
        verify(attendant).onLessOccupied(parkingLot.hashCode());
    }
}
