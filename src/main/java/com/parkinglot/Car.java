package com.parkinglot;

public class Car {
    ParkingLotTicket parkingLotTicket;
    public void setParkingLotTicket(ParkingLotTicket parkingLotTicket) {
        this.parkingLotTicket = parkingLotTicket;
    }
    public ParkingLotTicket getParkingLotTicketForCar(){
        return parkingLotTicket;
    }
}
