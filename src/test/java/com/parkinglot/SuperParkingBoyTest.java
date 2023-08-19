package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SuperParkingBoyTest {
    @Test
    void should_park_to_first_parking_lot_when_park_given_is_super_parking_boy_two_parking_lot_with_equal_available_position_and_a_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = List.of(firstParkingLot,secondParkingLot);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLotList);

        Car carToBeParked = new Car();
        //when
        ParkingLotTicket parkingLotTicket = superParkingBoy.park(carToBeParked);
        //then
        assertNotNull(parkingLotTicket);
        assertEquals(9, firstParkingLot.getAvailableCapacity());
        assertEquals(10, secondParkingLot.getAvailableCapacity());
    }
    @Test
    void should_park_to_second_parking_lot_when_park_given_is_super_parking_boy_two_parking_lots_first_parkingLot_is_full_and_a_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = List.of(firstParkingLot, secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        Car parkedCar = new Car();
        Car newCarToPark = new Car();
        firstParkingLot.park(parkedCar);

        //when
        ParkingLotTicket parkingLotTicketForNewCar = smartParkingBoy.park(newCarToPark);
        //then
        assertNotNull(parkingLotTicketForNewCar);
        assertEquals(0, firstParkingLot.getAvailableCapacity());
        assertEquals(9, secondParkingLot.getAvailableCapacity());
    }

}