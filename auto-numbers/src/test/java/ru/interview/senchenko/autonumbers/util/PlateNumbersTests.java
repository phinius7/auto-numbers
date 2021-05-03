package ru.interview.senchenko.autonumbers.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlateNumbersTests {
    private static final int FINAL_LENGTH = 14;
    private static final String NEXT_PLATE = "А002АА 116 RUS";

    @Test
    public void testFirstNextPlateNumber() {
        PlateNumber plateNumber = new PlateNumber();
        String testResult = plateNumber.getNextPlateNumber();
        assertEquals(testResult, NEXT_PLATE);
    }

    @Test
    public void testRandomPlatesLength() {
        PlateNumber plateNumber = new PlateNumber();
        String testResult = plateNumber.getRandomPlateNumber();
        assertTrue(testResult.contains(" 116 RUS"));
        assertEquals(testResult.length(), FINAL_LENGTH);
    }
}
