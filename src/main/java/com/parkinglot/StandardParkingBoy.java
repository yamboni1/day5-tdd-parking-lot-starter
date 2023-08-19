package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;
import java.util.List;

public class StandardParkingBoy{
    private List<ParkingLot> parkingLotList;

    private Car car;


    public StandardParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }


    public ParkingLotTicket park(Car car) {
        for(ParkingLot parkingLot : parkingLotList){
            if(parkingLot.getAvailableCapacity() > 0){
                return parkingLot.park(car);
            }
        } return null;

    }



    public Car fetch(ParkingLotTicket parkingLotTicket) {
        return parkingLotList.stream()
                .map(parkingLot -> parkingLot.fetch(parkingLotTicket))
                .filter(car -> car != null)
                .findFirst()
                .orElse(null);

    }
}

