package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StandardParkingBoyTest {
    @Test
    void should_park_to_first_parkingLot_when_park_given_is_standard_parking_boy_two_parking_lots_and_a_car() {
    //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = List.of(firstParkingLot);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);
        Car carToBeParked = new Car();
        //when
        ParkingLotTicket parkingLotTicket = standardParkingBoy.park(carToBeParked);
     //then
        assertNotNull(parkingLotTicket);
        assertEquals(9, firstParkingLot.getAvailableCapacity());
        assertEquals(10, secondParkingLot.getAvailableCapacity());
    }
    @Test
    void should_park_to_second_parking_lot_when_park_given_is_standard_parking_boy_two_parking_lots_first_parkingLot_is_full_and_a_car() {
        //given
        ParkingLot fullParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = List.of(fullParkingLot, secondParkingLot);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);
        Car parkedCar = new Car();
        Car newCarToPark = new Car();
        fullParkingLot.park(parkedCar);

        //when
        ParkingLotTicket parkingLotTicketForNewCar = standardParkingBoy.park(newCarToPark);
        //then
        assertNotNull(parkingLotTicketForNewCar);
        assertEquals(0,fullParkingLot.getAvailableCapacity());
        assertEquals(9,secondParkingLot.getAvailableCapacity());
    }

}
