package com.step.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ParkingLotTest {
    @Test
    void shouldParkCarInParkingLotHavingEmptySpace() {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot = new ParkingLot(1, attendant);
        assertEquals(1,parkingLot.park(123));
    }

    @Test
    void shouldInformAttendantIfParkingLotFull() {
        Attendant attendantMock = mock(Attendant.class);
        ParkingLot parkingLot = new ParkingLot(1, attendantMock);
        parkingLot.park(234);
        verify(attendantMock).informFull(parkingLot);
    }
}
