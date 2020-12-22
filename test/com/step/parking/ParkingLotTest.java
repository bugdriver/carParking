package com.step.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ParkingLotTest {
    @Test
    void shouldParkCarInParkingLotHavingEmptySpace() {
        ParkingLot parkingLot = new ParkingLot(1);
        assertEquals(1,parkingLot.park(123));
    }

    @Test
    void shouldInformAttendantIfParkingLotFull() {
        ParkingLotListner parkingLotListnerMock = mock(ParkingLotListner.class);
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.assign(parkingLotListnerMock);
        parkingLot.park(234);
        verify(parkingLotListnerMock).onFull(parkingLot);
    }
}
