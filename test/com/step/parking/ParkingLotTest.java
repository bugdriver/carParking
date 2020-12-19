package com.step.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void shouldParkCarInParkingLotHavingEmptySpace() {
        ParkingLot parkingLot = new ParkingLot(1);
        assertTrue(parkingLot.park(123));
    }

    @Test
    void shouldNotParkCarInParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(234);
        assertFalse(parkingLot.park(123));
    }

    @Test
    void shouldVerifyIfParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(123);
        assertTrue(parkingLot.isFull());
    }

    @Test
    void shouldVerifyIfParkingLotIsNotFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        assertFalse(parkingLot.isFull());
    }
}