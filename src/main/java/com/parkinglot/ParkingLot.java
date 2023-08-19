package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.exception.UnrecognizedParkingTicketException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ParkingLot {

    private static final int PARKING_LOT_SIZE = 10;
    private List<ParkingLot> parkingLotList;
    private final int capacity;

    public ParkingLot(int capacity) {

        this.capacity = capacity;
    }

    public ParkingLot() {
        this.ticketCarMap = new HashMap<>();
        capacity = PARKING_LOT_SIZE;
    }


    private Map<ParkingLotTicket, Car> ticketCarMap = new HashMap<>();

    public ParkingLotTicket park(Car car) {
         if (isParkingLotCapacityFull()) {
            throw new NoAvailablePositionException();
        }
        ParkingLotTicket parkingLotTicket = new ParkingLotTicket();
        ticketCarMap.put(parkingLotTicket, car);
        return parkingLotTicket;
    }

    private boolean isParkingLotCapacityFull() {
        return capacity == ticketCarMap.size();
    }

    public Car fetch(ParkingLotTicket parkingLotTicket) {
        if (!ticketCarMap.containsKey(parkingLotTicket)) {
            throw new UnrecognizedParkingTicketException();
        }

        return ticketCarMap.remove(parkingLotTicket);

    }
    public double getAvailablePositionRate(){
        return (double) getAvailableCapacity() /capacity;
    }



    public int getAvailableCapacity() {
        return capacity - ticketCarMap.size();
    }

}
