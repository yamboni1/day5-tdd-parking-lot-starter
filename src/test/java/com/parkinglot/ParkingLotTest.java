package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    void should_return_parking_ticket_when_park_given_parking_lot_a_car() {
    //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //when
        ParkingLotTicket parkingLotTicket = parkingLot.park(car);

        //then
        assertEquals(parkingLotTicket, car.getParkingLotTicket());
    }
}
