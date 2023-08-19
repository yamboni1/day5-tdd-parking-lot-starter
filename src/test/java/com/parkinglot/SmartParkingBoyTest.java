package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SmartParkingBoyTest {
    @Test
    void should_park_to_first_parking_lot_when_park_given_is_smart_parking_boy_two_parking_lot_with_equal_available_position_and_a_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = List.of(firstParkingLot,secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);

        Car carToBeParked = new Car();
        //when
        ParkingLotTicket parkingLotTicket = smartParkingBoy.park(carToBeParked);
        //then
        assertNotNull(parkingLotTicket);
        assertEquals(9, firstParkingLot.getAvailableCapacity());
        assertEquals(10, secondParkingLot.getAvailableCapacity());
    }
    @Test
    void should_park_to_second_parking_lot_when_park_given_is_smart_parking_boy_two_parking_lots_first_parkingLot_is_full_and_a_car() {
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
    @Test
    void should_return_right_car_when_fetch_given_is_smart_parking_boy_two_parking_lots_two_parking_tickets_and_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();

        Car firstCar = new Car();
        Car secondCar = new Car();

        List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        ParkingLotTicket firstParkingLotTicket = smartParkingBoy.park(firstCar);
        ParkingLotTicket secondParkingLotTicket = smartParkingBoy.park(secondCar);
        //when
        Car firstFetchedCar = smartParkingBoy.fetch(firstParkingLotTicket);
        Car secondFetchedCar = smartParkingBoy.fetch(secondParkingLotTicket);
        //then
        assertEquals(firstFetchedCar, firstCar);
        assertEquals(secondFetchedCar, secondCar);
    }
}
