package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.exception.UnrecognizedParkingTicketException;

import java.util.HashMap;


public class ParkingLot {
    private static final int PARKING_LOT_SIZE = 10;
    private final int capacity;

    public ParkingLot(int capacity){

        this.capacity = capacity;
    }
    public ParkingLot(){

        capacity = 10;
    }
    private HashMap<ParkingLotTicket, Car> carAndTicketMap = new HashMap<>();
    public ParkingLotTicket park(Car car) {
        if(carAndTicketMap.size()== capacity){
            throw new NoAvailablePositionException();

        }
        ParkingLotTicket parkingLotTicket = new ParkingLotTicket();
        carAndTicketMap.put(parkingLotTicket, car);
        return parkingLotTicket;
    }

    public Car fetch(ParkingLotTicket parkingLotTicket) {
        if(carAndTicketMap.get(parkingLotTicket) == null){
            throw new UnrecognizedParkingTicketException();
        }

        return carAndTicketMap.remove(parkingLotTicket);

    }


}
