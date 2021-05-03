package ru.interview.senchenko.autonumbers.service;

import org.springframework.stereotype.Service;
import ru.interview.senchenko.autonumbers.util.PlateNumber;

@Service
public class NumberService {

    private final PlateNumber plateNumber = new PlateNumber();

    public String generateRandomPlateNumber() {
        return plateNumber.getRandomPlateNumber();
    }

    public String getNextPlateNumber() {
        return plateNumber.getNextPlateNumber();
    }
}
