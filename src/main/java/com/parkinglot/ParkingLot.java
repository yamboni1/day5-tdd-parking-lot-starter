package com.parkinglot;

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
            return null;

        }
        ParkingLotTicket parkingLotTicket = new ParkingLotTicket();
        carAndTicketMap.put(parkingLotTicket, car);
        return parkingLotTicket;
    }

    public Car fetch(ParkingLotTicket parkingLotTicket) {
        Car parkedCar = carAndTicketMap.get(parkingLotTicket);
        carAndTicketMap.remove(parkingLotTicket);
        return parkedCar;

    }


}
