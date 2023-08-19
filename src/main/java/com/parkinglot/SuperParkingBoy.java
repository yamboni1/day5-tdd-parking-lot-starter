package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;

import java.util.Comparator;
import java.util.List;

public class SuperParkingBoy {
    private List<ParkingLot> parkingLotList;
    public SuperParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public ParkingLotTicket park(Car car) {
        return parkingLotList.stream()
                .max(Comparator.comparingDouble(ParkingLot::getAvailablePositionRate))
                .orElseThrow(NoAvailablePositionException::new)
                .park(car);

    }
}
