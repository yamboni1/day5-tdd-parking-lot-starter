package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.exception.UnrecognizedParkingTicketException;

import java.util.HashMap;
import java.util.Map;


public class ParkingLot {
    private static final int PARKING_LOT_SIZE = 10;
    private final int capacity;

    public ParkingLot(int capacity) {

        this.capacity = capacity;
    }

    public ParkingLot() {

        capacity = 10;
    }

    private final Map<ParkingLotTicket, Car> ticketCarMap = new HashMap<>();

    public ParkingLotTicket park(Car car) {
        if (capacity == ticketCarMap.size()) {
            throw new NoAvailablePositionException();
        }
        ParkingLotTicket parkingLotTicket = new ParkingLotTicket();
        ticketCarMap.put(parkingLotTicket, car);
        return parkingLotTicket;
    }

    public Car fetch(ParkingLotTicket parkingLotTicket) {
        if (ticketCarMap.containsKey(parkingLotTicket)) {
            throw new UnrecognizedParkingTicketException();
        }

        return ticketCarMap.remove(parkingLotTicket);

    }


}
