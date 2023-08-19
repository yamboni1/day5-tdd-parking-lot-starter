package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;

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
}
