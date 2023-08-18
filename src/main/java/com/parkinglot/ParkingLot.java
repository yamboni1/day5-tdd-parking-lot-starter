package com.parkinglot;

import java.util.HashMap;


public class ParkingLot {
    private HashMap<ParkingLotTicket, Car> carsWithParkingLotTicket = new HashMap<>();
    public ParkingLotTicket park(Car car) {
        ParkingLotTicket parkingLotTicket = new ParkingLotTicket();
        carsWithParkingLotTicket.put(parkingLotTicket, car);
        return parkingLotTicket;
    }

    public Car fetch(ParkingLotTicket parkingLotTicket) {
        Car parkedCar = carsWithParkingLotTicket.get(parkingLotTicket);
        return parkedCar;

    }





    public ParkingLotTicket getParkingLotTicketOfCar(ParkingLotTicket parkingLotTicket) {
        return carsWithParkingLotTicket.get(parkingLotTicket).getParkingLotTicketForCar();
    }
}
