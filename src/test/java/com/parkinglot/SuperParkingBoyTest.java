package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.exception.UnrecognizedParkingTicketException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot();

        firstParkingLot.park(new Car());
        firstParkingLot.park(new Car());
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(List.of(firstParkingLot, secondParkingLot));
        Car parkedCar = new Car();


        //when
        ParkingLotTicket parkingLotTicket = superParkingBoy.park(parkedCar);
        //then
        assertEquals(0, firstParkingLot.getAvailableCapacity());
        assertEquals(9, secondParkingLot.getAvailableCapacity());
        assertEquals(parkedCar,secondParkingLot.fetch(parkingLotTicket));
        
    }
    @Test
    void should_return_the_right_car_when_fetch_given_super_parking_boy_many_parking_lots_all_with_parked_car_parkinglot_ticket() {
    //given
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = List.of(firstParkingLot, secondParkingLot);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLotList);
        Car parkedCar1 = new Car();
        Car parkedCar2 = new Car();
        ParkingLotTicket parkedCar1Ticket = superParkingBoy.park(parkedCar1);
        ParkingLotTicket parkedCar2Ticket = superParkingBoy.park(parkedCar2);
        //when
        Car fetchedCar1 = superParkingBoy.fetch(parkedCar1Ticket);
        Car fetchedCar2 = superParkingBoy.fetch(parkedCar2Ticket);


        //then
        assertEquals(parkedCar1,fetchedCar1);
        assertEquals(parkedCar2, fetchedCar2);
    }
    @Test
    void should_return_unrecognized_parking_ticket_when_fetch_given_is_super_parking_boy_two_parkingLots_parked_cars_parking_tickets() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = List.of(firstParkingLot, secondParkingLot);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLotList);
        ParkingLotTicket wrongParkingTicket = new ParkingLotTicket();

        //when
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () -> superParkingBoy.fetch(wrongParkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.",unrecognizedParkingTicketException.getMessage());

    }
    @Test
    void should_return_unrecognized_parking_ticket_when_fetch_given_is_super_parking_boy_two_parking_lots_parked_cars_used_parking_ticket_and_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = List.of(firstParkingLot, secondParkingLot);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLotList);
        Car parkedCar = new Car();
        ParkingLotTicket usedParkingLotTicket = superParkingBoy.park(parkedCar);

        //when
        superParkingBoy.fetch(usedParkingLotTicket);
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () -> superParkingBoy.fetch(usedParkingLotTicket));

        //then
        assertEquals("Unrecognized parking ticket.",unrecognizedParkingTicketException.getMessage());

    }
    @Test
    void should_return_noAvailablePositionException_when_park_given_is_super_parking_boy_two_full_parking_lots_and_a_car() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLotList = List.of(firstParkingLot, secondParkingLot);
        Car parkedCar1 = new Car();
        Car parkedCar2 = new Car();
        Car carToPark = new Car();
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLotList);
        superParkingBoy.park(parkedCar1);
        superParkingBoy.park(parkedCar2);

        //when
        NoAvailablePositionException noAvailablePositionException = assertThrows(NoAvailablePositionException.class, () -> superParkingBoy.park(carToPark));
        //then
        assertEquals("No available position.", noAvailablePositionException.getMessage());

    }



}


