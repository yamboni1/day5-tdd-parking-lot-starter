package com.parkinglot;

public class ParkingLot {
    public ParkingLotTicket park(Car car) {
        ParkingLotTicket parkingLotTicket = new ParkingLotTicket();
        car.setParkingLotTicket(parkingLotTicket);
        return parkingLotTicket;
    }
}
