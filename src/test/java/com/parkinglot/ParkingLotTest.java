package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(parkedCar, fetchedCar);
    }

    @Test
    void should_return_the_correct_car_when_fetch_the_car_given_parking_lot_and_two_cars() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car firstParkedCar = new Car();
        Car secondParkedCar = new Car();

        //when
        ParkingLotTicket firstParkingLotTicket = parkingLot.park(firstParkedCar);
        ParkingLotTicket secondParkingLotTicket = parkingLot.park(secondParkedCar);
        Car fetchedFirstCar = parkingLot.fetch(firstParkingLotTicket);
        Car fetchedSecondCar = parkingLot.fetch(secondParkingLotTicket);
        //then
        assertEquals(fetchedFirstCar, firstParkedCar);
        assertEquals(fetchedSecondCar, secondParkedCar);
    }

    @Test
    void should_return_nothing_when_fetch_the_car_given_parking_lot_and_wrong_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingLotTicket parkingLotTicket = new ParkingLotTicket();
        //when
        Car notAParkedCar = parkingLot.fetch(parkingLotTicket);
        //then
        assertNull(notAParkedCar);
    }

    @Test
    void should_return_nothing_when_fetch_given_parking_lot_and_used_parkingLot_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car parkedCar = new Car();
        ParkingLotTicket usedParkingTicket = parkingLot.park(parkedCar);
        parkingLot.fetch(usedParkingTicket);
        //when
        Car fetchCarAgain = parkingLot.fetch(usedParkingTicket);
        //then
        assertNull(fetchCarAgain);
    }


}
