package com.parkinglot;

import java.util.HashMap;


public class ParkingLot {
    private HashMap<ParkingLotTicket, Car> carAndTicketMap = new HashMap<>();
    public ParkingLotTicket park(Car car) {
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
