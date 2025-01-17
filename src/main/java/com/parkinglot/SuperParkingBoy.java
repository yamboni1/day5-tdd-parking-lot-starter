package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.exception.UnrecognizedParkingTicketException;

import java.util.Comparator;
import java.util.List;

public class SuperParkingBoy {
    private final List<ParkingLot> parkingLotList;


    public SuperParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public ParkingLotTicket park(Car car) {

        return parkingLotList.stream()
                .max(Comparator.comparingDouble(ParkingLot::getAvailablePositionRate))
                .orElseThrow(NoAvailablePositionException::new)
                .park(car);

    }


    public Car fetch(ParkingLotTicket parkingLotTicket) {
        for(ParkingLot parkingLot : parkingLotList){
            try{
                return parkingLot.fetch(parkingLotTicket);
            }catch (UnrecognizedParkingTicketException ignored){
            }

        }
        throw new UnrecognizedParkingTicketException();


    }
}
