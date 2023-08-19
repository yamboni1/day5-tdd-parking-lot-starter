package com.parkinglot;

import com.parkinglot.exception.UnrecognizedParkingTicketException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = List.of(firstParkingLot, secondParkingLot);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);
        Car parkedCar = new Car();
        Car newCarToPark = new Car();
        firstParkingLot.park(parkedCar);

        //when
        ParkingLotTicket parkingLotTicketForNewCar = standardParkingBoy.park(newCarToPark);
        //then
        assertNotNull(parkingLotTicketForNewCar);
        assertEquals(0, firstParkingLot.getAvailableCapacity());
        assertEquals(9, secondParkingLot.getAvailableCapacity());
    }


    @Test
    void should_return_right_car_when_fetch_given_is_standard_parking_boy_two_parking_lots_two_parking_tickets_and_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();

        Car firstCar = new Car();
        Car secondCar = new Car();

        List<ParkingLot> parkingLots = List.of(firstParkingLot, secondParkingLot);

        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);

        ParkingLotTicket firstParkingLotTicket = standardParkingBoy.park(firstCar);
        ParkingLotTicket secondParkingLotTicket = standardParkingBoy.park(secondCar);
        //when
        Car firstFetchedCar = standardParkingBoy.fetch(firstParkingLotTicket);
        Car secondFetchedCar = standardParkingBoy.fetch(secondParkingLotTicket);
        //then
        assertEquals(firstFetchedCar, firstCar);
        assertEquals(secondFetchedCar, secondCar);
    }
    @Test
    void should_return_unrecognized_parking_ticket_when_fetch_given_is_standard_parking_boy_two_parkingLots_parked_cars_two_parking_tickets() {
    //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = List.of(firstParkingLot, secondParkingLot);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);
        ParkingLotTicket wrongParkingTicket = new ParkingLotTicket();

        //when
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () -> {
            standardParkingBoy.fetch(wrongParkingTicket);
        });

        //then
        assertEquals("Unrecognized parking ticket.",unrecognizedParkingTicketException.getMessage());

    }

}

