package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.exception.UnrecognizedParkingTicketException;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy {
    private List<ParkingLot> parkingLotList;
    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public ParkingLotTicket park(Car car) {
        return parkingLotList.stream()
                .max(Comparator.comparingInt(ParkingLot::getAvailableCapacity))
                .orElseThrow(NoAvailablePositionException::new)
                .park(car);

    }

    public Car fetch(ParkingLotTicket parkingLotTicket) {
        for(ParkingLot parkingLot : parkingLotList){
            try{
                return parkingLot.fetch(parkingLotTicket);
            }catch (UnrecognizedParkingTicketException ignored){
                parkingLotList.isEmpty();
            }

            }
            throw new UnrecognizedParkingTicketException();

        }


}
