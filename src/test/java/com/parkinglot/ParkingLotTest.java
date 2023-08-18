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
        assertNotNull(parkingLotTicket);
    }
    @Test
    void should_return_the_car_when_fetch_the_car_given_parking_lot_with_parked_car_and_a_parkingLotTicket() {
    //given
        ParkingLot parkingLot = new ParkingLot();
        Car parkedCar = new Car();

    //when
        ParkingLotTicket parkingLotTicket = parkingLot.park(parkedCar);
        Car fetchedCar = parkingLot.fetch(parkingLotTicket);

        //then
        assertEquals(parkedCar,fetchedCar);
    }

}
